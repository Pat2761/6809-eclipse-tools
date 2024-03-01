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

import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;

/**
 * Used to store information about FCB directive
 */
public class AssembledFcbDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the FCB directive in the edited file */
	private FcbDirective directive;
	/** Integer value defined by the FCB directive */ 
	private int[] values;	
	/**
	 * Constructor of the class
	 */
	public AssembledFcbDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the FCB directive
	 * @param currentPcValu;e value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(FcbDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;

		List<Integer> listValues = ExpressionParser.parse(directive);
		values = new int[listValues.size()];
		for (int i=0; i<listValues.size(); i++) {
			values[i] = listValues.get(i);	
		}
	}

	public FcbDirective getDirective() {
		return directive;
	}

	public void setDirective(FcbDirective directive) {
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
