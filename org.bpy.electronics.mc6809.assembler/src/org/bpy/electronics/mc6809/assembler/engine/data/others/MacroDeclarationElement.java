package org.bpy.electronics.mc6809.assembler.engine.data.others;

import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.eclipse.emf.ecore.EObject;

public class MacroDeclarationElement extends AbstractAssemblyLine {

	private MacroDefinition macroDefinition;
	private String macroComment;
	private String endComment;


	public void parsePass1(EObject macroDefinition, int currentPcValue, int lineNumber) {
		this.macroDefinition  = (MacroDefinition) macroDefinition;
		macroComment = this.macroDefinition.getComment1();
		endComment =  this.macroDefinition.getComment2();
		
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
