package org.bpy.electronics.mc6809.assembler.engine;

import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;

public class AssemblerEngine {
	
	private int pcValue;

	
	public AssemblerEngine() {
		pcValue = -1;
	}
	
	public void engine(Model model) {
		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			System.out.println(sourceLine);
		}
	}
}
