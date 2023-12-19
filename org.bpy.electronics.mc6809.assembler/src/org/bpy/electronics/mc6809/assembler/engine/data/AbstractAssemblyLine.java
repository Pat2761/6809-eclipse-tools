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

import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.eclipse.emf.common.util.EList;

public abstract class AbstractAssemblyLine {

	protected int lineNumber;
	protected int pcAddress;
	protected SourceLine sourceLine;
	protected String label;
	protected String comment;

	public abstract int getPcIncrement();
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
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
	
	protected int getRegisterConvertionValue(EList<Register> options) {
		int value = 0;
		for (Register regValue : options) {
			switch (regValue.getLiteral()) {
				case "A"  : value |= 0x02; break;
				case "B"  : value |= 0x04; break;
				case "D"  : value |= 0x06; break;
				case "U"  : value |= 0x40; break;
				case "S"  : value |= 0x40; break;
				case "X"  : value |= 0x10; break;
				case "Y"  : value |= 0x20; break;
				case "PC" : value |= 0x80; break;
				case "DP" : value |= 0x08; break;
				case "CC" : value |= 0x01; break;
			default		:
				// nothing to do , protected by the grammar 
			}	
		}
		return value;
	}
}
