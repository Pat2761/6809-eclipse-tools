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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

/**
 * Allow to parse an PULU Instruction
 * 
 * @author briand
 *
 */
public class AssembledPULUInstruction extends AbstractInstructionAssemblyLine {

	/** Reference on the instruction */
	private PuluInstruction instruction;
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parse(PuluInstruction instruction, int currentPcValue, int lineNumber) {
		this.label = CommandUtil.getLabel(instruction);
		this.comment = CommandUtil.getComment(instruction);
		this.instruction = instruction;
		super.parse(currentPcValue, lineNumber);
	}

	/**
	 * Return the reference on the editor instruction line.
	 * 
	 * @return reference on the editor instruction line.
	 */
	public PuluInstruction getInstruction() {
		return instruction;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		opcodeBytes =  new int[] {0x37};
	}

	@Override
	public void setOperand(AddressingMode mode) {
		if (instruction.getOperand() != null) {
			Integer convertedValue = AssemblerEngine.getInstance().getRegDefintionValue(instruction.getOperand().getValue());
			if (convertedValue != null) {
				operandBytes = new int[] {convertedValue&0xFF};
			} else {
				opcodeBytes =  new int[] {0x3F};
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						"REG " + instruction.getOperand().getValue() + " directive is not defined" , 
						AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND, 
						InstructionValidator.MISSING_DIRECTIVE);
				AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
			}
			
		} else if (instruction.getRegisters() != null) {
			int convertedValue = getRegisterConvertionValue(instruction.getRegisters());
			operandBytes = new int[] {convertedValue&0xFF};
		}
	}

	@Override
	public void setCyclesNumber(AddressingMode mode) {
		this.cyclesNumber = 3;
	}

	@Override
	public Object getInstructionOperand() {
		return null;
	}
}
