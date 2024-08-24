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

import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;

/**
 * Common class for JMP and JSR
 * 
 * @author Patrick BRIAND
 *
 */
public abstract class AbstractJmpJsrInstruction extends AbstractInstructionAssemblyLine {

	/**
	 * Constructor of the class.
	 * 
	 * @param engine reference on the assembler engine
	 */
	public AbstractJmpJsrInstruction(AssemblerEngine engine) {
		super(engine);
	}
	
	@Override
	protected void assembleInstruction() {
		resolveAddressingMode(getInstructionOperand());
		setOpcode(addressingMode);
		operandBytes = new int[] {0, 0};
		setCyclesNumber(addressingMode);
	}
}
