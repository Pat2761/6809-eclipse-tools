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
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Allow to parse an TFR Instruction
 * 
 * @author Patrick BRIAND
 *
 */
public class AssembledTFRInstruction extends AbstractInstructionAssemblyLine {

	/** Reference on the instruction */
	private TfrInstruction instruction;
	
	/**
	 * Constructor of the class.
    *
	 * @param engine reference on the assembler engine.
	 */
	public AssembledTFRInstruction(AssemblerEngine engine) {
		super(engine);
	}
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parsePass1(EObject instruction, int currentPcValue, int lineNumber) {
		this.instruction = (TfrInstruction) instruction;
		this.label = CommandUtil.getLabel(this.instruction);
		this.comment = CommandUtil.getComment(this.instruction);
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		assembleInstruction();
		operandBytes = new int[1];
		operandBytes[0]=0;
	}

	@Override
	public void parsePass2() {
		setOperand(addressingMode);	
	}

	/**
	 * Return the reference on the editor instruction line.
	 * 
	 * @return reference on the editor instruction line.
	 */
	public TfrInstruction getInstruction() {
		return instruction;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		opcodeBytes =  new int[] {0x1F};
	}

	@Override
	public void setOperand(AddressingMode mode) {
		int calculatedOperand = 0;
		Register reg1 = instruction.getOperand().getReg1();
		Register reg2 = instruction.getOperand().getReg2();
		
		if (reg1 == reg2) {
			AssemblerWarningDescription warning = new AssemblerWarningDescription(
					"Exchanging the register " + reg1.getLiteral() + " with itself has no effect",
					AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg1(),
					InstructionValidator.ILLEGAL_EXCHANGE);
			AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
		}

		switch (reg1) {
		case A:
			calculatedOperand |= 0x80;
			if (reg2==Register.D) {
				AssemblerWarningDescription warning = new AssemblerWarningDescription(
						"Exchanging the register " + reg1.getLiteral() + " with a part of itself is suspicious",
						AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg2(),
						InstructionValidator.ILLEGAL_EXCHANGE);
				AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
       			
			} else {			
				checkSuspiciousRegister8bitsAssociaton(reg1, reg2);
			}	
			break;
		case B:
			calculatedOperand |= 0x90; 
			if (reg2==Register.D) {
				AssemblerWarningDescription warning = new AssemblerWarningDescription(
						"Exchanging the register " + reg1.getLiteral() + " with a part of itself is suspicious",
						AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg2(),
						InstructionValidator.ILLEGAL_EXCHANGE);
				AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
       			
			} else {			
				checkSuspiciousRegister8bitsAssociaton(reg1, reg2);
			}	
			break;
		case CC:
			calculatedOperand |= 0xA0; 
			checkSuspiciousRegister8bitsAssociaton(reg1, reg2);
			break;
		case D:
			if (reg2==Register.A || reg2==Register.B) {
				AssemblerWarningDescription warning = new AssemblerWarningDescription(
						"Exchanging the register " + reg1.getLiteral() + " with a part of itself is suspicious",
						AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg2(),
						InstructionValidator.ILLEGAL_EXCHANGE);
				AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
			} else {
				checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			}
			calculatedOperand |= 0x00; 
			break;
		case DP:
			calculatedOperand |= 0xB0; 
			checkSuspiciousRegister8bitsAssociaton(reg1, reg2);
			break;
		case PC:
			calculatedOperand |= 0x50; 
			checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			break;
		case S:
			calculatedOperand |= 0x40; 
			checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			break;
		case U:
			calculatedOperand |= 0x30; 
			checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			break;
		case X:
			calculatedOperand |= 0x10; 
			checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			break;
		case Y:
			calculatedOperand |= 0x20; 
			checkSuspiciousRegister16bitsAssociaton(reg1, reg2);
			break;
		default:
			break;
		}

		switch (reg2) {
		case A:
			calculatedOperand |= 0x08; 
			break;
		case B:
			calculatedOperand |= 0x09; 
			break;
		case CC:
			calculatedOperand |= 0x0A; 
			break;
		case D:
			calculatedOperand |= 0x00; 
			break;
		case DP:
			calculatedOperand |= 0x0B; 
			break;
		case PC:
			calculatedOperand |= 0x05; 
			break;
		case S:
			calculatedOperand |= 0x04; 
			break;
		case U:
			calculatedOperand |= 0x03; 
			break;
		case X:
			calculatedOperand |= 0x01; 
			break;
		case Y:
			calculatedOperand |= 0x02; 
			break;
		default:
			break;
		}
		
		operandBytes = new int[] {calculatedOperand & 0xFF};
	}

	private void checkSuspiciousRegister16bitsAssociaton(Register reg1, Register reg2) {
		if (reg2==Register.A ||
			reg2==Register.B ||
			reg2==Register.CC ||
			reg2==Register.DP) {

				AssemblerWarningDescription warning = new AssemblerWarningDescription(
						"Exchanging the register " + reg1.getLiteral() + " with a 8 bits register is suspicious",
						AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg2(),
						InstructionValidator.ILLEGAL_EXCHANGE);
				AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
			}
	}

	private void checkSuspiciousRegister8bitsAssociaton(Register reg1, Register reg2) {
		if (reg2==Register.D ||
			reg2==Register.PC ||
		    reg2==Register.X ||
			reg2==Register.Y ||
			reg2==Register.U ||
			reg2==Register.S ) {

			AssemblerWarningDescription warning = new AssemblerWarningDescription(
					"Exchanging the register " + reg1.getLiteral() + " with a 16 bits register is suspicious",
					AssemblerPackage.eINSTANCE.getTfrExgRegisters_Reg2(),
					InstructionValidator.ILLEGAL_EXCHANGE);
			AssemblerErrorManager.getInstance().addWarning(instruction.getOperand(), warning);
		}
	}

	@Override
	public void setCyclesNumber(AddressingMode mode) {
		this.cyclesNumber = 3;
	}

	@Override
	public EObject getInstructionOperand() {
		return null;
	}
	
	@Override
	public String getInstructionName() {
		return instruction.getInstruction();
	}
	
	@Override
	public String getOperandString() {
		return instruction.getOperand().getReg1().getLiteral() + "," + instruction.getOperand().getReg2().getLiteral();
	}
}
