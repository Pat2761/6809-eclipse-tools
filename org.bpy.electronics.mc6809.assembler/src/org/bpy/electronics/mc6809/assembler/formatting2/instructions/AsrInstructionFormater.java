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
package org.bpy.electronics.mc6809.assembler.formatting2.instructions;

import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.formatting2.AbstractInstructionWithOperand;
import org.bpy.electronics.mc6809.assembler.formatting2.AssemblerFormatter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;

/**
 * Format Asr instruction.
 * 
 * @author Patrick BRIAND
 *
 */
public class AsrInstructionFormater extends AbstractInstructionWithOperand {

	/** reference on the instruction */
	private AsrInstruction asrInstruction;

	/**
	 * Constructor of the class.
	 * 
	 * @param doc reference on the document
	 * @param tabPolicy Tab policy used (Space only, tab only a mixed)
	 * @param tabSize Size of the tabulation
	 */
	public AsrInstructionFormater(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
	}

	@Override
	public void format(AssemblerFormatter assemblerFormatter, EObject instruction, int instructionPosition, int operandPosition) {
		this.assemblerFormatter = assemblerFormatter;
		this.asrInstruction = (AsrInstruction)instruction;
		this.instructionPosition = instructionPosition;
		this.operandPosition = operandPosition;
		
		format();
	}

	@Override
	public String getInstructioName() {
		return asrInstruction.getInstruction();
	}

	@Override
	public EAttribute getSeparatorAttribute() {
		return AssemblerPackage.Literals.ASR_INSTRUCTION__WS_OPERAND;
	}

	@Override
	public EObject getInstruction() {
		return asrInstruction;
	}

	@Override
	public EObject getOperand() {
		return asrInstruction.getOperand();
	}
}
