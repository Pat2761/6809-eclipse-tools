package org.bpy.electronics.mc6809.rcp.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;

public class FormattingPreferences extends PreferencePage implements IWorkbenchPreferencePage {
	private Combo tabPolicy;
	private Spinner tabSize;
	private Spinner labelSize;
	private Spinner instructionSize;
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
		tabSize.setMaximum(10);
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

		String value = PreferenceManager.getInstance().getStringPreferenceValue(PreferenceManager.TAB_POLICY);
		tabPolicy.setText(PreferenceManager.getInstance().getStringPreferenceValue(PreferenceManager.TAB_POLICY));
		tabSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.TAB_SIZE));
		tabSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.LABEL_SIZE));
		tabSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.INSTRUCTION_SIZE));
		tabSize.setSelection(PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.OPERAND_SIZE));

		return container;
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().savePreference(PreferenceManager.TAB_POLICY, tabPolicy.getText());
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
	}
}
