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

import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

/**
 * Used to store information about REG directive
 */
public class AssembledRegDirectiveLine extends AbstractAssemblyLine {

	/** reference to the REG directive in the edited file */
	private RegDirective directive;
	/** Integer value defined by the REG directive */ 
	private int value;	
	
	/**
	 * Constructor of the class
	 */
	public AssembledRegDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the BSZ directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(RegDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;
		
		value = 0;
		for (Register regValue : directive.getOptions()) {
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
		String label = CommandUtil.getLabel(directive);
		if (label == null) {
			strBuilder.append("                     ");  // Etiquette (20 car)
		} else {
			strBuilder.append(String.format("%-20s", label));
		}
	}

	@Override
	public void setInstructionOperand(StringBuilder strBuilder) {
		strBuilder.append(String.format("%-41s", ""));
	}

	@Override
	public void setLastComment(StringBuilder strBuilder) {
		String comment = CommandUtil.getComment(directive);
		if (comment != null) {
			strBuilder.append(comment);
		}
	}

	@Override
	public void setInstructionName(StringBuilder strBuilder) {
		strBuilder.append(String.format("%-6s", directive.getDirective()));  // Mnemonique (6 car)
	}

	public RegDirective getDirective() {
		return directive;
	}

	public void setDirective(RegDirective directive) {
		this.directive = directive;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
}
