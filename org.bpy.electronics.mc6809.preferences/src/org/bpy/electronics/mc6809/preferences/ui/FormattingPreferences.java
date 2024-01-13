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
package org.bpy.electronics.mc6809.preferences.ui;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

/**
 * This class is a preference page which allow define preferences
 * linked to the formatting function of the 6809 editor
 * 
 * @author briand
 *
 */
public class FormattingPreferences extends PreferencePage implements IWorkbenchPreferencePage {
	/** combo for define the TAB policy (Space only, tab only or a mixed of tab and space */
	private Combo tabPolicy;
	/** Allow to define the size of a tab character */
	private Spinner tabSize;
	/** Allow to define the size maximum of a Label */
	private Spinner labelSize;
	/** Allow to define the size maximum of an instruction */
	private Spinner instructionSize;
	/** Allow to define the size maximum of an operand */
	private Spinner operandSize;

	/**
	 * Create the preference page.
	 */
	public FormattingPreferences() {
		setTitle("Formatter");
	}

	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		
		Label lblTabPolicy = new Label(container, SWT.NONE);
		lblTabPolicy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblTabPolicy.setText("Tab policy");
		
		tabPolicy = new Combo(container, SWT.NONE);
		tabPolicy.setItems(new String[] {PreferenceManager.SPACE_ONLY, PreferenceManager.TAB_ONLY, PreferenceManager.MIXED});
		GridData gd_tabPolicy = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_tabPolicy.widthHint = 108;
		tabPolicy.setLayoutData(gd_tabPolicy);
		tabPolicy.select(0);
		
		Label lblTabSize = new Label(container, SWT.NONE);
		lblTabSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTabSize.setText("Tab size");
		
		tabSize = new Spinner(container, SWT.BORDER);
		tabSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		tabSize.setMaximum(5);
		tabSize.setMinimum(1);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblLabelSize = new Label(container, SWT.NONE);
		lblLabelSize.setText("Label size");
		
		labelSize = new Spinner(container, SWT.BORDER);
		labelSize.setMaximum(15);
		labelSize.setMinimum(5);
		labelSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Label lblOperandSize = new Label(container, SWT.NONE);
		lblOperandSize.setText("Instruction size");
		
		instructionSize = new Spinner(container, SWT.BORDER);
		instructionSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		instructionSize.setMaximum(10);
		instructionSize.setMinimum(6);
		
		Label lblOperandSize_1 = new Label(container, SWT.NONE);
		lblOperandSize_1.setText("Operand size");
		
		operandSize = new Spinner(container, SWT.BORDER);
		operandSize.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		operandSize.setMaximum(40);
		operandSize.setMinimum(15);
		
		initFields();

		return container;
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.TAB_POLICY, 
				tabPolicy.getText());
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.TAB_SIZE, 
				tabSize.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.LABEL_SIZE, 
				labelSize.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.INSTRUCTION_SIZE, 
				instructionSize.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.OPERAND_SIZE, 
				operandSize.getSelection());
	}

	@Override
	protected void performDefaults() {
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.TAB_POLICY, 
				PreferenceManager.TAB_POLICY_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.TAB_SIZE, 
				PreferenceManager.TAB_SIZE_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.LABEL_SIZE, 
				PreferenceManager.LABEL_SIZE_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.INSTRUCTION_SIZE, 
				PreferenceManager.INSTRUCTION_SIZE_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(
				PreferenceManager.OPERAND_SIZE, 
				PreferenceManager.OPERAND_SIZE_DEFAULT_VALUE);
		
		initFields();
		super.performDefaults();
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
	}

	/** 
	 * Initialize all widget with the values defined in the preferences
	 * 
	 */
	private void initFields() {
		tabPolicy.setText(PreferenceManager.getInstance().getStringPreferenceValue(PreferenceManager.TAB_POLICY));
		tabSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.TAB_SIZE));
		labelSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.LABEL_SIZE));
		instructionSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.INSTRUCTION_SIZE));
		operandSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.OPERAND_SIZE));
	}
}
