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

import java.util.Map;

import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
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
	public static final String OVERFLOW_ERROR = "overflowError";
	public static final String RELATIVE_SHORT_BRANCH = "relativeShortBranch";

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
	
	public AbstractInstructionAssemblyLine() {
		opcodeBytes = new int[0];
		operandBytes = new int[0];
	}
	
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
	protected void assembleInstruction() {
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
		operandBytes = new int[] {(value&0xFF00)>>8, value&0xFF};
	}

	protected void setExtendedOperand(EObject instruction, ExtendedOperand extendedOperand,Map<String, AbstractAssemblyLine> labelsPositionObject, EReference eReference) {
		int value = ExpressionParser.parse(extendedOperand, eReference, labelsPositionObject, instruction); 
		operandBytes = new int[] {(value&0xFF00)>>8, value&0xFF};
	}

	protected void setIndexedAccumulatorMovingMode(AccumulatorMovingMode operand) {
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
		
		operandBytes = new int[] {postByte&0xFF};
	}

	protected void setIndexedAccumulatorMovingMode(AccumulatorMovingIndirectMode mode) {
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
		
		operandBytes = new int[] {postByte&0xFF};
	}

	protected void setIndexedAccumulatorMovingMode(AutoIncDecMode mode) {
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
		
		operandBytes = new int[] {postByte&0xFF};
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
		
		operandBytes = new int[] {postByte&0xFF};
	}

	protected void setIndexedConstantMode(EObject instruction, ConstantIndexedMode mode, EStructuralFeature eReference) {
		int postByte = 0;
		int offset = 0;
		NumericalValue deplacement = mode.getDeplacement();
		if (deplacement != null) { 
			offset = ExpressionParser.parse(deplacement);
		}
		
		if ((deplacement == null) || (offset == 0)) {
			switch (mode.getRegister()) {
				case "X" : postByte |= 0x84; break;
				case "Y" : postByte |= 0xA4; break;
				case "U" : postByte |= 0xC4; break;
				case "S" : postByte |= 0xE4; break;
			}
			operandBytes = new int[] {postByte&0xFF};

		} else {
			if (offset>-17 && offset<16) {

				switch (mode.getRegister()) {
					case "X" : postByte |= 0x00; break;
					case "Y" : postByte |= 0x20; break;
					case "U" : postByte |= 0x40; break;
					case "S" : postByte |= 0x60; break;
				}	
				if (offset <0) {
					postByte |= 0x10;
					offset = offset&0x0F; 
				}
				postByte |= offset;
				operandBytes = new int[] {postByte&0xFF};
				 
			} else if (offset>-129 && offset<128) {
				
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x88; break;
					case "Y" : postByte |= 0xA8; break;
					case "U" : postByte |= 0xC8; break;
					case "S" : postByte |= 0xE8; break;
				}	
				operandBytes = new int[] {postByte&0xFF, offset&0xFF };
				
			} else  if (offset >-32769 && offset<32768){
			
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x89; break;
					case "Y" : postByte |= 0xA9; break;
					case "U" : postByte |= 0xC9; break;
					case "S" : postByte |= 0xE9; break;
				}	
				operandBytes = new int[] {postByte&0xFF, (offset&0xFF00) >> 8, offset&0xFF };
			
			} else {
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						"Overflow detected for value " + offset + " , data may be lost" , 
						eReference, 
						OVERFLOW_ERROR);
				AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x89; break;
					case "Y" : postByte |= 0xA9; break;
					case "U" : postByte |= 0xC9; break;
					case "S" : postByte |= 0xE9; break;
				}	
				if (offset<-32768) {
					operandBytes = new int[] {postByte&0xFF, 0x80, 0x00 };
				} else {
					operandBytes = new int[] {postByte&0xFF, 0x7F, 0xFF };
				}
			}
		}
	}

	protected void setIndexedConstantIndirectMode(EObject instruction, ConstantIndexedMovingIndirectMode mode, EStructuralFeature eReference) {
		int postByte = 0;
		int offset = 0;
		NumericalValue deplacement = mode.getDeplacement();
		if (deplacement != null) { 
			offset = ExpressionParser.parse(deplacement);
		}
		
		if ((deplacement == null) || (offset == 0)) {
			switch (mode.getRegister()) {
				case "X" : postByte |= 0x94; break;
				case "Y" : postByte |= 0xB4; break;
				case "U" : postByte |= 0xD4; break;
				case "S" : postByte |= 0xF4; break;
			}
			operandBytes = new int[] {postByte&0xFF};
		} else {
			if (offset > -129 && offset<128) {
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x98; break;
					case "Y" : postByte |= 0xB8; break;
					case "U" : postByte |= 0xD8; break;
					case "S" : postByte |= 0xF8; break;
				}	
				operandBytes = new int[] {postByte&0xFF, offset&0xFF };
			} else  if (offset >-32769 && offset<32768){
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x99; break;
					case "Y" : postByte |= 0xB9; break;
					case "U" : postByte |= 0xD9; break;
					case "S" : postByte |= 0xF9; break;
				}	
				operandBytes = new int[] {postByte&0xFF, (offset&0xFF00)>>8, offset&0xFF };
				
			} else {
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						"Overflow detected for value " + offset + " , data may be lost" , 
						eReference, 
						OVERFLOW_ERROR);
				AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
				
				switch (mode.getRegister()) {
					case "X" : postByte |= 0x99; break;
					case "Y" : postByte |= 0xB9; break;
					case "U" : postByte |= 0xD9; break;
					case "S" : postByte |= 0xF9; break;
				}	
				if (offset<-32768) {
					operandBytes = new int[] {postByte&0xFF, 0x80, 0x00 };
				} else {
					operandBytes = new int[] {postByte&0xFF, 0x7F, 0xFF };
				}
			}
		}
	}

	protected void setRelatifToPCMode(EObject instruction, RelatifToPCMode mode, EReference eReference) {
		int offset = 0;
		NumericalValue deplacement = mode.getDeplacement();
		if (deplacement != null) { 
			offset = ExpressionParser.parse(deplacement);
		} else {
			offset = 0;
		}
		
		if (offset > -129 && offset < 128) {
			operandBytes = new int[] {0x8C, offset&0xFF };
		} else if (offset > -32769 && offset< 32768){
			operandBytes = new int[] {0x8D, (offset&0xFF00) >> 8, offset&0xFF };
		} else if (offset < -32768) {
			
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + offset + " is out than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
			operandBytes = new int[] {0x8D, 0x80, 0x00 };

		} else {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + offset + " is out than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
			operandBytes = new int[] {0x8D, 0x7F, 0xFF };
		}
	}

	protected void setRelatifToPCIndirectMode(EObject instruction, RelatifToPCIndirectMode mode, EReference eReference) {
		int offset = 0;
		NumericalValue deplacement = mode.getDeplacement();
		if (deplacement != null) { 
			offset = ExpressionParser.parse(deplacement);
		} else {
			offset = 0;
		}
		
		if (offset > -129 && offset < 128) {
			operandBytes = new int[] {0x9C, offset&0xFF };
		} else if (offset > -32769 && offset< 32768){
			operandBytes = new int[] {0x9D, (offset&0xFF00) >> 8, offset&0xFF };
		} else if (offset < -32768) {
		
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + offset + " is out than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
			operandBytes = new int[] {0x9D, 0x80, 0x00 };

		} else {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + offset + " is out than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(instruction, errorDescription);
			operandBytes = new int[] {0x9D, 0x7F, 0xFF };
		}
	}

	protected void setExtendedIndirectOperand(EObject instruction, ExtendedIndirectOperand operand, EReference eReference) {
		int value = ExpressionParser.parse(operand, eReference, instruction); 
		operandBytes = new int[] {value/256, value%256};
	}
}
