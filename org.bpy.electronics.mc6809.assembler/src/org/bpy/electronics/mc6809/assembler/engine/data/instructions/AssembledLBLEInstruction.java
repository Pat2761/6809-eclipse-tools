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

import org.bpy.electronics.mc6809.assembler.assembler.BleInstruction;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

/**
 * Allow to parse an LBLE Instruction
 * 
 * @author briand
 *
 */
public class AssembledLBLEInstruction extends AbstractRelativeBranchInstruction {

	/** Reference on the instruction */
	private BleInstruction instruction;
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parse(BleInstruction instruction, int currentPcValue, int lineNumber) {
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
	public BleInstruction getInstruction() {
		return instruction;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		opcodeBytes =  new int[] {0x10, 0x2F};
	}

	@Override
	public void setOperand(AddressingMode mode) {
	}

	@Override
	public void setCyclesNumber(AddressingMode mode) {
		this.cyclesNumber = 3;
	}

	@Override
	public Object getInstructionOperand() {
		return null;
	}

	@Override
	protected Object getLocalInstruction() {
		return instruction;
	}
}
