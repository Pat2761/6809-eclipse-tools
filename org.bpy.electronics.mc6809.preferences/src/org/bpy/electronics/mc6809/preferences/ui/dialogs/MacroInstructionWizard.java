package org.bpy.electronics.mc6809.preferences.ui.dialogs;

import org.eclipse.jface.wizard.Wizard;

public class MacroInstructionWizard extends Wizard {

	private MacroInstructionWizardPage page;

	public MacroInstructionWizard() {
		setWindowTitle("Macro instruction edition");
	}

	@Override
	public void addPages() {
		page = new MacroInstructionWizardPage();
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
