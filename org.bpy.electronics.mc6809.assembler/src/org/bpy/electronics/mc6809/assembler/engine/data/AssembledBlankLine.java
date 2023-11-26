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

import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;

public class AssembledBlankLine extends AbstractAssemblyLine {
	
	public void parse(BlankLine blankLine, int currentPcValue, int lineNumber) {
		this.lineNumber = lineNumber;
		pcAddress = currentPcValue;
	}

	@Override
	public void setOpcode(StringBuilder strBuilder) {
		strBuilder.append("     ");  // Hexa_OpCode (4 car) ---------------------> code Objet
	}

	@Override
	public void setOperand(StringBuilder strBuilder) {
		strBuilder.append("        ");  // Hexa_Operande (7 car) ----------> code Objet
	}

	@Override
	public void setAdrsBranch(StringBuilder strBuilder) {
		strBuilder.append("     ");  // Hexa_AdrsBranch (4 car)
	}

	@Override
	public void setLabel(StringBuilder strBuilder) {
	}

	@Override
	public void setInstructionName(StringBuilder strBuilder) {
		strBuilder.append("       ");  // Mnemonique (6 car)
	}

	@Override
	public void setInstructionOperand(StringBuilder strBuilder) {
		// Nothing to do
	}

	@Override
	public void setLastComment(StringBuilder strBuilder) {
		// Nothing to do
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
}
