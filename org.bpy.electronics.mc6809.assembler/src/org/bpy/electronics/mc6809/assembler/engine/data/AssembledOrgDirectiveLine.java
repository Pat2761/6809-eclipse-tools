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

import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;

/*
 * Used to store information about ORG directive
 */
public class AssembledOrgDirectiveLine extends AbstractAssemblyLine {

	/** reference to the ORG directive in the edited file */
	private OrgDirective directive;
	/** Value of the ORG directive */
	private int value;

	/**
	 * Constructor of the class
	 */
	public AssembledOrgDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the ORG directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(OrgDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.directive = directive;
		
		value = ExpressionParser.parse(directive);
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

	public OrgDirective getDirective() {
		return directive;
	}

	public void setDirective(OrgDirective directive) {
		this.directive = directive;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
	
	public int getValue() {
		return value;
	}
}
