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

import org.bpy.electronics.mc6809.preferences.ui.dialogs.MacroInstructionWizard;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * Allow to define the list of possible macros instructions used by the assembler
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroInstructionsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private Table table;
	private Button btnNew;

	/**
	 * Constructor of the class.
	 * @wbp.parser.constructor
	 */
	public MacroInstructionsPreferencePage() {
		super("Define macros instructions");
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param title title of the preference page
	 */
	public MacroInstructionsPreferencePage(String title) {
		super(title);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param title title of the preference page
	 * @param image image of the preference page
	 */
	public MacroInstructionsPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
		// nothing to do
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		container.pack();
		
		Label lblMacroInstructionsDescription = new Label(container, SWT.NONE);
		lblMacroInstructionsDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblMacroInstructionsDescription.setText("Macro instructions description: ");
		new Label(container, SWT.NONE);
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4);
		gd_table.widthHint = 233;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(79);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnInstruction = new TableColumn(table, SWT.NONE);
		tblclmnInstruction.setWidth(93);
		tblclmnInstruction.setText("Instruction");
		
		TableColumn tblclmnOperand = new TableColumn(table, SWT.NONE);
		tblclmnOperand.setWidth(122);
		tblclmnOperand.setText("Operand");
		
		btnNew = new Button(container, SWT.NONE);
		btnNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MacroInstructionWizard wizard = new MacroInstructionWizard();
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				dialog.open();
			}
		});
		btnNew.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNew.setText("New");
		
		Button btnModify = new Button(container, SWT.NONE);
		btnModify.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnModify.setText("Modify");
		
		Button btnDelete = new Button(container, SWT.NONE);
		btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnDelete.setText("Delete");
		
		new Label(container, SWT.NONE);
		
		table.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(ControlEvent e) {

				int newWidth = table.getBounds().width - tblclmnName.getWidth() - tblclmnInstruction.getWidth() ;
				tblclmnOperand.setWidth(newWidth);
				super.controlResized(e);
			}
			
		});
		return container;
	}

}
