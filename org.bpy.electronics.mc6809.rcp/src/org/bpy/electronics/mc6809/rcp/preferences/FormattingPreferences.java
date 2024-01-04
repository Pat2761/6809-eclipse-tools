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

		return container;
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference page
	}
}
