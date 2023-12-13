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

import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

/**
 * Allow to parse an DEC instruction
 * 
 * 
 * @author briand
 *
 */
public class AssembledDECInstruction extends AbstractInstructionAssemblyLine {

	/** contains the opcodes for each addressing mode */
	private static final EnumMap<AddressingMode,int[]> OP_CODE = new EnumMap<>(AddressingMode.class);


	/** contains the base of cycle needed for each addressing mode */
	private static final EnumMap<AddressingMode,Integer> CYCLES = new EnumMap<>(AddressingMode.class);
	
	static {
		OP_CODE.put(AddressingMode.IMMEDIATE, new int[] {0x3F});
		OP_CODE.put(AddressingMode.DIRECT, new int[] {0x0A});
		OP_CODE.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_ACCUMULATOR_MOVING_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_AUTO_DEC_INC_INDIRECT_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_AUTO_DEC_INC_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_CONSTANT_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_CONSTANT_INDIRECT_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_RELATIF_TO_PC, new int[] {0x6A});
		OP_CODE.put(AddressingMode.INDEXED_RELATIF_TO_PC_INDIRECT_MODE, new int[] {0x6A});
		OP_CODE.put(AddressingMode.EXTENDED_INDIRECT, new int[] {0x6A, 0x9F});
		OP_CODE.put(AddressingMode.EXTENDED, new int[] { 0x7A});

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
	private DecInstruction instruction;
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parse(DecInstruction instruction, int currentPcValue, int lineNumber) {
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
	public DecInstruction getInstruction() {
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
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						"Immediate mode is not valid for the DEC instruction" , 
						AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND, 
						InstructionValidator.ILLEGAL_MODE);
				AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				break;
				
			case DIRECT:
				setDirectOperand(instruction, (DirectOperand)instruction.getOperand(), AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
			
			case EXTENDED:
				setExtendedOperand(instruction, (ExtendedOperand)instruction.getOperand(), AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case EXTENDED_INDIRECT:
				setExtendedIndirectOperand(instruction, (ExtendedIndirectOperand)instruction.getOperand(), AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case INDEXED_ACCUMULATOR_MOVING_MODE:
				setIndexedAccumulatorMovingMode((AccumulatorMovingMode)((IndexedOperand)instruction.getOperand()).getMode());
				break;
				
			case INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE:
				setIndexedAccumulatorMovingMode((AccumulatorMovingIndirectMode)((IndexedOperand)instruction.getOperand()).getMode());
				break;
				
			case INDEXED_AUTO_DEC_INC_INDIRECT_MODE:
				setIndexedAccumulatorMovingMode(instruction, (AutoIncDecIndirectMode)((IndexedOperand)instruction.getOperand()).getMode(),AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case INDEXED_AUTO_DEC_INC_MODE:
				setIndexedAccumulatorMovingMode((AutoIncDecMode)((IndexedOperand)instruction.getOperand()).getMode());
				break;
				
			case INDEXED_CONSTANT_MODE:
				setIndexedConstantMode(instruction, (ConstantIndexedMode)((IndexedOperand)instruction.getOperand()).getMode(), AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case INDEXED_CONSTANT_INDIRECT_MODE:
				setIndexedConstantIndirectMode(instruction, (ConstantIndexedMovingIndirectMode)((IndexedOperand)instruction.getOperand()).getMode(), AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case INDEXED_RELATIF_TO_PC:
				setRelatifToPCMode(instruction, (RelatifToPCMode)((IndexedOperand)instruction.getOperand()).getMode(),AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
				break;
				
			case INDEXED_RELATIF_TO_PC_INDIRECT_MODE:
				setRelatifToPCIndirectMode(instruction, (RelatifToPCIndirectMode)((IndexedOperand)instruction.getOperand()).getMode(),AssemblerPackage.Literals.DEC_INSTRUCTION__OPERAND);
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
