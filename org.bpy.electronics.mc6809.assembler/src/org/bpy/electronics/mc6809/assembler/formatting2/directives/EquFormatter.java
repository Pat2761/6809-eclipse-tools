package org.bpy.electronics.mc6809.assembler.formatting2.directives;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.formatting2.AbstractObjectFormatter;
import org.bpy.electronics.mc6809.assembler.formatting2.AssemblerFormatter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;

public class EquFormatter extends AbstractObjectFormatter {

	private EquDirective instruction;

	public EquFormatter(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
	}

	public void format(AssemblerFormatter assemblerFormatter, EObject object, int instructionPosition, int operandPosition) {
		this.assemblerFormatter = assemblerFormatter;
		this.instruction = (EquDirective)object;
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
		return AssemblerPackage.Literals.EQU_DIRECTIVE__WS;
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
