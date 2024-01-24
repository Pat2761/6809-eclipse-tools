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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * This class is a preference page which allow define preferences linked to the
 * formatting function of the 6809 editor
 * 
 * @author briand
 *
 */
public class FormattingPreferences extends PreferencePage implements IWorkbenchPreferencePage, ModifyListener {

	/**
	 * combo for define the TAB policy (Space only, tab only or a mixed of tab and
	 * space
	 */
	private Combo tabPolicy;
	/** Allow to define the size of a tab character */
	private Spinner tabSize;
	/** Allow to define the size maximum of an instruction */
	private Spinner instructionPosition;
	/** Allow to define the size maximum of an operand */
	private Spinner operandPosition;
	private Spinner commentPosition;

	/**
	 * Create the preference page.
	 */
	public FormattingPreferences() {
		setTitle("Formatter");
	}

	/**
	 * Create contents of the preference page.
	 * 
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));

		Group grpTabPreferences = new Group(container, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		grpTabPreferences.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		GridData gd_grpTabPreferences = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_grpTabPreferences.widthHint = 120;
		grpTabPreferences.setLayoutData(gd_grpTabPreferences);
		grpTabPreferences.setText("Tab preferences");
		grpTabPreferences.setLayout(new GridLayout(2, false));

		Label lblTabPolicy = new Label(grpTabPreferences, SWT.NONE);
		lblTabPolicy.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTabPolicy.setText("Tab policy");

		tabPolicy = new Combo(grpTabPreferences, SWT.NONE);
		GridData gd_tabPolicy = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_tabPolicy.widthHint = 100;
		tabPolicy.setLayoutData(gd_tabPolicy);
		tabPolicy.setItems(
				new String[] { PreferenceManager.SPACE_ONLY, PreferenceManager.TAB_ONLY, PreferenceManager.MIXED });
		tabPolicy.select(0);
		tabPolicy.addModifyListener(this);

		Label lblTabSize = new Label(grpTabPreferences, SWT.NONE);
		lblTabSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTabSize.setText("Tab size");

		tabSize = new Spinner(grpTabPreferences, SWT.BORDER);
		GridData gd_tabSize = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_tabSize.widthHint = 40;
		tabSize.setLayoutData(gd_tabSize);
		tabSize.setMaximum(5);
		tabSize.setMinimum(1);
		tabSize.addModifyListener(this);

		Group grpLineFormat = new Group(container, SWT.BORDER | SWT.SHADOW_ETCHED_OUT);
		grpLineFormat.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpLineFormat.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpLineFormat.setText("Line format");
		grpLineFormat.setLayout(new GridLayout(2, false));
		Label lblInstructionSize = new Label(grpLineFormat, SWT.NONE);
		lblInstructionSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblInstructionSize.setText("Instruction position");

		instructionPosition = new Spinner(grpLineFormat, SWT.BORDER);
		instructionPosition.setToolTipText("define the position of the instruction (10 to 25 characters)");
		GridData gd_instructionPosition = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_instructionPosition.widthHint = 40;
		instructionPosition.setLayoutData(gd_instructionPosition);
		instructionPosition.setMaximum(25);
		instructionPosition.setMinimum(10);

		Label lblOperandSize_1 = new Label(grpLineFormat, SWT.NONE);
		lblOperandSize_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblOperandSize_1.setText("Operand position");

		operandPosition = new Spinner(grpLineFormat, SWT.BORDER);
		operandPosition.setToolTipText("define the position of the operand(26 to 50 characters)");
		GridData gd_operandPosition = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_operandPosition.widthHint = 40;
		operandPosition.setLayoutData(gd_operandPosition);
		operandPosition.setMaximum(50);
		operandPosition.setMinimum(26);

		Label lblCpmmentPosition = new Label(grpLineFormat, SWT.NONE);
		lblCpmmentPosition.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblCpmmentPosition.setText("Comment position");

		commentPosition = new Spinner(grpLineFormat, SWT.BORDER);
		commentPosition.setToolTipText("define the position of the comment (52 to 100 characters)");
		commentPosition.setMinimum(52);
		GridData gd_commentPosition = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_commentPosition.widthHint = 40;
		commentPosition.setLayoutData(gd_commentPosition);
	

		initFields();
		operandPosition.addModifyListener(this);
		instructionPosition.addModifyListener(this);
		commentPosition.addModifyListener(this);

		return container;
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_POLICY, tabPolicy.getText());
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_SIZE, tabSize.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.INSTRUCTION_POSITION,instructionPosition.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.OPERAND_POSITION,operandPosition.getSelection());
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_POSITION,commentPosition.getSelection());
	}

	@Override
	protected void performDefaults() {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_POLICY,
				PreferenceManager.TAB_POLICY_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_SIZE,
				PreferenceManager.TAB_SIZE_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.INSTRUCTION_POSITION,
				PreferenceManager.INSTRUCTION_POSITION_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.OPERAND_POSITION,
				PreferenceManager.OPERAND_POSITION_DEFAULT_VALUE);
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_POSITION,
				PreferenceManager.COMMENT_POSITION_DEFAULT_VALUE);

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
		instructionPosition.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.INSTRUCTION_POSITION));
		operandPosition.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.OPERAND_POSITION));
		commentPosition.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.COMMENT_POSITION));
	}

	@Override
	public void modifyText(ModifyEvent e) {
		if (PreferenceManager.TAB_ONLY.equals(tabPolicy.getText())) {
			int newInstructionPosition = instructionPosition.getSelection();
			int newOperandPosition = operandPosition.getSelection();
			int newCommentPosition = commentPosition.getSelection();
			int tabSizeValue = tabSize.getSelection();
			boolean modificationRequest = false;

			StringBuilder strBuilder = new StringBuilder("Inconsistency values are found for tabs only policies\n");

			int instructionPositionRest = instructionPosition.getSelection() % tabSize.getSelection();
			if (instructionPositionRest > 0) {
				int instructionPositionTab = (instructionPosition.getSelection() / tabSize.getSelection()) + 1;
				newInstructionPosition = instructionPositionTab * tabSizeValue;
				strBuilder.append("Instruction position may be set to " + newInstructionPosition + "\n");
				modificationRequest = true;
			}

			int operandPositionRest = operandPosition.getSelection() % tabSize.getSelection();
			if (operandPositionRest > 0) {
				int operandPositionTab = (operandPosition.getSelection() / tabSize.getSelection()) + 1;
				newOperandPosition = operandPositionTab * tabSizeValue;
				strBuilder.append("Operand position may be set to " + newOperandPosition + "\n");
				modificationRequest = true;
			}

			int commentPositionRest = commentPosition.getSelection() % tabSize.getSelection();
			if (commentPositionRest > 0) {
				int commentPositionTab = (commentPosition.getSelection() / tabSize.getSelection()) + 1;
				newCommentPosition = commentPositionTab * tabSizeValue;
				strBuilder.append("Comment position may be set to " + newCommentPosition + "\n");
				modificationRequest = true;
			}

			if (modificationRequest) {

				operandPosition.removeModifyListener(this);
				instructionPosition.removeModifyListener(this);
				commentPosition.removeModifyListener(this);
				
				boolean response = MessageDialog.openQuestion(this.getShell(), "Inconsistency values",strBuilder.toString());
				if (response) {
					instructionPosition.setSelection(newInstructionPosition);
					operandPosition.setSelection(newOperandPosition);
					commentPosition.setSelection(newCommentPosition);
				}

				operandPosition.addModifyListener(this);
				instructionPosition.addModifyListener(this);
				commentPosition.addModifyListener(this);
			}
		}
	}
}
