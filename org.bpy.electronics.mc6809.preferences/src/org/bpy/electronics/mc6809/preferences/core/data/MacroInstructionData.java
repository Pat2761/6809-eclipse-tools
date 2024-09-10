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
package org.bpy.electronics.mc6809.preferences.core.data;

/**
 * Data container for the description of a macro instruction.
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroInstructionData {

	/** Macro instruction name */
	private String macroInstructionName;
	
	/** Equivalent instruction name */
	private String equivalentInstructionName;
	
	/** Equivalent operand */
	private String equivalentOperand;
	
	/** Opcode of the instruction */
	private byte[] opcode;
	
	/** Operand if the instruction */
	private byte[] operand;

	/**
	 * Get the macro instruction name.
	 * 
	 * @return macro instruction name
	 */
	public String getMacroInstructionName() {
		return macroInstructionName;
	}

	/**
	 * Set the macro instruction name.
	 * 
	 * @param macroInstructionName macro instruction name
	 */
	public void setMacroInstructionName(String macroInstructionName) {
		this.macroInstructionName = macroInstructionName;
	}

	/**
	 * Get the equivalent instruction name.
	 * 
	 * @return equivalent instruction name
	 */
	public String getEquivalentInstructionName() {
		return equivalentInstructionName;
	}

	/**
	 * Set the equivalent instruction name.
	 * 
	 * @param equivalentInstructionName equivalent instruction name
	 */
	public void setEquivalentInstructionName(String equivalentInstructionName) {
		this.equivalentInstructionName = equivalentInstructionName;
	}

	/**
	 * Get the equivalent operand
	 * 
	 * @return equivalent operand
	 */
	public String getEquivalenoperand() {
		return equivalentOperand;
	}

	/**
	 * Set the equivalent operand
	 * 
	 * @param equivalentOperand equivalent operand
	 */
	public void setEquivalentOperand(String equivalentOperand) {
		this.equivalentOperand = equivalentOperand;
	}

	/**
	 * Get the opcode of the macro instruction.
	 * 
	 * @return opcode of the macro instruction
	 */
	public byte[] getOpcode() {
		return opcode;
	}

	/**
	 * Set the opcode of the macro instruction.
	 * 
	 * @param opcode opcode of the macro instruction
	 */
	public void setOpcode(byte[] opcode) {
		this.opcode = opcode;
	}

	/**
	 * Get the operand of the macro instruction.
	 * 
	 * @return operand of the macro instruction
	 */
	public byte[] getOperand() {
		return operand;
	}

	/**
	 * Set the operand of the macro instruction.
	 * 
	 * @param operand operand of the macro instruction
	 */
	public void setOperand(byte[] operand) {
		this.operand = operand;
	}
}
