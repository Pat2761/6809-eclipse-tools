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
import org.bpy.electronics.mc6809.assembler.assembler.BsrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Allow to parse an Bsr Instruction
 * 
 * @author briand
 *
 */
public class AssembledBSRInstruction extends AbstractRelativeBranchInstruction {

	/** Reference on the instruction */
	private BsrInstruction instruction;
	
	/**
	 * Allow to parse the instruction and define its parameters.
	 * 
	 * @param instruction reference on the EMF instruction line
	 * @param currentPcValue state of the current PC
	 * @param lineNumber line number in assembly file
	 */
	public void parsePass1(EObject instruction, int currentPcValue, int lineNumber) {
		this.instruction = (BsrInstruction) instruction;
		this.label = CommandUtil.getLabel(this.instruction);
		this.comment = CommandUtil.getComment(this.instruction);
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		addressingMode = AddressingMode.RELATIVE;
		operandBytes = new int[1];
		parse(currentPcValue, lineNumber);
	}

	@Override
	public void parsePass2() {

		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {

			AbstractAssemblyLine targetLine = AssemblerEngine.getInstance().getLabelsPositionObject().get(label);
			if (targetLine != null) {
				computeOperand(targetLine.getPcAddress(), BYTE_MODE, AssemblerPackage.eINSTANCE.getBsrInstruction_Operand());
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.eINSTANCE.getBsrInstruction_Operand(), InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Return the reference on the editor instruction line.
	 * 
	 * @return reference on the editor instruction line.
	 */
	public BsrInstruction getInstruction() {
		return instruction;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		opcodeBytes =  new int[] {0x8D};
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

	@Override
	public String getInstructionName() {
		return instruction.getInstruction();
	}
	
	@Override
	public String getOperandString() {
		return getOperand(instruction.getOperand());
	}
}
