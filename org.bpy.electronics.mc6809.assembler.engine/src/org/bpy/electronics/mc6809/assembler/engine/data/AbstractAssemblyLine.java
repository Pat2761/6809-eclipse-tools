package org.bpy.electronics.mc6809.assembler.engine.data;

import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;

public abstract class AbstractAssemblyLine {

	private SourceLine sourceLine;

	public SourceLine getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(SourceLine sourceLine) {
		this.sourceLine = sourceLine;
	}	
	
}
