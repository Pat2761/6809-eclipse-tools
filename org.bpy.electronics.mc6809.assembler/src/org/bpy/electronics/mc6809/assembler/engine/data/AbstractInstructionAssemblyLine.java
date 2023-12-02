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

import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.NumericalValue;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AddressingMode;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Abstract class which defined the common attributes of an instruction
 * 
 * @author briand
 *
 */
public abstract class AbstractInstructionAssemblyLine extends AbstractAssemblyLine {
	
	public static final String ILLEGAL_DECREMENT = "illegalDecrement";
	public static final String ILLEGAL_INCREMENT = "illegalIncrement";

	/** OPcode of the instruction */
	protected int[] opcodeBytes;
	/** Operand value of the instruction */ 
	protected int[] operandBytes;
	/** number of cycle for executing the instruction */
	protected int cyclesNumber;
	/** Addressing mode used by the instruction */
	protected AddressingMode addressingMode;
	
	/**
	 * Return the opcode of the instruction.
	 * 
	 * @param mode addressing mode used by the instruction
	 */
	public abstract void setOpcode(AddressingMode mode);
	
	/**
	 * return the operand of the instruction
	 * 
	 * @param mode addressing mode used by the instruction
	 */
	public abstract void setOperand(AddressingMode mode); 
	
	/**
	 * Return the number of cycles for an instruction
	 * 
	 * @param mode addressing mode used by the instruction
	 */
	public abstract void setCyclesNumber(AddressingMode mode);
	
	/**
	 * Get the reference on the instruction operand
	 * 
	 * @return reference on the instruction operand
	 */
	public abstract Object getInstructionOperand();

	@Override
	public int getPcIncrement() {
		return opcodeBytes.length + operandBytes.length;
	}

	/**
	 * Parse common attributes of an Instruction line.
	 *  
	 * @param currentPcValue current PC Value
	 * @param lineNumber line number in the assembly file
	 */
	public void parse(int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		
		assembleInstruction();
	}

	/**
	 * get the opcode value of the instruction
	 * 
	 * @return opcode value of the instruction
	 */
	public int[] getOpcode() {
		return opcodeBytes;
	}

	/**
	 * get the operand value of the instruction
	 * 
	 * @return operand value of the instruction
	 */
	public int[] getOperand() {
		return operandBytes;
	}

	/**
	 * get the cycle number value of the instruction
	 * 
	 * @return cycle number value of the instruction
	 */
	public int getCyclesNumber() {
		return cyclesNumber;
	}

	/** 
	 * Allow to assemble the instruction
	 */
	private void assembleInstruction() {
		resolveAddressingMode(getInstructionOperand());
		setOpcode(addressingMode);
		setOperand(addressingMode);
		setCyclesNumber(addressingMode);
	}

	protected void resolveAddressingMode(Object operand) {
		if (operand == null) {
			addressingMode = AddressingMode.INHERENT;
		} else {
			if (operand instanceof ImmediatOperand) {
				addressingMode = AddressingMode.IMMEDIATE;
			} else if (operand instanceof ExtendedOperand){
				addressingMode = AddressingMode.EXTENDED;
			} else if (operand instanceof DirectOperand){
				addressingMode = AddressingMode.DIRECT;
			} else if (operand instanceof IndexedOperand){
				
				if (((IndexedOperand)operand).getMode() instanceof AutoIncDecMode) {
					addressingMode = AddressingMode.INDEXED_AUTO_DEC_INC_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof ConstantIndexedMode) {
					addressingMode = AddressingMode.INDEXED_CONSTANT_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof AccumulatorMovingMode) {
					addressingMode = AddressingMode.INDEXED_ACCUMULATOR_MOVING_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof RelatifToPCMode) {
					addressingMode = AddressingMode.INDEXED_RELATIF_TO_PC;
				} else if (((IndexedOperand)operand).getMode() instanceof ConstantIndexedMovingIndirectMode) {
					addressingMode = AddressingMode.INDEXED_CONSTANT_INDIRECT_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof AutoIncDecIndirectMode) {
					addressingMode = AddressingMode.INDEXED_AUTO_DEC_INC_INDIRECT_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof AccumulatorMovingIndirectMode) {
					addressingMode = AddressingMode.INDEXED_ACCUMULATOR_MOVING_INDIRECT_MODE;
				} else if (((IndexedOperand)operand).getMode() instanceof RelatifToPCIndirectMode) {
					addressingMode = AddressingMode.INDEXED_RELATIF_TO_PC_INDIRECT_MODE;
				}	
			} else if (operand instanceof ExtendedIndirectOperand){
				addressingMode = AddressingMode.EXTENDED_INDIRECT;
			} else if (operand instanceof RelativeMode){
				addressingMode = AddressingMode.EXTENDED_INDIRECT;
			}
		}
	}
	
	protected void setImmediateOperand(EObject instruction,ImmediatOperand immediatOperand, EReference eReference, int min, int max) {
		int value = ExpressionParser.parse(immediatOperand, eReference, instruction, min, max); 
		operandBytes = new int[] {value};
	}

	protected void setDirectOperand(EObject instruction, DirectOperand directOperand, EReference eReference) {
		int value = ExpressionParser.parse(directOperand, eReference, instruction); 
		operandBytes = new int[] {value};
	}

	protected void setExtendedOperand(EObject instruction, ExtendedOperand extendedOperand,EReference eReference) {
		int value = ExpressionParser.parse(extendedOperand, eReference, instruction); 
		operandBytes = new int[] {value/256, value%256};
	}

	protected void setIndexedAccumulatorMovingMode(EObject instruction, AccumulatorMovingMode operand) {
		int postByte = 0;
		
		switch (operand.getDeplacement()) {
			case "A" : postByte |= 0x06; break;
			case "B" : postByte |= 0x05; break;
			case "D" : postByte |= 0x0B; break;
			default: break;
		}
		
		switch (operand.getRegister()) {
			case "X" : postByte |= 0x80; break;
			case "Y" : postByte |= 0xA0; break;
			case "U" : postByte |= 0xC0; break;
			case "S" : postByte |= 0xE0; break;
		default: break;
		}
		
		operandBytes = new int[] {postByte%256};
	}

	protected void setIndexedAccumulatorMovingMode(EObject instruction, AccumulatorMovingIndirectMode mode) {
		int postByte = 0;
		
		switch (mode.getDeplacement()) {
			case "A" : postByte |= 0x06; break;
			case "B" : postByte |= 0x05; break;
			case "D" : postByte |= 0x0B; break;
			default: break;
		}
		
		switch (mode.getRegister()) {
			case "X" : postByte |= 0x90; break;
			case "Y" : postByte |= 0xB0; break;
			case "U" : postByte |= 0xD0; break;
			case "S" : postByte |= 0xF0; break;
		default: break;
		}
		
		operandBytes = new int[] {postByte%256};
	}

	protected void setIndexedAccumulatorMovingMode(EObject instruction2, AutoIncDecMode mode) {
		int postByte = 0;
		
		if (mode.getDecrement() != null) {
	 		switch (mode.getDecrement()) {
				case "-" : postByte |= 0x02; break;
				case "--" : postByte |= 0x03; break;
				default: break;
			}
		} else if (mode.getIncrement()!=null) {
	 		switch (mode.getIncrement()) {
				case "+" :  break; // nothing to do cue to AND with 0
				case "++" : postByte |= 0x01; break;
				default: break;
	 		}	
		}
		
		switch (mode.getRegister()) {
			case "X" : postByte |= 0x80; break;
			case "Y" : postByte |= 0xA0; break;
			case "U" : postByte |= 0xC0; break;
			case "S" : postByte |= 0xE0; break;
			default: break;
		}
		
		operandBytes = new int[] {postByte%256};
	}

	protected void setIndexedAccumulatorMovingMode(EObject instruction, AutoIncDecIndirectMode mode, EStructuralFeature eReference) {
		int postByte = 0;
		
		if (mode.getDecrement() != null) {
	 		switch (mode.getDecrement()) {
				case "-" : 
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Cannot use pre decrement with 1 for indirect mode" , 
							eReference, 
							ILLEGAL_DECREMENT);
					AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
					break;
				case "--" : postByte |= 0x03; break;
				default: break;
			}
		} else if (mode.getIncrement()!=null) {
	 		switch (mode.getIncrement()) {
				case "+" :  
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Cannot use post increment with 1 for indirect mode" , 
							eReference, 
							ILLEGAL_INCREMENT);
					AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
					
					break; 
					
				case "++" : postByte |= 0x01; break;
				default: break;
	 		}	
		}
		
		switch (mode.getRegister()) {
			case "X" : postByte |= 0x90; break;
			case "Y" : postByte |= 0xB0; break;
			case "U" : postByte |= 0xD0; break;
			case "S" : postByte |= 0xF0; break;
			default: break;
		}
		
		operandBytes = new int[] {postByte%256};
	}

	protected void setIndexedConstantMode(EObject instruction2, ConstantIndexedMode mode) {
		int postByte = 0;
		NumericalValue deplacement = mode.getDeplacement();
		
		if (deplacement == null) {
			switch (mode.getRegister()) {
				case "X" : postByte |= 0x84; break;
				case "Y" : postByte |= 0xA4; break;
				case "U" : postByte |= 0xC4; break;
				case "S" : postByte |= 0xE4; break;
			}
			operandBytes = new int[] {postByte%256};
		} else {
			int offset = ExpressionParser.parse(deplacement);
			if (offset < 0x10) {
				 
			} else if (offset < 0x100) {
				switch (mode.getRegister()) {
				case "X" : postByte |= 0x88; break;
				case "Y" : postByte |= 0xA8; break;
				case "U" : postByte |= 0xC8; break;
				case "S" : postByte |= 0xE8; break;
			}	
			operandBytes = new int[] {postByte%256, offset%256 };
				
			} else if (offset <0x10000) {
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x89; break;
					case "Y" : postByte |= 0xA9; break;
					case "U" : postByte |= 0xC9; break;
					case "S" : postByte |= 0xE9; break;
				}	
				operandBytes = new int[] {postByte%256, offset/256, offset%256 };
			}
		}
	}

	protected void setExtendedIndirectOperand(EObject instruction, ExtendedIndirectOperand operand, EReference eReference) {
		int value = ExpressionParser.parse(operand, eReference, instruction); 
		operandBytes = new int[] {value/256, value%256};
	}
}
