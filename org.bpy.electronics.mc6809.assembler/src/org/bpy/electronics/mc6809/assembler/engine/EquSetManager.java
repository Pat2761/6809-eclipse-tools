/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Manage the EQU and SET values
 * 
 * @author Patrick BRIAND
 *
 */
public class EquSetManager {

	/** Logger of the class */
	private static final Logger looger = Logger.getLogger(EquSetManager.class.getSimpleName()); 

	/** 
	 * 
	 * 
	 * @author Patrick BRIAND
	 *
	 */
	public class EquDefinitionContainer {
		
		/** Directive of type EQU */
		public static final int EQU_DEFINITION = 0;
		/** Directive of type SET */
		public static final int SET_DEFINITION = 1;
		/** Directive of type REG */
		public static final int REG_DEFINITION = 2;
		
		/** Set to true if the expression is resolved */
		private boolean isExpressionResolved;

		/** memorize the reference to the expression */
		private Expression expression;
		
		/** Reference to the current directive */
		private EObject directive;

		/** Parse value */
		private int value;
		
		/** Type of object */
		private int EquType; 

		/** indicate if is active Only use in case of SET directive */
		private boolean isActive;

		/** 
		 * Indicate if the SET directive is active. 
		 * 
		 * @return <b>true</b> active SET directive, <b>false</b> otherwise
		 */
		public boolean isActive() {
			return isActive;
		}

		/** 
		 * SET directive active. 
		 */
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		/** 
		 * Return the state of the expression. 
		 * 
		 * @return <b>true</b> if the expression is resolved, <b>false</b> otherwise
		 */
		public boolean isExpressionResolved() {
			return isExpressionResolved;
		}

		/**
		 * Set the state of the expression.
		 * 
		 * @param isExpressionResolved state of the expression
		 */
		public void setExpressionResolved(boolean isExpressionResolved) {
			this.isExpressionResolved = isExpressionResolved;
		}

		/**
		 * Get the reference of the expression.
		 * 
		 * @return reference on the expression
		 */
		public Expression getExpression() {
			return expression;
		}

		/**
		 * Get the reference of the expression.
		 * 
		 * @param expression Reference of the expression.
		 */
		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		/**
		 * Get the reference on the directive.
		 * 
		 * @return reference on the directive
		 */
		public EObject getDirective() {
			return directive;
		}

		/**
		 * Set the reference on the directive.
		 * 
		 * @param directive reference on the directive
		 */
		public void setDirective(EObject directive) {
			this.directive = directive;
		}

		/**
		 * Get the value of the expression.
		 * 
		 * @return value of the expression
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Set the value of the expression.
		 * 
		 * @param value value of the expression
		 */
		public void setValue(int value) {
			this.value = value;
		}

		/**
		 * Get the type of object.
		 * 
		 * @return type of object (EQU , SET or REG)
		 */
		public int getEquType() {
			return EquType;
		}

		/**
		 * Set the type of object.
		 * 
		 * @param equType type of object (EQU , SET or REG)
		 */
		public void setEquType(int equType) {
			EquType = equType;
		}
		
	}
	
	/** Collection of EQU, SET and REG */
	private Map<String, List<EquDefinitionContainer>> equContainer;
	
	/** Instance on the singleton */
	private static EquSetManager eInstance;
	
	/**
	 * Constructor of the class.
	 * 
	 */
	private EquSetManager() {
		clear();
	}

	/** 
	 * Return the instance of the singleton.
	 * 
	 * @return instance of the singleton 
	 */
	public static EquSetManager getInstance() {
		if (eInstance == null) {
			eInstance = new EquSetManager();
		}
		return eInstance;
	}

	/** 
	 * Initialize fields
	 */
	public void clear() {
		equContainer = new HashMap<>();
	}
	
	/**
	 * Add an EQU directive in the collection.
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	public void addDirective(EquDirective equDirective) {
		
		String labelName = CommandUtil.getLabel(equDirective);

		if (!equContainer.containsKey(labelName) ) {
			EquDefinitionContainer equDefinition = new EquDefinitionContainer();
			equDefinition.setDirective(equDirective);
			equDefinition.setExpression(equDirective.getOperand());
			equDefinition.setExpressionResolved(false);
			equDefinition.setEquType(EquDefinitionContainer.EQU_DEFINITION);

			List<EquDefinitionContainer> list = new ArrayList<>();
			list.add(equDefinition);
			equContainer.put(labelName, list);
	
		} else {

			List<EquDefinitionContainer> directives = equContainer.get(labelName);
			EquDefinitionContainer equDefinition = directives.get(0);
			if (equDefinition.getEquType() == EquDefinitionContainer.SET_DEFINITION) {
				AssemblerWarningDescription warningDescription = new AssemblerWarningDescription(
						"The label " + labelName + " for an EQU directive is already defined by a SET directive", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
						InstructionValidator.DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addWarning(equDirective.eContainer(), warningDescription);
			
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + labelName + " for an EQU directive is already defined", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
						InstructionValidator.DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(equDirective.eContainer(), problemDescription );
			}
		}
	}

	/**
	 * Add a REG directive.
	 * 
	 * @param regDirective reference on the REG directive
	 */
	public void addDirective(RegDirective regDirective) {
		
		String labelName = CommandUtil.getLabel(regDirective);

		if (!equContainer.containsKey(labelName) ) {
			EquDefinitionContainer equDefinition = new EquDefinitionContainer();
			equDefinition.setDirective(regDirective);
			equDefinition.setExpressionResolved(false);
			equDefinition.setEquType(EquDefinitionContainer.REG_DEFINITION);
			equDefinition.setActive(true);
			
			List<EquDefinitionContainer> list = new ArrayList<>();
			list.add(equDefinition);
			equContainer.put(labelName, list);
	
		} else {

			List<EquDefinitionContainer> directives = equContainer.get(labelName);
			EquDefinitionContainer equDefinition = directives.get(0);
			AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
					"The label " + labelName + " for an REG directive is already defined", 
					AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
					InstructionValidator.DUPLICATE_LABEL);
			AssemblerErrorManager.getInstance().addProblem(regDirective.eContainer(), problemDescription );
		}
	}
	
	/**
	 * Add a SET directive.
	 * 
	 * @param setDirective reference on the SET directive
	 */
	public void addDirective(SetDirective setDirective) {
		String labelName = CommandUtil.getLabel(setDirective);
		
		if (equContainer.containsKey(labelName)) {
			List<EquDefinitionContainer> definitions = equContainer.get(labelName);
			EquDefinitionContainer definition = definitions.get(0); 
			
			if (definition.getEquType() == EquDefinitionContainer.EQU_DEFINITION) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + labelName + " for an SET directive is already defined", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
						InstructionValidator.DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(setDirective.eContainer(), problemDescription );
		
			} else {
				EquDefinitionContainer setDefinition = new EquDefinitionContainer();
				setDefinition.setDirective(setDirective);
				setDefinition.setExpression(setDirective.getOperand());
				setDefinition.setExpressionResolved(false);
				setDefinition.setEquType(EquDefinitionContainer.SET_DEFINITION);
				
				definitions.add(setDefinition);
			}
 			
		} else {
			EquDefinitionContainer setDefinition = new EquDefinitionContainer();
			setDefinition.setDirective(setDirective);
			setDefinition.setExpression(setDirective.getOperand());
			setDefinition.setExpressionResolved(false);
			setDefinition.setEquType(EquDefinitionContainer.SET_DEFINITION);

			List<EquDefinitionContainer> definitions = new ArrayList<>();
			definitions.add(setDefinition);
			equContainer.put(labelName, definitions);
		}
	}

	/**
	 * Return the reference on a store directive.
	 * 
	 * @param label Key on the collection (Value of the label)
	 * @return reference on the directive,<b>null</b> if not found
	 */
	public EObject getInstruction(String label) {
		if (equContainer.containsKey(label)) {
			List<EquDefinitionContainer> directives = equContainer.get(label);
			return directives.get(0).getDirective();
		}
		return null;
	}
	
	/** 
	 * Define set SET directive active
	 * 
	 * @param directive reference on the directive
	 */
	public void setSetActive(SetDirective directive) {
		String label = CommandUtil.getLabel(directive);
		if (equContainer.containsKey(label)) {
			for (EquDefinitionContainer definitionContainer : equContainer.get(label)) {
				if (definitionContainer.getDirective() == directive) {
					definitionContainer.setActive(true);
				} else {
					definitionContainer.setActive(false);
				}
			}
		}
	}
	
	/**
	 * Get value associated to a label.
	 * 
	 * @param label Label value
	 * @return Integer value, <b>null</b> if not found
	 */
	public Integer getValue(String label) {
		if (equContainer.containsKey(label)) {
			 List<EquDefinitionContainer> containers = equContainer.get(label);
			 EquDefinitionContainer container = getActiveContainer(containers);
			 if (container.isExpressionResolved()) {
				 return container.getValue();
			 } else {
				 
					if (container.getEquType() == EquDefinitionContainer.EQU_DEFINITION) {
						resolveEquValue(container); 
						
					} else if (container.getEquType() == EquDefinitionContainer.SET_DEFINITION) {
						resolveSetValue(container); 
						
					} else if (container.getEquType() == EquDefinitionContainer.REG_DEFINITION) {
						resolveRegValue(container); 
					}
				
				 if (container.isExpressionResolved()) {
					 return container.getValue();
				 }
			 }
		}
		return null;
	}

	private EquDefinitionContainer getActiveContainer(List<EquDefinitionContainer> containers) {
		for (EquDefinitionContainer container : containers) {
			if (container.isActive()) {
				return container;
			}
		}
		return containers.get(0);
	}

	private void resolveRegValue(EquDefinitionContainer container) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Resolve value of an SET directive
	 * 
	 * @param containers reference on an element of the collection
	 */
	private void resolveSetValue(EquDefinitionContainer container) {
		
		SetDirective directive = (SetDirective)container.getDirective();
		try {
			int value = ExpressionParser.parse(directive);
			container.setValue(value);
			container.setExpressionResolved(true);
		} catch (UnresolvedException ex) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					ex.getDescriptor().getMessage(), 
					ex.getDescriptor().getReference(), 
					InstructionValidator.EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(container.getDirective(), errorDescription);
		}
	}

	/** 
	 * Resolve value of an EQU directive
	 * 
	 * @param container reference on an element of the collection
	 */
	private void resolveEquValue(EquDefinitionContainer container) {
		EquDirective directive = (EquDirective)container.getDirective();
		try {
			int value = ExpressionParser.parse(directive);
			container.setValue(value);
			container.setExpressionResolved(true);
		} catch (UnresolvedException ex) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					ex.getDescriptor().getMessage(), 
					ex.getDescriptor().getReference(), 
					InstructionValidator.EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(container.getDirective(), errorDescription);
		}
	}
}
