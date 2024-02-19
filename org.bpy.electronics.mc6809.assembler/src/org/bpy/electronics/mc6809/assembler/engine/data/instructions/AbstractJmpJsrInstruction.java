package org.bpy.electronics.mc6809.assembler.engine.data.instructions;

import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;

public abstract class AbstractJmpJsrInstruction extends AbstractInstructionAssemblyLine {

	@Override
	protected void assembleInstruction() {
		resolveAddressingMode(getInstructionOperand());
		setOpcode(addressingMode);
		operandBytes = new int[] {0, 0};
		setCyclesNumber(addressingMode);
	}
	
}
