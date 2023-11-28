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
package org.bpy.electronics.mc6809.assembler.engine.data;

/**
 * Abstract class which defined the common attributes of an instruction
 * 
 * @author briand
 *
 */
public abstract class AbstractInstructionAssemblyLine extends AbstractAssemblyLine {

	/**
	 * Return the opcode of the instruction
	 * @return opcode of the instruction
	 */
	public abstract byte[] getOpcode();
	
	/**
	 * return the operand of the instruction
	 * @return operand of the instruction
	 */
	public abstract byte[] getOperand(); 
	
	/**
	 * Return the number of cycles for an instruction
	 * @return number of cycles for the instruction
	 */
	public abstract int getCyclesNumber();
}
