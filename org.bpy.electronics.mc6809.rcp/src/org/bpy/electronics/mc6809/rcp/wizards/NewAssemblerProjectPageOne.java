package org.bpy.electronics.mc6809.rcp.wizards;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class NewAssemblerProjectPageOne extends WizardPage implements ModifyListener {

	private Text text;
	private String projectName;
	private Button btnCreateEmptyFile;
	private Text fileNameWidget;
	private String fileName;

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

		text = new Text(container, SWT.BORDER);
		text.setToolTipText("You have to define here a valid project name");
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.addModifyListener(this);
		text.setText("");

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setText("Browse");
		
		btnCreateEmptyFile = new Button(container, SWT.CHECK);
		btnCreateEmptyFile.setToolTipText("If the check box is check, an assembly fill will be created in the project");
		btnCreateEmptyFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnCreateEmptyFile.getSelection()) {
					if (fileNameWidget.getText().isBlank()) {
						fileNameWidget.setText(projectName);
					}
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
		if (text.getText().isBlank()) {
			setPageComplete(false);
			setMessage("File name can't be empty", ERROR);
			return;
		}

		// Valid file name
		if (!isFilenameValid(text.getText())) {
			setPageComplete(false);
			setMessage("File name must be a valid file name", ERROR);
			return;
		}
		
		// Check if already exist
		if (isProjectAlreadyExist(text.getText())) {
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
		
		fileName = fileNameWidget.getText();
		projectName = text.getText();
		setPageComplete(true);
		setMessage("");
	}

	private boolean isProjectAlreadyExist(String fileName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		for (IProject project : root.getProjects()) {
			if ( fileName.equals(project.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean isFilenameValid(String fileName) {
		if (fileName.contains("/") || fileName.contains("\\")) {
			return false;
		}
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IStatus status = workspace.validatePath("/" + fileName, IResource.PROJECT);
		return (status.getCode() == IResourceStatus.OK);
	}

	public String getProjectName() {
		return projectName;
	}

	public String getFileName() {
		return fileName;
	}

}
