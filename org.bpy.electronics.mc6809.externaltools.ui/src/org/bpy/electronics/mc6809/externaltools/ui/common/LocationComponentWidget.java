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
package org.bpy.electronics.mc6809.externaltools.ui.common;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * Widget component which allow to select a path.
 * 
 * 
 * @author Patrick BRIAND
 *
 */
public class LocationComponentWidget implements SelectionListener, ModifyListener {

	/** Widget which contains the selected path */
	private Text locationField;
	/** Button select a resource in the workspace */
	private Button btnBrowseWorkspace;
	/** Button for select a file in file system */
	private Button btnFileSystem;
	/** Button for add a variable */
	private Button btnVariables;
	/** Shell of the caller */
	private Shell currentShell;
	/** Reference on the caller */
	private ILocationComponentWidget parentComponent;

	/**
	 *  Constructor of the class.
	 *   
	 * @param parent reference on parent composite
	 * @param parentComponent reference on the caller
	 */
	public LocationComponentWidget(Composite parent, ILocationComponentWidget parentComponent) {
		currentShell = parent.getShell();
		this.parentComponent = parentComponent;
		populateComponent(parent);
	}
	
	/**
	 * Populate the widget
	 * 
	 * @param parent reference on parent composite
	 */
	private void populateComponent(Composite parent) {
		Group grpCalculatriceLocation = new Group(parent, SWT.NONE);
		GridData gdGrpCalculatriceLocation = new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1);
		gdGrpCalculatriceLocation.widthHint = 289;
		grpCalculatriceLocation.setLayoutData(gdGrpCalculatriceLocation);
		grpCalculatriceLocation.setText("Calculatrice location");
		GridLayout glGrpCalculatriceLocation = new GridLayout();
		glGrpCalculatriceLocation.numColumns = 4;
		grpCalculatriceLocation.setLayout(glGrpCalculatriceLocation);
		
		locationField = new Text(grpCalculatriceLocation, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 4;
		gridData.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		locationField.setLayoutData(gridData);
		locationField.addModifyListener(this);
		locationField.setText(PreferenceManager.getInstance().getCalculatorLocation());
		
		new Label(grpCalculatriceLocation, SWT.NONE);
		
		btnBrowseWorkspace = new Button(grpCalculatriceLocation, SWT.NONE);
		btnBrowseWorkspace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		btnBrowseWorkspace.setText("Workspace");
		btnBrowseWorkspace.addSelectionListener(this);
		
		btnFileSystem = new Button(grpCalculatriceLocation, SWT.NONE);
		GridData gdBtnFileSystem = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gdBtnFileSystem.widthHint = 90;
		btnFileSystem.setLayoutData(gdBtnFileSystem);
		btnFileSystem.setText("File system");
		btnFileSystem.addSelectionListener(this);
		
		btnVariables = new Button(grpCalculatriceLocation, SWT.NONE);
		GridData gdBtnVariables = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gdBtnVariables.widthHint = 90;
		btnVariables.setLayoutData(gdBtnVariables);
		btnVariables.setText("Variables");
		btnVariables.addSelectionListener(this);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Object source= e.getSource();
		if (source == btnBrowseWorkspace) {
			handleWorkspaceLocationButtonSelected();
		} else if (source == btnFileSystem) {
			handleFileLocationButtonSelected();
		} else if (source == btnVariables) {
			handleVariablesButtonSelected(locationField);
		}
	}
	
	/**
	 * Prompts the user for a workspace location within the workspace and sets
	 * the location as a String containing the workspace_loc variable or
	 * <code>null</code> if no location was obtained from the user.
	 */
	protected void handleWorkspaceLocationButtonSelected() {
		ResourceSelectionDialog dialog;
		dialog = new ResourceSelectionDialog(currentShell, ResourcesPlugin.getWorkspace().getRoot(), "Select a resource");
		dialog.open();
		Object[] results = dialog.getResult();
		if (results == null || results.length < 1) {
			return;
		}
		IResource resource = (IResource)results[0];
//		locationField.setText(newVariableExpression("workspace_loc", resource.getFullPath().toString())); //$NON-NLS-1$
	}

	/**
	 * A variable entry button has been pressed for the given text
	 * field. Prompt the user for a variable and enter the result
	 * in the given field.
	 */
	private void handleVariablesButtonSelected(Text textField) {
		String variable = getVariable();
		if (variable != null) {
			textField.insert(variable);
		}
	}
	
	/**
	 * Prompts the user to choose a location from the filesystem and
	 * sets the location as the full path of the selected file.
	 */
	protected void handleFileLocationButtonSelected() {
		FileDialog fileDialog = new FileDialog(currentShell, SWT.NONE | SWT.SHEET);
		fileDialog.setFileName(locationField.getText());
		String text= fileDialog.open();
		if (text != null) {
			locationField.setText(text);
		}
	}

	/**
	 * Prompts the user to choose and configure a variable and returns
	 * the resulting string, suitable to be used as an attribute.
	 */
	private String getVariable() {
		StringVariableSelectionDialog dialog = new StringVariableSelectionDialog(currentShell);
		dialog.open();
		return dialog.getVariableExpression();
	}


	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do here
	}

	@Override
	public void modifyText(ModifyEvent e) {
		parentComponent.locationChange(locationField.getText());
	}

	/**
	 * Return the selected path.
	 * 
	 * @return Selected path
	 */
	public String getText() {
		return locationField.getText();
	}
}
