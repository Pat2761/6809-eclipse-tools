package org.bpy.electronics.mc6809.assembler.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;

public abstract class AbstractInstructionWithOperand extends AbstractObjectFormatter {

	protected AbstractInstructionWithOperand(IFormattableDocument doc, String tabPolicy, int tabSize) {
		super(doc, tabPolicy, tabSize);
		// Nothing to do
	}
}
