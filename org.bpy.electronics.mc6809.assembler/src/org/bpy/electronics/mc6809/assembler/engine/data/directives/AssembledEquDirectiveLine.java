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

import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.engine.EquSetManager;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about EQU directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledEquDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the EQU directive in the edited file */
	private EquDirective directive;
	/** Integer value defined by the EQU directive */ 
	private int value;	
	
	/**
	 * Constructor of the class
	 */
	public AssembledEquDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the EQU directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	@Override
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (EquDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		
		try {
			this.value = ExpressionParser.parse(this.directive);
			EquSetManager.getInstance().setValue(label, value);
		} catch (UnresolvedException e) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					e.getDescriptor().getMessage(), 
					e.getDescriptor().getReference(), 
					InstructionValidator.EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(directive, errorDescription);
		}
	}

	@Override
	public void parsePass2() {
		// Nothing to do here
	}

	/**
	 * Get the reference on the the directive.
	 * 
	 * @return reference on the directive
	 */
	public EquDirective getDirective() {
		return directive;
	}

	/**
	 * Set the reference on the directive.
	 * 
	 * @param directive reference on the directive
	 */
	public void setDirective(EquDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get the value defined by this directive.
	 * 
	 * @return Equ value
	 */
	public int getValue() {
		return value;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

	/**
	 * Set the value defined by this directive.
	 * 
	 * @param value value of the EQU
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public boolean canDisplayPcAddress() {
		return false;
	}
	
}
