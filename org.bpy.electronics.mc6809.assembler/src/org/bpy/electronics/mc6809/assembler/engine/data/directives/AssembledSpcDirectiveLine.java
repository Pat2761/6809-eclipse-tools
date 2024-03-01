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

import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;

/**
 * Used to store information about SPC directive
 */
public class AssembledSpcDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the SPC directive in the edited file */
	private SpcDirective directive;
	/** Integer value of the space count defined by the SPC directive */ 
	private int spaceCount;
	/** Integer value of the keep count defined by the SPC directive */ 
	private int keepCount;
	
	/**
	 * Constructor of the class
	 */
	public AssembledSpcDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the SPC directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(SpcDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;
		
		keepCount = ExpressionParser.getKeepCount(directive);
		spaceCount = ExpressionParser.getSpaceCount(directive);
	}

	public SpcDirective getDirective() {
		return directive;
	}

	public void setDirective(SpcDirective directive) {
		this.directive = directive;
	}

	public int getSpaceCountValue() {
		return spaceCount;
	}

	public int getkeepCountValue() {
		return keepCount;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}
}
