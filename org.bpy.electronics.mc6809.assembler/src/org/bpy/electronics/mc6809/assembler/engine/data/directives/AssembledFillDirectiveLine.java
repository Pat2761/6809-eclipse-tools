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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;

/**
 * Used to store information about FILL directive
 */
public class AssembledFillDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the FILL directive in the edited file */
	private FillDirective directive;
	/** Integer value defined by the EQU directive */ 
	private int[] values;	
	/**
	 * Constructor of the class
	 */
	public AssembledFillDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the BSZ directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parse(FillDirective directive, int currentPcValue, int lineNumber) {
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(directive);
		this.comment = CommandUtil.getComment(directive);
		this.directive = directive;
		
		
		int nbBytes = ExpressionParser.resolveExpression(directive.getNumber().getOperand(), directive, AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER);
		int value = ExpressionParser.resolveExpression(directive.getValue().getOperand(), directive, AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE);
		if (nbBytes < 0) {
			nbBytes = 0;
		}
		values = new int[nbBytes];
		for (int i=0; i<nbBytes; i++) {
			values[i] = value;
		}
	}

	public FillDirective getDirective() {
		return directive;
	}

	public void setDirective(FillDirective directive) {
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
