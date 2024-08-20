package org.bpy.electronics.mc6809.rcp.dialogs;

import java.util.ArrayList;
import java.util.Collections;

import org.bpy.electronics.mc6809.rcp.builder.AssemblerProjectNature;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

public class AssemblerFileSelector extends Dialog {
	
	public class AssemblerResourceVisitor implements IResourceVisitor {

		@Override
		public boolean visit(IResource resource) throws CoreException {
			if ((resource instanceof IFile resourceFile) && 
				 (resourceFile.getName().toLowerCase().endsWith(".as9"))) {
				assemblyFiles.add(resourceFile);
			}
			return true;
		}
	}
	
	private Combo projectSelector;
	private Button btnSelectAll;
	private Button btnUnselectAll;
	private List fileSelector;

	private java.util.List<IProject> projects;
	private java.util.List<IFile> assemblyFiles;
	private Object currentSelectedObject; 
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public AssemblerFileSelector(Shell parentShell) {
		super(parentShell);
		projects = new ArrayList<>();
	}

	public void initDialog(ISelection selection) {
		projects = new ArrayList<>();

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for (IProject project : workspace.getRoot().getProjects()) {
			try {
				if (project.hasNature(AssemblerProjectNature.NATURE_ID)) {
					projects.add(project);
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		if ((selection != null) && (selection instanceof TreeSelection treeSelection)) {
			currentSelectedObject = treeSelection.getFirstElement();
		}
		
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));
		
		Label lblProjects = new Label(container, SWT.NONE);
		lblProjects.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblProjects.setText("Projects :");
		new Label(container, SWT.NONE);
		
		projectSelector = new Combo(container, SWT.NONE);
		projectSelector.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		projectSelector.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				populateListOfAssemblyFiles();	
			}
			
		});
		
		Label lblfile = new Label(container, SWT.NONE);
		lblfile.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 1, 1));
		lblfile.setText("Select assembly files :");
		new Label(container, SWT.NONE);
		
		fileSelector = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		fileSelector.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 3));
		
		btnSelectAll = new Button(container, SWT.NONE);
		GridData gdBtnSelectAll = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdBtnSelectAll.widthHint = 158;
		btnSelectAll.setLayoutData(gdBtnSelectAll);
		btnSelectAll.setText("Select all");
		
		btnUnselectAll = new Button(container, SWT.NONE);
		btnUnselectAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnUnselectAll.setText("Unselect all");
		
		Label lblEmpty = new Label(container, SWT.NONE);
		lblEmpty.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));

		populateProjects();
		
		return container;
	}

	protected void populateListOfAssemblyFiles() {
		String projectName = projectSelector.getItem(projectSelector.getSelectionIndex());
		if (projectName != null) {
			IProject project = (IProject) projectSelector.getData(projectName);
	
			try {
				assemblyFiles = new ArrayList<>();
				project.accept(new AssemblerResourceVisitor());

				String projectPath = project.getLocation().toString();
				fileSelector.removeAll();
				for (IFile assemblyFile : assemblyFiles) {
					String filePath = assemblyFile.getRawLocation().toString().replace(projectPath, "");
					filePath = filePath.replaceFirst("/", "");
					fileSelector.add(filePath);
					fileSelector.setData(filePath, assemblyFile);
				}
			
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void populateProjects() {
		projectSelector.removeAll();
		if (!projects.isEmpty()) {
			Collections.sort(projects , (o1, o2) -> o1.getName().compareTo(o2.getName()));
			for (IProject project : projects) {
				projectSelector.add(project.getName());
				projectSelector.setData(project.getName(), project);
			}
			if (currentSelectedObject instanceof IProject selectedProject) {
				projectSelector.select(projectSelector.indexOf(selectedProject.getName()));
			} else {
				projectSelector.select(0);
			}	
		}
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(583, 369);
	}

}
