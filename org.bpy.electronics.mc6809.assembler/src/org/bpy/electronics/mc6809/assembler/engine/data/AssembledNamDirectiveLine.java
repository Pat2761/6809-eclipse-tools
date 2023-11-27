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

import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

/**
 * Used to store information about NAM directive
 */
public class AssembledNamDirectiveLine extends AbstractAssemblyLine {

	/** reference to the NAM directive in the edited file */
	private NamDirective directive;
	/** String value defined by the NAM directive */ 
	private String value;	
	
	/**
	 * Constructor of the class
	 */
	public AssembledNamDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the NAM directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(NamDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;
		
		value = directive.getOperand().getValue();
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

	public NamDirective getDirective() {
		return directive;
	}

	public void setDirective(NamDirective directive) {
		this.directive = directive;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
}
