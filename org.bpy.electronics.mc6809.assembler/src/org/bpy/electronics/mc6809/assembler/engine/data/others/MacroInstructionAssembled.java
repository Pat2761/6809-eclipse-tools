package org.bpy.electronics.mc6809.assembler.engine.data.others;

import java.util.Arrays;

import org.bpy.electronics.mc6809.assembler.assembler.OtherKindOfInstructions;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AddressingMode;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.preferences.core.data.MacroInstructionData;
import org.eclipse.emf.ecore.EObject;

public class MacroInstructionAssembled extends AbstractInstructionAssemblyLine {

	private MacroInstructionData macroInstructionData;
	private OtherKindOfInstructions instruction;

	public MacroInstructionAssembled(AssemblerEngine engine) {
		super(engine);
	}

	public void setMacroDescription(MacroInstructionData macroInstructionData) {
		this.macroInstructionData  = macroInstructionData;
		opcodeBytes = Arrays.copyOf(macroInstructionData.getOpcode(), macroInstructionData.getOpcode().length);
		operandBytes = Arrays.copyOf(macroInstructionData.getOperand(), macroInstructionData.getOperand().length);
	}

	@Override
	public void parsePass1(EObject instruction, int currentPcValue, int lineNumber) {
		this.instruction = (OtherKindOfInstructions)instruction;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		if (this.instruction.getLabel() != null && this.instruction.getLabel().getName() != null) {
			this.label = this.instruction.getLabel().getName().getValue();
		} else {
			this.label = null;
		}
		this.comment = this.instruction.getComment();
	}

	@Override
	public void parsePass2() {
		// nothing to do
	}


	@Override
	public String getInstructionName() {
		return instruction.getName().getValue();
	}

	@Override
	public String getOperandString() {
		return null;
	}

	@Override
	public void setOpcode(AddressingMode mode) {
		// nothing to do
	}

	@Override
	public void setOperand(AddressingMode mode) {
		// nothing to do
	}

	@Override
	public void setCyclesNumber(AddressingMode mode) {
		// nothing to do
	}

	@Override
	public EObject getInstructionOperand() {
		return null;
	}
}
