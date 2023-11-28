package org.bpy.electronics.mc6809.assembler.engine.data.instructions;

import org.bpy.electronics.mc6809.assembler.assembler.AbxInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

public class AssembledAbxInstruction extends AbstractInstructionAssemblyLine {

	/** Reference on the instruction */
	private AbxInstruction instruction;
	
	public void parse(AbxInstruction instruction, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(instruction);
		this.comment = CommandUtil.getComment(instruction);
		this.instruction = instruction;
	}

	@Override
	public byte[] getOpcode() {
		byte[] opcode = new byte[1];
		opcode[0] = 0x3A;
		return opcode;
	}

	@Override
	public byte[] getOperand() {
		return new byte[0];
	}

	@Override
	public int getCyclesNumber() {
		return 3;
	}

	@Override
	public int getPcIncrement() {
		return 1;
	}

	/**
	 * Return the reference on the editor instruction line.
	 * 
	 * @return reference on the editor instruction line.
	 */
	public AbxInstruction getInstruction() {
		return instruction;
	}
}
