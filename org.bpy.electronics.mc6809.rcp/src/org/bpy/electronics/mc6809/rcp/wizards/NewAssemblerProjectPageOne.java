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
package org.bpy.electronics.mc6809.rcp.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * First page of wizard which allows ti define a new project in the workspace.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewAssemblerProjectPageOne extends WizardPage implements ModifyListener {

	/** Reference to the Text widget for define the project name */
	private Text projectNameWidget;
	/** Reference to the Text widget for define the file name */
	private Text fileNameWidget;
	/** Button which allow to vreate an assembly file */
	private Button btnCreateEmptyFile;

	/** Project name */
	private String projectName;
	/** File name */
	private String fileName;

	/**
	 * Constructor of the class.
	 */
	public NewAssemblerProjectPageOne() {
		super("NewAssemblerProjectPageOne");
		setTitle("New Assembler 6809 project");
		setDescription("Fill the need fields");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Project name:");
		new Label(container, SWT.NONE);

		projectNameWidget = new Text(container, SWT.BORDER);
		projectNameWidget.setToolTipText("You have to define here a valid project name");
		projectNameWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		projectNameWidget.addModifyListener(this);
		projectNameWidget.setText("");

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setText("Browse");
		
		btnCreateEmptyFile = new Button(container, SWT.CHECK);
		btnCreateEmptyFile.setToolTipText("If the check box is check, an assembly fill will be created in the project");
		btnCreateEmptyFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnCreateEmptyFile.getSelection() && fileNameWidget.getText().isBlank()) {
						fileNameWidget.setText(projectName);
				}
				fileNameWidget.setEnabled(btnCreateEmptyFile.getSelection());
			}
		});
		btnCreateEmptyFile.setText("Create an empty assembly file");
		new Label(container, SWT.NONE);
		
		Label lblAsemblyFileName = new Label(container, SWT.NONE);
		lblAsemblyFileName.setText("Asembly file name:");
		new Label(container, SWT.NONE);
		
	   fileNameWidget = new Text(container, SWT.BORDER);
	   fileNameWidget.setToolTipText("Define here a valid filename without extention");
	   fileNameWidget.setEnabled(false);
	   fileNameWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	   fileNameWidget.addModifyListener(this);
		new Label(container, SWT.NONE);
	}

	@Override
	public void modifyText(ModifyEvent e) {
		
		// no blank value
		if (projectNameWidget.getText().isBlank()) {
			setPageComplete(false);
			setMessage("File name can't be empty", ERROR);
			return;
		}

		// Valid file name
		if (!isFilenameValid(projectNameWidget.getText())) {
			setPageComplete(false);
			setMessage("File name must be a valid file name", ERROR);
			return;
		}
		
		// Check if already exist
		if (isProjectAlreadyExist(projectNameWidget.getText())) {
			setPageComplete(false);
			setMessage("Project already exist in the workpace", ERROR);
			return;
		}
		
		if (btnCreateEmptyFile.getSelection() && fileNameWidget.getText().isBlank()) {
			setPageComplete(false);
			setMessage("An assembler file name must be define", ERROR);
			fileName = null;
			return;
		}

		if (btnCreateEmptyFile.getSelection() && !isFilenameValid(fileNameWidget.getText())) {
			setPageComplete(false);
			setMessage("The assembler file name must be a valid file name", ERROR);
			fileName = null;
			return;
		}
		
		if (btnCreateEmptyFile.getSelection()) {
			fileName = fileNameWidget.getText();
		}	
		projectName = projectNameWidget.getText();
		setPageComplete(true);
		setMessage("");
	}

	/**
	 * Check if the project exist.
	 * 
	 * @param fileName name of the project
	 * @return <b>true</b> if the project name is already use, <b>false</b> otherwise
	 */
	private boolean isProjectAlreadyExist(String fileName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		for (IProject project : root.getProjects()) {
			if ( fileName.equals(project.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the file name is valid.
	 * 
	 * @param fileName name of test
	 * @return <b>true</b> if the file name is valid, <b>false</b> otherwise
	 */
	public boolean isFilenameValid(String fileName) {
		if (fileName.contains("/") || fileName.contains("\\")) {
			return false;
		}
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = workspace.validatePath("/" + fileName, IResource.PROJECT);
		return (status.getCode() == IStatus.OK);
	}

	/**
	 * Get the project name.
	 * 
	 * @return project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Get the file name.
	 * 
	 * @return file name
	 */
	public String getFileName() {
		return fileName;
	}

}
