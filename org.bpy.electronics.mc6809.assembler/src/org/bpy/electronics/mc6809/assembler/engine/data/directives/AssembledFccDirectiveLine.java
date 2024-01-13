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

import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;

/**
 * Used to store information about FCC directive
 */
public class AssembledFccDirectiveLine extends AbstractAssemblyLine {

	/** reference to the FCC directive in the edited file */
	private FccDirective directive;
	/** Integer value defined by the FCC directive */ 
	private int[] values;	
	/**
	 * Constructor of the class
	 */
	public AssembledFccDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the FCC directive
	 * @param currentPcValu;e value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(FccDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;

		byte[] bytes = directive.getString().getBytes();
		values = new int[bytes.length];
		for (int i=0; i<bytes.length; i++) {
			values[i] = bytes[i];
		}
	}

	public FccDirective getDirective() {
		return directive;
	}

	public void setDirective(FccDirective directive) {
		this.directive = directive;
	}

	public int[] getValues() {
		return values;
	}

	@Override
	public int getPcIncrement() {
		return values.length;
	}
}
