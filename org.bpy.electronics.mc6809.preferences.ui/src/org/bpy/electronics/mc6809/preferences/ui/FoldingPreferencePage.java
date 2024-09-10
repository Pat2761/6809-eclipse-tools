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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

/**
 * Foldind preference page.
 * 
 * @author Patrick BRIAND
 *
 */
public class FoldingPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	/** Folding preference page title */
	private static final String TITLE = "Foldin preferences";
	
	/** reference to the check box for macro folding */
	private Button btnFoldMacroDefinition;
	/** reference to the check box for comment folding */
	private Button btnFoldComments;
	/** reference to the check box for enable folding */
	private Button btnUseFolding;

	/**
	 * Constructor of the class.
	 * 
	 * @wbp.parser.constructor
	 */
	public FoldingPreferencePage() {
		setTitle(TITLE);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param title title of the page
	 */
	public FoldingPreferencePage(String title) {
		super(title);
		setTitle(TITLE);
	}

	/**
	 * Constructor of the class.
	 * 
	 * @param title title of the page
	 * @param image image to display
	 */
	public FoldingPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
		setTitle(TITLE);
	}

	@Override
	public void init(IWorkbench workbench) {
		// Nothing to do here
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite mainPanel = new Composite(parent, NONE);
		mainPanel.setLayout(new GridLayout(1, false));
		
		btnUseFolding = new Button(mainPanel, SWT.CHECK);
		btnUseFolding.setToolTipText("Allow to use folding functionalities");
		btnUseFolding.setText("Enable folding");
		btnUseFolding.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				enableDisableFolding();
			}
		});
		new Label(mainPanel, SWT.NONE);
		
		Label lblInitiallyFoldThese = new Label(mainPanel, SWT.NONE);
		lblInitiallyFoldThese.setText("Initially fold these elements");
		
		btnFoldMacroDefinition = new Button(mainPanel, SWT.CHECK);
		btnFoldMacroDefinition.setEnabled(false);
		btnFoldMacroDefinition.setToolTipText("Fold macros definition ");
		btnFoldMacroDefinition.setText("Fold macro definition");
		
		btnFoldComments = new Button(mainPanel, SWT.CHECK);
		btnFoldComments.setEnabled(false);
		btnFoldComments.setToolTipText("Fold comments defined in multiple consecutive lines");
		btnFoldComments.setText("Fold comments");

		setMessage("Configure folding options");
		initFields();
		return mainPanel;
	}

	/**
	 * Initialization of this widgets with preference values.
	 */
	private void initFields() {
		btnUseFolding.setSelection(PreferenceManager.getInstance().getEnableFolding());
		btnFoldComments.setSelection(PreferenceManager.getInstance().getCommentFolding());
		btnFoldMacroDefinition.setSelection(PreferenceManager.getInstance().getMacroFolding());
		enableDisableFolding();
	}

	/**
	 * Update widgets in function of the enable folding state.
	 */
	protected void enableDisableFolding() {
		btnFoldMacroDefinition.setEnabled(btnUseFolding.getSelection());
		btnFoldComments.setEnabled(btnUseFolding.getSelection());
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setEnableFolding(btnUseFolding.getSelection());
		PreferenceManager.getInstance().setMacroFolding(btnFoldMacroDefinition.getSelection());
		PreferenceManager.getInstance().setCommentFolding(btnFoldComments.getSelection());

	}

	@Override
	public boolean performOk() {
		performApply();
		return super.performOk();
	}
}
