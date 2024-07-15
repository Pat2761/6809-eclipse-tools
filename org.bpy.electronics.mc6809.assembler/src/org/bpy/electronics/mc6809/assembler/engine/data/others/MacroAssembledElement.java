package org.bpy.electronics.mc6809.assembler.engine.data.others;

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class MacroAssembledElement extends AbstractAssemblyLine {

	private MacroDefinition macroDefinition;
	private List<AbstractAssemblyLine> assemblyLines;
	private List<InstructionLine> instructionLines;

	private static int callCounter;
	
	public MacroAssembledElement() {
		assemblyLines = new ArrayList<>();
		instructionLines = new ArrayList<>();
		callCounter=1;
	}
	
	public void parse(MacroDefinition macroDefinition) {
		this.macroDefinition = macroDefinition;

		for (InstructionLine instruction : macroDefinition.getInstructions()) {
			
			InstructionLine cloneInstruction = EcoreUtil.copy(instruction); 
			if (cloneInstruction.getLabel() != null && cloneInstruction.getLabel().getName() != null)  {
				label = cloneInstruction.getLabel().getName().getValue();
				String newLabel = label + "_" + callCounter; 
				cloneInstruction.getLabel().getName().setValue(newLabel);
				callCounter++;
			}
			instructionLines.add(cloneInstruction);
		}
	}

	public MacroDefinition getMacroDefinition() {
		return macroDefinition;
	}
	
	public List<InstructionLine> getInstructionLines() {
		return instructionLines;
	}

	public void addAssembledInstruction(AbstractAssemblyLine assemblyLine) {
		assemblyLines.add(assemblyLine);
	}
	
	@Override
	public int getPcIncrement() {
		int size = 0;
		for (AbstractAssemblyLine assemblyLine : assemblyLines) {
			size += assemblyLine.getPcIncrement();
		}
		return size;
	}
}
