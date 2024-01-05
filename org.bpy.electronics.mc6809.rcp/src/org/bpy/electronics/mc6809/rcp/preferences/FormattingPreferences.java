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
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setItems(new String[] {"Space only", "Tabs only", "Mixed"});
		GridData gd_combo = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 108;
		combo.setLayoutData(gd_combo);
		combo.select(0);
		
		Label lblTabSize = new Label(container, SWT.NONE);
		lblTabSize.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblTabSize.setText("Tab size");
		
		Spinner spinner = new Spinner(container, SWT.BORDER);
		spinner.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		spinner.setMaximum(10);
		spinner.setMinimum(1);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblLabelSize = new Label(container, SWT.NONE);
		lblLabelSize.setText("Label size");
		
		Spinner spinner_1 = new Spinner(container, SWT.BORDER);
		spinner_1.setMaximum(15);
		spinner_1.setMinimum(5);
		spinner_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Label lblOperandSize = new Label(container, SWT.NONE);
		lblOperandSize.setText("Instruction size");
		
		Spinner spinner_1_1 = new Spinner(container, SWT.BORDER);
		spinner_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		spinner_1_1.setMaximum(10);
		spinner_1_1.setMinimum(6);
		
		Label lblOperandSize_1 = new Label(container, SWT.NONE);
		lblOperandSize_1.setText("Operand size");
		
		Spinner spinner_1_1_1 = new Spinner(container, SWT.BORDER);
		spinner_1_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		spinner_1_1_1.setMaximum(40);
		spinner_1_1_1.setMinimum(15);

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference page
	}
}
