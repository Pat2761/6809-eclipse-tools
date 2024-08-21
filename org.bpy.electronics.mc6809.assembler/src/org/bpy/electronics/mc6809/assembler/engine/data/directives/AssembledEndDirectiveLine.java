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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about END directive
 * 
 * @author Patrick BRIAND
 */
public class AssembledEndDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the END directive in the edited file */
	private EndDirective directive;
	/** Target value */
	private int targetAddress;
	
	/**
	 * Constructor of the class
	 */
	public AssembledEndDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the END directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	@Override
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (EndDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);
	}

	@Override
	public void parsePass2() {
		targetAddress = 0;
		if (directive.getOperand() != null) {
			try {
				this.targetAddress = ExpressionParser.parseIdentifer(directive, 
						AssemblerPackage.eINSTANCE.getEndDirective_Operand(), directive.getOperand());
			} catch (UnresolvedException e) {
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						e.getDescriptor().getMessage(), 
						e.getDescriptor().getReference(), 
						InstructionValidator.EXPRESSION_ERROR);
				AssemblerErrorManager.getInstance().addProblem(this.directive, errorDescription);
				
				targetAddress = 0;
			}
		}
	}

	/**
	 * Get the reference on the the directive.
	 * 
	 * @return reference on the directive
	 */
	public EndDirective getDirective() {
		return directive;
	}

	/**
	 * Set the reference on the directive.
	 * 
	 * @param directive reference on the directive
	 */
	public void setDirective(EndDirective directive) {
		this.directive = directive;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

	/**
	 * Return address defined by the directive.
	 * 
	 * @return address defined by the directive
	 */
	public int getTargetAddress() {
		return targetAddress;
	}

	@Override
	public boolean canDisplayPcAddress() {
		return false;
	}
}
