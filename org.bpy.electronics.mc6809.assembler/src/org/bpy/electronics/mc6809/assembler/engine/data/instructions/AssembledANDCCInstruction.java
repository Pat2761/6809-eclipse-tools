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

import java.util.EnumMap;

import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

/**
 * Allow to parse an ANDCC instruction
 * 
 * 
 * @author briand
 *
 */
public class AssembledANDCCInstruction extends AbstractInstructionAssemblyLine {

	/** contains the opcodes for each addressing mode */
	private static final EnumMap<AddressingMode,int[]> OP_CODE = new EnumMap<>(AddressingMode.class);


	/** contains the base of cycle needed for each addressing mode */
	private static final EnumMap<AddressingMode,Integer> CYCLES = new EnumMap<>(AddressingMode.class);
	
	static {
		OP_CODE.put(AddressingMode.IMMEDIATE, new int[] {0x1C});
		OP_CODE.put(AddressingMode.DIRECT, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_AUTO_DEC_INC_INDIRECT_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_AUTO_DEC_INC_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_CONSTANT_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_CONSTANT_INDIRECT_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_RELATIF_TO_PC, new int[] {0x3F});
		OP_CODE.put(AddressingMode.INDEXED_RELATIF_TO_PC_INDIRECT_MODE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.EXTENDED_INDIRECT, new int[] {0x3F});
		OP_CODE.put(AddressingMode.EXTENDED, new int[] {0x3F});

		CYCLES.put(AddressingMode.IMMEDIATE, 2);
		CYCLES.put(AddressingMode.DIRECT, 4);
		CYCLES.put(AddressingMode.EXTENDED,5);
		CYCLES.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_AUTO_DEC_INC_INDIRECT_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_AUTO_DEC_INC_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_CONSTANT_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_CONSTANT_INDIRECT_MODE, -1);
		CYCLES.put(AddressingMode.INDEXED_RELATIF_TO_PC, -1);
		CYCLES.put(AddressingMode.INDEXED_RELATIF_TO_PC_INDIRECT_MODE, -1);
		CYCLES.put(AddressingMode.EXTENDED_INDIRECT, -1);
	}
	
	/** reference on the instruction */
	private AndCCInstruction instruction;
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parse(AndCCInstruction instruction, int currentPcValue, int lineNumber) {
		
		this.label = CommandUtil.getLabel(instruction);
		this.comment = CommandUtil.getComment(instruction);
		this.instruction = instruction;
		super.parse(currentPcValue, lineNumber);
	}
	
	@Override
	public Object getInstructionOperand() {
		return instruction.getOperand();
	}

	/**
	 * Return the reference on the editor instruction line.
	 * 
	 * @return reference on the editor instruction line.
	 */
	public AndCCInstruction getInstruction() {
		return instruction;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		opcodeBytes = OP_CODE.get(mode);
	}

	@Override
	public void setOperand(AddressingMode mode) {
		switch (mode) {
			case IMMEDIATE:
				setImmediateOperand(instruction, (ImmediatOperand)instruction.getOperand(), AssemblerPackage.Literals.AND_CC_INSTRUCTION__OPERAND, -128, 255);
				break;
				
			case DIRECT:
				{
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Direct mode is not valid for the ANDCC instruction" , 
							AssemblerPackage.Literals.AND_CC_INSTRUCTION__OPERAND, 
							InstructionValidator.ILLEGAL_MODE);
					AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				}
				break;
			
			case EXTENDED:
			case EXTENDED_INDIRECT:
				{
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Extended mode is not valid for the ANDCC instruction" , 
							AssemblerPackage.Literals.AND_CC_INSTRUCTION__OPERAND, 
							InstructionValidator.ILLEGAL_MODE);
					AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				}
				break;
				
			case INDEXED_ACCUMULATOR_MOVING_MODE:
			case INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE:
			case INDEXED_AUTO_DEC_INC_INDIRECT_MODE:
			case INDEXED_AUTO_DEC_INC_MODE:
			case INDEXED_CONSTANT_MODE:
			case INDEXED_CONSTANT_INDIRECT_MODE:
			case INDEXED_RELATIF_TO_PC:
			case INDEXED_RELATIF_TO_PC_INDIRECT_MODE:
				{
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Indexed mode is not valid for the ANDCC instruction" , 
							AssemblerPackage.Literals.AND_CC_INSTRUCTION__OPERAND, 
							InstructionValidator.ILLEGAL_MODE);
					AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				}
				break;
			default:
				break;
		}
	}

	@Override
	public void setCyclesNumber(AddressingMode mode) {
		// TODO Auto-generated method stub
	}
}
