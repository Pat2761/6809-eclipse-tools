package org.bpy.electronics.mc6809.assembler.formatting2.instructions;

import org.bpy.electronics.mc6809.assembler.assembler.AbxInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.formatting2.AbstractInstructionWithOperand;
import org.bpy.electronics.mc6809.assembler.formatting2.AssemblerFormatter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;

public class AbxInstructionFormater extends AbstractInstructionWithOperand {

	private AbxInstruction abxInstruction;

	public AbxInstructionFormater(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
	}

	@Override
	public void format(AssemblerFormatter assemblerFormatter, EObject instruction, int instructionPosition, int operandPosition) {
		this.assemblerFormatter = assemblerFormatter;
		this.abxInstruction = (AbxInstruction)instruction;
		this.instructionPosition = instructionPosition;
		this.operandPosition = operandPosition;
		
		format();
	}

	@Override
	public String getInstructioName() {
		return abxInstruction.getInstruction();
	}

	@Override
	public EAttribute getSeparatorAttribute() {
		return null;
	}

	@Override
	public EObject getInstruction() {
		return abxInstruction;
	}

	@Override
	public EObject getOperand() {
		return null;
	}
}
