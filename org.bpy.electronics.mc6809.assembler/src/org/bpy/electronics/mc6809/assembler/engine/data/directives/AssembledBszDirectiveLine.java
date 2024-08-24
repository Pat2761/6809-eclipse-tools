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

import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about BSZ directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledBszDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the BSZ directive in the edited file */
	private BszDirective directive;
	/** Integer value defined by the EQU directive */ 
	private int[] values;	
	/** Integer value defined the number of byte */ 
	private int nbBytes;	

	/**
	 * Constructor of the class
	 */
	public AssembledBszDirectiveLine(AssemblerEngine engine) {
		super(engine);
	}

	/**
	 * Extract information from the edited line.
	 * The expression can only refer the identifier of type EQU or SET
	 * 
	 * @param directive reference to the Xtext description of the BSZ directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	@Override
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (BszDirective)directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);
		
		try {
			nbBytes = ExpressionParser.parse(assemblerEngine, this.directive);
			if (nbBytes<0) {
				values = new int[0];
			} else {
				values = new int[nbBytes];
				for (int i=0; i<nbBytes; i++) {
					values[i] = 0;
				}
			}
		} catch (UnresolvedException e) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					e.getDescriptor().getMessage(), 
					e.getDescriptor().getReference(), 
					InstructionValidator.EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(this.directive, errorDescription);
		}
	}

	@Override
	public void parsePass2() {
		// Nothing to do here
	}

	/** 
	 * return the number of bytes reserved.
	 * 
	 * @return number of bytes reserved
	 */
	public int getNbBytes() {
		return nbBytes;
	}

	/**
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public BszDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(BszDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get values
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

	@Override
	public boolean canDisplayPcAddress() {
		return true;
	}

	@Override
	public String getDirectiveName() {
		return directive.getDirective();
	}
}
