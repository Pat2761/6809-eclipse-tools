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
package org.bpy.electronics.mc6809.assembler.engine.data.directives;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

/**
 * Used to store information about OPT directive
 */
public class AssembledOptDirectiveLine extends AbstractAssemblyLine {

	/** Integer value defined by the EQU directive */ 
	private String[] values;	

	/** reference to the OPT directive in the edited file */
	private OptDirective directive;

	/**
	 * Constructor of the class
	 */
	public AssembledOptDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the OPT directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(OptDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;

		if (directive.getOptions() == null) {
			values = new String[4];
			values[0] = "NOP";
			values[1] = "NOC";
			values[2] = "MAC";
			values[3] = "NOE";
		} else {
			values = new String[directive.getOptions().size()];
			int i=0;
			for (AssemblyOption option : directive.getOptions()) {
				values[i++]  = option.getLiteral();
			}
		}
	}

	public OptDirective getDirective() {
		return directive;
	}

	public void setDirective(OptDirective directive) {
		this.directive = directive;
	}

	public String[] getValues() {
		return values;
	}
	
	public boolean isEnablePagination() {
		for (String value : values) {
			if ("PAG".equals(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean isConditionallySkippedCode() {
		for (String value : values) {
			if ("CON".equals(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean isSuppressPrintingOfMacroCalls() {
		for (String value : values) {
			if ("NOM".equals(value)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPrintMacroExpansionLines() {
		for (String value : values) {
			if ("EXP".equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

}
