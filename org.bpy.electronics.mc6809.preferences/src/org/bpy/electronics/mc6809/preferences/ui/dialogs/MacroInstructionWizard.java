package org.bpy.electronics.mc6809.preferences.ui.dialogs;

import java.util.Map;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.bpy.electronics.mc6809.preferences.ui.data.MacroInstructionData;
import org.eclipse.jface.wizard.Wizard;

public class MacroInstructionWizard extends Wizard {

	private MacroInstructionWizardPage page;
	private Map<String, MacroInstructionData> macroInstructions;

	public MacroInstructionWizard(Map<String, MacroInstructionData> macroInstructions) {
		setWindowTitle("Macro instruction edition");
		this.macroInstructions = macroInstructions;
	}

	public Map<String, MacroInstructionData> getMacroInstructions() {
		return macroInstructions;
	}

	@Override
	public void addPages() {
		page = new MacroInstructionWizardPage(macroInstructions);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		if (page.isPageComplete()) {
			MacroInstructionData macro = new MacroInstructionData();
			macro.setMacroInstructionName(page.getMacroInstructionName());
			macro.setEquivalentInstructionName(page.getRealInstructionName());
			macro.setEquivalentOperand(page.getRealOperandString());
			macroInstructions.put(macro.getMacroInstructionName(), macro);
			return true;
		}
		return false;
	}

}
