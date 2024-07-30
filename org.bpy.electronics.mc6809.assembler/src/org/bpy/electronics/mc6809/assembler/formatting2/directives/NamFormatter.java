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
package org.bpy.electronics.mc6809.assembler.formatting2.directives;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.formatting2.AbstractObjectFormatter;
import org.bpy.electronics.mc6809.assembler.formatting2.AssemblerFormatter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;

/**
 * Format Nam instruction.
 * 
 * @author Patrick BRIAND
 *
 */
public class NamFormatter extends AbstractObjectFormatter {

	/** reference on the instruction */
	private NamDirective instruction;

	/**
	 * Constructor of the class.
	 * 
	 * @param doc reference on the document
	 * @param tabPolicy Tab policy used (Space only, tab only a mixed)
	 * @param tabSize Size of the tabulation
	 */
	public NamFormatter(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
	}

	@Override
	public void format(AssemblerFormatter assemblerFormatter, EObject object, int instructionPosition, int operandPosition) {
		this.assemblerFormatter = assemblerFormatter;
		this.instruction = (NamDirective)object;
		this.instructionPosition = instructionPosition;
		this.operandPosition = operandPosition;
		format();
	}

	@Override
	public String getInstructioName() {
		return instruction.getDirective();
	}

	@Override
	public EAttribute getSeparatorAttribute() {
		return AssemblerPackage.Literals.NAM_DIRECTIVE__WS;
	}

	@Override
	public EObject getInstruction() {
		return instruction;
	}

	@Override
	public EObject getOperand() {
		return instruction.getOperand();
	}
}
