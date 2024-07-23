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
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
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
		
		private Expression expression;
		
		private EObject directive;

		private int value;
		
		private int EquType; 
		
		public boolean isExpressionResolved() {
			return isExpressionResolved;
		}

		public void setExpressionResolved(boolean isExpressionResolved) {
			this.isExpressionResolved = isExpressionResolved;
		}

		public Expression getExpression() {
			return expression;
		}

		public void setExpression(Expression expression) {
			this.expression = expression;
		}

		public EObject getDirective() {
			return directive;
		}

		public void setDirective(EObject directive) {
			this.directive = directive;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getEquType() {
			return EquType;
		}

		public void setEquType(int equType) {
			EquType = equType;
		}
		
	}
	
	private Map<String, List<EquDefinitionContainer>> equContainer;
	
	private static EquSetManager eInstance;
	
	public EquSetManager() {
		equContainer = new HashMap<>();
	}

	public static EquSetManager getInstance() {
		if (eInstance == null) {
			eInstance = new EquSetManager();
		}
		return eInstance;
	}
	
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

	public void addDirective(RegDirective regDirective) {
		
		String labelName = CommandUtil.getLabel(regDirective);

		if (!equContainer.containsKey(labelName) ) {
			EquDefinitionContainer equDefinition = new EquDefinitionContainer();
			equDefinition.setDirective(regDirective);
			equDefinition.setExpressionResolved(false);
			equDefinition.setEquType(EquDefinitionContainer.REG_DEFINITION);

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

	public EObject getInstruction(String label) {
		if (equContainer.containsKey(label)) {
			List<EquDefinitionContainer> directives = equContainer.get(label);
			return directives.get(0).getDirective();
		}
		return null;
	}
	
	public Integer getValue(String label) {
		return null;
	}
}
