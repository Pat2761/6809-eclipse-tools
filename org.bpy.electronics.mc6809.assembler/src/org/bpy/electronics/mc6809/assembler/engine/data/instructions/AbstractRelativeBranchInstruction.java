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
package org.bpy.electronics.mc6809.assembler.engine.data.instructions;

import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Common for all relative branch instructions
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractRelativeBranchInstruction extends AbstractInstructionAssemblyLine {

	/** Short branch */
	public static final int BYTE_MODE = 0;
	/** Long branch */
	public static final int WORD_MODE = 1;
	
	/** 
	 * get the instruction reference
	 * 
	 * @return reference on the instruction
	 */
	abstract protected Object getLocalInstruction();
	
	/**
	 * Constructor of the class
	 * 
	 * @param engine reference on the assembler engine
	 */
	protected AbstractRelativeBranchInstruction(AssemblerEngine engine) {
		super(engine);
	}
	
	/**
	 * Compute the relative branch value
	 * 
	 * @param targetPcAddress Target of the branch
	 * @param mode define if it is a short branch or a long branch
	 * @param eReference EMF reference on the instruction
	 */
	public void computeOperand(int targetPcAddress, int mode, EStructuralFeature eReference) {
		int offset;
		int currentAddress = pcAddress+2;
		if (mode == WORD_MODE) {
			currentAddress = pcAddress+4;
		}
		
		if (targetPcAddress >= currentAddress) {
			offset = targetPcAddress-currentAddress; 
		} else {
			offset = (currentAddress-targetPcAddress)*(-1); 
		}

		if (mode == BYTE_MODE) {
			if (offset<-128 || offset>127) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Overflow error, you should use long branch",
						eReference,
						InstructionValidator.OVERFLOW_ERROR);
				AssemblerErrorManager.getInstance().addProblem(getLocalInstruction(), problemDescription );
				opcodeBytes[0] = 0x3F;
				operandBytes[0] = 0xFF;
			} else {
				operandBytes[0] = offset & 0xFF;
			}
			
		} else {
				
			if (offset>-129 && offset<128) {
				AssemblerWarningDescription warningDescription = new AssemblerWarningDescription("You can use a short branch",
						eReference,
						InstructionValidator.RELATIVE_SHORT_BRANCH);
				AssemblerErrorManager.getInstance().addWarning(getLocalInstruction(), warningDescription );
			}
			operandBytes[0]= (offset>>8) & 0xFF; 
			operandBytes[1]= offset & 0xFF;
		}
	}
}
