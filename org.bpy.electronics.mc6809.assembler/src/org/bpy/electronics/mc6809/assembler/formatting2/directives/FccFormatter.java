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
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.formatting2.AbstractObjectFormatter;
import org.bpy.electronics.mc6809.assembler.formatting2.AssemblerFormatter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;

/**
 * Format Fcc instruction.
 * 
 * @author Patrick BRIAND
 *
 */
public class FccFormatter extends AbstractObjectFormatter {

	/** reference on the instruction */
	private FccDirective instruction;

	/**
	 * Constructor of the class.
	 * 
	 * @param doc reference on the document
	 * @param tabPolicy Tab policy used (Space only, tab only a mixed)
	 * @param tabSize Size of the tabulation
	 */
	public FccFormatter(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
	}

	@Override
	public void format(AssemblerFormatter assemblerFormatter, EObject object, int instructionPosition, int operandPosition) {
		this.assemblerFormatter = assemblerFormatter;
		this.instruction = (FccDirective)object;
		this.instructionPosition = instructionPosition;
		this.operandPosition = operandPosition;
		format();
	}

	@Override
	protected void format() {
		int startWsPosition = instructionPosition + getInstructioName().length();
		int nbSpacesNeeded = operandPosition-startWsPosition;
		if (nbSpacesNeeded<1) {
			nbSpacesNeeded = 1; 
		}
		setWhiteSpace(getInstruction(), getSeparatorAttribute(), nbSpacesNeeded);
	}

	@Override
	public String getInstructioName() {
		return instruction.getDirective();
	}

	@Override
	public EAttribute getSeparatorAttribute() {
		return AssemblerPackage.eINSTANCE.getFccDirective_Ws();
	}

	@Override
	public EObject getInstruction() {
		return instruction;
	}

	@Override
	public EObject getOperand() {
		return null;
	}
}
