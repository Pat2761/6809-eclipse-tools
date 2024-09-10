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
package org.bpy.electronics.mc6809.preferences.ui.dialogs;

import java.util.Map;

import org.bpy.electronics.mc6809.preferences.core.data.MacroInstructionData;
import org.eclipse.jface.wizard.Wizard;

/**
 * Macro instruction Wizard for create or modify a macro instruction
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroInstructionWizard extends Wizard {

	/** Reference on the wizard page */
	private MacroInstructionWizardPage page;
	/** Collection of macro instructions */
	private Map<String, MacroInstructionData> macroInstructions;
	/** Current macro name selected, null if no selection */
	private String macroName;

	/**
	 * Constructor of the wizard.
	 * 
	 * @param macroInstructions collection of macro instructions
	 * @param macroName Current macro name selected, null if no selection
	 */
	public MacroInstructionWizard(Map<String, MacroInstructionData> macroInstructions, String macroName) {
		setWindowTitle("Macro instruction edition");
		this.macroName = macroName;
		this.macroInstructions = macroInstructions;
	}

	@Override
	public void addPages() {
		page = new MacroInstructionWizardPage(macroInstructions, macroName);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		if (page.isPageComplete()) {
			
			if (macroName == null) {
				MacroInstructionData macro = new MacroInstructionData();
				macro.setMacroInstructionName(page.getMacroInstructionName());
				macro.setEquivalentInstructionName(page.getRealInstructionName());
				macro.setEquivalentOperand(page.getRealOperandString());
				macro.setOpcode(page.getOpcode());
				macro.setOperand(page.getOperand());
				macroInstructions.put(macro.getMacroInstructionName(), macro);

			} else {
				MacroInstructionData macro = macroInstructions.get(macroName);
				macro.setMacroInstructionName(page.getMacroInstructionName());
				macro.setEquivalentInstructionName(page.getRealInstructionName());
				macro.setEquivalentOperand(page.getRealOperandString());
				macro.setOpcode(page.getOpcode());
				macro.setOperand(page.getOperand());
			}
			return true;
		}
		return false;
	}

}
