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
package org.bpy.electronics.mc6809.assembler.engine.data.directives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.StringValue;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about FCC directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledFccDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the FCC directive in the edited file */
	private FccDirective directive;
	/** Integer value defined by the FCC directive */ 
	private int[] values;	
	/**
	 * Constructor of the class
	 */
	public AssembledFccDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the FCC directive
	 * @param currentPcValu;e value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (FccDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);

		reserveMemorySpace(this.directive.getParameters());
	}

	/**
	 * Compute and allocate space for store data defined in the operand.
	 * 
	 * @param parameters list of parameters
	 */
	private void reserveMemorySpace(EList<EObject> parameters) {
		int size = 0;
		
		for (EObject parameter : parameters) {
			if (parameter instanceof StringValue stringValue) {
				size += stringValue.getValue().length();
			} else if (parameter instanceof Expression) {
				size++;
			}
		}
		
		values = new int[size];
		Arrays.fill(values, 0);
	}

	@Override
	public void parsePass2() {
		// Parse the values
		List<Byte> parseValues = new ArrayList<>(); 
		for (EObject parameter : this.directive.getParameters()) {
			if (parameter instanceof StringValue stringValue) {
				byte[] bytes = stringValue.getValue().getBytes();
				for (int i=0; i<bytes.length; i++) {
					parseValues.add(bytes[i]);
				}
			} else if (parameter instanceof Expression expression) {
				int expressionValue;
				try {
					expressionValue = ExpressionParser.resolveExpression(expression.getOperand());
					if ((expressionValue&0xFFFFF) != 0) {
						AssemblerWarningDescription warningDescription = new AssemblerWarningDescription("Overflow error, Data may be lost",
								AssemblerPackage.eINSTANCE.getFccDirective_Parameters(),
								InstructionValidator.OVERFLOW_ERROR);
						AssemblerErrorManager.getInstance().addWarning(directive, warningDescription);

					}
					parseValues.add((byte)(expressionValue&0xFF));
				} catch (UnresolvedException e) {
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							e.getDescriptor().getMessage(), 
							e.getDescriptor().getReference(), 
							InstructionValidator.EXPRESSION_ERROR);
					AssemblerErrorManager.getInstance().addProblem(directive, errorDescription);
				}
			}
		}
		int i=0;
		for (int value : parseValues) {
			values[i] = value;
			i++;
		}
	}

	/**
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public FccDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(FccDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get defined values.
	 *  
	 * @return values
	 */
	public int[] getValues() {
		return values;
	}

	@Override
	public int getPcIncrement() {
		return values.length;
	}
}
