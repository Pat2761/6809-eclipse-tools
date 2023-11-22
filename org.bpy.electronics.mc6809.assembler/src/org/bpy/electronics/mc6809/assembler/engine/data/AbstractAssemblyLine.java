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

import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;

public abstract class AbstractAssemblyLine {

	protected int lineNumber;
	protected int pcAddress;
	protected SourceLine sourceLine;
	protected String label;
	
	public abstract void setOpcode(StringBuilder strBuilder);
	public abstract void setOperand(StringBuilder strBuilder);
	public abstract void setAdrsBranch(StringBuilder strBuilder);
	public abstract void setLabel(StringBuilder strBuilder);
	public abstract void setInstructionName(StringBuilder strBuilder);
	public abstract void setInstructionOperand(StringBuilder strBuilder);
	public abstract void setLastComment(StringBuilder strBuilder);
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getPcAddress() {
		return pcAddress;
	}

	public void setPcAddress(int pcAddress) {
		this.pcAddress = pcAddress;
	}

	public SourceLine getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(SourceLine sourceLine) {
		this.sourceLine = sourceLine;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}	

	protected void setLineNumber(StringBuilder strBuilder) {
		strBuilder.append(String.format("%05d ", lineNumber)); // Line number
	}

	protected void setPCAddress(StringBuilder strBuilder) {
		if (pcAddress>0) {
			strBuilder.append(String.format("%04X ", pcAddress)); // p_Z_Adresse (4 car)
		} else  {
			strBuilder.append("     "); // Adresse (4 car)
		}
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		setLineNumber(strBuilder);
		setPCAddress(strBuilder);
		setOpcode(strBuilder);
		setOperand(strBuilder);
		setAdrsBranch(strBuilder);
		setLabel(strBuilder);
		setInstructionName(strBuilder);
		setInstructionOperand(strBuilder);
		setLastComment(strBuilder);
		return strBuilder.toString();
	}
}
