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

import java.util.Map;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.bpy.electronics.mc6809.preferences.ui.data.MacroInstructionData;
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
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;

/**
 * Allow to define the list of possible macros instructions used by the assembler
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroInstructionsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private Button btnNew;
	private Table table_1;
	private TableViewer tableViewer;

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
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL
            | SWT.V_SCROLL );
		Table table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		
		TableViewerColumn nameViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn macroNameColumn = nameViewerColumn.getColumn();
		macroNameColumn.setText("Name");
		macroNameColumn.setWidth(100);
		
		TableViewerColumn instructionViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn instructionColumn = instructionViewerColumn.getColumn();
		instructionColumn.setText("Instruction");
		instructionColumn.setWidth(100);

		TableViewerColumn operandViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn operandColumn = operandViewerColumn.getColumn();
		operandColumn.setText("Operand");
		operandColumn.setWidth(100);
		
		tableViewer.setContentProvider(new MacroContentProvider());
		tableViewer.setLabelProvider(new MacroInstructionLabelProvider());
		
		btnNew = new Button(container, SWT.NONE);
		btnNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Map<String, MacroInstructionData> macros = PreferenceManager.getInstance().getMacroInstructionPreferences();
				MacroInstructionWizard wizard = new MacroInstructionWizard(macros);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				if (dialog.open() == Window.OK) {
					PreferenceManager.getInstance().setMacroInstructionPreferences(wizard.getMacroInstructions());
					
					updateDisplay();
				}
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

				int newWidth = table.getBounds().width - macroNameColumn.getWidth() - instructionColumn.getWidth() ;
				operandColumn.setWidth(newWidth);
				super.controlResized(e);
			}
			
		});

		
		updateDisplay();
		
		
		return container;
	}

	protected void updateDisplay() {
		Map<String, MacroInstructionData> macros = PreferenceManager.getInstance().getMacroInstructionPreferences();
		IContentProvider contentProvider = tableViewer.getContentProvider();
		contentProvider.inputChanged(tableViewer, null, macros);
		
	}

}
