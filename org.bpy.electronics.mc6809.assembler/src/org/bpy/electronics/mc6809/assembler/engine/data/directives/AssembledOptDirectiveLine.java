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
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about OPT directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledOptDirectiveLine extends AbstractAssembledDirectiveLine {

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
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (OptDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);

		if (this.directive.getOptions() == null) {
			values = new String[4];
			values[0] = "NOP";
			values[1] = "NOC";
			values[2] = "MAC";
			values[3] = "NOE";
		} else {
			values = new String[this.directive.getOptions().size()];
			int i=0;
			for (AssemblyOption option : this.directive.getOptions()) {
				values[i++]  = option.getLiteral();
			}
		}
	}

	@Override
	public void parsePass2() {
		// Nothing to do here
	}

	/**
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public OptDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(OptDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get values
	 *  
	 * @return values
	 */
	public String[] getValues() {
		return values;
	}
	
	/**
	 * Check if PAG option is defined
	 * 
	 * @return <b>true</b> if PAG option is defined, <b>false</b> otherwise
	 */
	public boolean isEnablePagination() {
		for (String value : values) {
			if ("PAG".equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if CON option is defined
	 * 
	 * @return <b>true</b> if CON option is defined, <b>false</b> otherwise
	 */
	public boolean isConditionallySkippedCode() {
		for (String value : values) {
			if ("CON".equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if NOM option is defined
	 * 
	 * @return <b>true</b> if NOM option is defined, <b>false</b> otherwise
	 */
	public boolean isSuppressPrintingOfMacroCalls() {
		for (String value : values) {
			if ("NOM".equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if EXP option is defined
	 * 
	 * @return <b>true</b> if EXP option is defined, <b>false</b> otherwise
	 */
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
