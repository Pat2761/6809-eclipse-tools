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

/**
 * Use to store the assembled code of the macro.
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroAssembledElement extends AbstractAssemblyLine {

	/** memorize the macro definition */
	private MacroDefinition macroDefinition;
	
	/** contains the assembled lines */
	private List<AbstractAssemblyLine> assemblyLines;
	/** Contains the cloned instruction lines */
	private List<InstructionLine> instructionLines;
	/** Memorize the internals labels */
	private Map<String,String> internalLabels;

	/**
	 * Constructor of the class.
	 */
	public MacroAssembledElement() {
		assemblyLines = new ArrayList<>();
		instructionLines = new ArrayList<>();
		internalLabels = new HashMap<>();
	}
	
	/**
	 * Return the assembly lines.
    *
	 * @return List of assembly lines
	 */
	public List<AbstractAssemblyLine> getAssemblyLines() {
		return assemblyLines;
	}

	/** 
	 * Assemble the content of the macro.
	 * Update all internals labels and their references.
	 * 
	 * @param macroDefinition reference on the macro definition
	 * @param callCounter number of use
	 */
	public void parse(MacroDefinition macroDefinition, int callCounter) {
		
		this.macroDefinition = macroDefinition;

		updateLabelDefinition(callCounter);
		updateLabelUsage();
	}

	/**
	 * Update the reference to internal labels
	 */
	private void updateLabelUsage() {
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

	/**
	 * Update all internal labels.
	 * 
	 * @param callCounter number of call
	 */
	private void updateLabelDefinition(int callCounter) {
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
	}

	/**
	 * Change the reference to an internal label.
	 * 
	 * @param operand reference on the operand to change
	 */
	private void changeReference(RelativeMode operand) {
		if (operand.getOffset() != null) {
			String operandString = operand.getOffset().getValue();
			if (internalLabels.containsKey(operandString)) {
				operand.getOffset().setValue(internalLabels.get(operandString));
			}
		}	
	}

	/**
	 * Return the reference to the macro definition.
	 * 
	 * @return reference on the macro definition
	 */
	public MacroDefinition getMacroDefinition() {
		return macroDefinition;
	}
	
	/**
	 * Get the list of instructions in the macro
	 * 
	 * @return list of instructions in the macro
	 */
	public List<InstructionLine> getInstructionLines() {
		return instructionLines;
	}

	/**
	 * Add an assembly line for this macro
	 * 
	 * @param assemblyLine reference on the assembly line
	 */
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
