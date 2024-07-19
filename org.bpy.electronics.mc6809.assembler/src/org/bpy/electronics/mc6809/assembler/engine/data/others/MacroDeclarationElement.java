package org.bpy.electronics.mc6809.assembler.engine.data.others;

import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;

public class MacroDeclarationElement extends AbstractAssemblyLine {

	private MacroDefinition macroDefinition;
	private String macroComment;
	private String endComment;


	public void parse(MacroDefinition macroDefinition, int currentPcValue, int lineNumber) {
		this.macroDefinition  = macroDefinition;
		macroComment = macroDefinition.getComment1();
		endComment =  macroDefinition.getComment2();
		
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		
	}

	
	public String getMacroComment() {
		return macroComment;
	}


	public String getEndComment() {
		return endComment;
	}


	public MacroDefinition getMacroDefinition() {
		return macroDefinition;
	}


	@Override
	public int getPcIncrement() {
		return 0;
	}

}
