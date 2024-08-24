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

import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about SET directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledSetDirectiveLine extends AbstractAssembledDirectiveLine {

	/** Integer value defined by the EQU directive */ 
	private int value;	

	/** reference to the SET directive in the edited file */
	private SetDirective directive;

	/**
	 * Constructor of the class
	 */
	public AssembledSetDirectiveLine(AssemblerEngine engine) {
		super(engine);
	}

	/**
	 * Extract information from the edited line.
	 * This directive doesn't support forward address definition.
	 * 
	 * @param directive reference to the Xtext description of the SET directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (SetDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);
		
		try {
			this.value = ExpressionParser.parse(assemblerEngine, this.directive);
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
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public SetDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(SetDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get value.
	 *  
	 * @return value
	 */
	public Integer getValue() {
		return value;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

	@Override
	public boolean canDisplayPcAddress() {
		return false;
	}

	@Override
	public String getDirectiveName() {
		return directive.getDirective();
	}
}
