package org.bpy.electronics.mc6809.assembler.engine.data.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bpy.electronics.mc6809.assembler.assembler.BccInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BcsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BeqInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgeInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgtInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BleInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BloInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BlsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BltInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BmiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BneInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BraInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BrnInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BvcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BvsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class MacroAssembledElement extends AbstractAssemblyLine {

	private MacroDefinition macroDefinition;
	private List<AbstractAssemblyLine> assemblyLines;
	private List<InstructionLine> instructionLines;
	private Map<String,String> internalLabels;
	
	private int callCounter = 1;
	
	public MacroAssembledElement() {
		assemblyLines = new ArrayList<>();
		instructionLines = new ArrayList<>();
		internalLabels = new HashMap<>();
	}
	
	public List<AbstractAssemblyLine> getAssemblyLines() {
		return assemblyLines;
	}

	public void parse(MacroDefinition macroDefinition, int callCounter) {
		this.callCounter = callCounter;
		this.macroDefinition = macroDefinition;

		// update the labels
		for (InstructionLine instruction : macroDefinition.getInstructions()) {
			
			InstructionLine cloneInstruction = EcoreUtil.copy(instruction); 
			if (cloneInstruction.getLabel() != null && cloneInstruction.getLabel().getName() != null)  {
				label = cloneInstruction.getLabel().getName().getValue();
				String newLabel = label + "_" + callCounter; 
				cloneInstruction.getLabel().getName().setValue(newLabel);
				internalLabels.put(label,newLabel);
			}
			instructionLines.add(cloneInstruction);
		}
		
		// update the label references to Jump or branch instruction
		for (InstructionLine instruction : instructionLines) {
			if (instruction.getInstruction() instanceof BccInstruction bccInstruction) {
				changeReference(bccInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BcsInstruction bcsInstruction) {
				changeReference(bcsInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BeqInstruction beqInstruction) {
				changeReference(beqInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BgeInstruction bgeInstruction) {
				changeReference(bgeInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BgtInstruction bgtInstruction) {
				changeReference(bgtInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BhiInstruction bhiInstruction) {
				changeReference(bhiInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BhsInstruction bhsInstruction) {
				changeReference(bhsInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BleInstruction bleInstruction) {
				changeReference(bleInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BloInstruction bloInstruction) {
				changeReference(bloInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BlsInstruction blsInstruction) {
				changeReference(blsInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BltInstruction bltInstruction) {
				changeReference(bltInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BmiInstruction bmiInstruction) {
				changeReference(bmiInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BneInstruction bneInstruction) {
				changeReference(bneInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BplInstruction bplInstruction) {
				changeReference(bplInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BraInstruction braInstruction) {
				changeReference(braInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BrnInstruction brnInstruction) {
				changeReference(brnInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BsrInstruction bsrInstruction) {
				changeReference(bsrInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BvcInstruction bvcInstruction) {
				changeReference(bvcInstruction.getOperand());
			} else if (instruction.getInstruction() instanceof BvsInstruction bvsInstruction) {
				changeReference(bvsInstruction.getOperand());
			}
		}	
	}

	private void changeReference(RelativeMode operand) {
		if (operand.getOffset() != null) {
			String operandString = operand.getOffset().getValue();
			if (internalLabels.containsKey(operandString)) {
				operand.getOffset().setValue(internalLabels.get(operandString));
			}
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
