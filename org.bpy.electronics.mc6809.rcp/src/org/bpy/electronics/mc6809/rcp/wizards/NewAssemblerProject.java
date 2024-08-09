package org.bpy.electronics.mc6809.rcp.wizards;

import java.io.File;

import org.bpy.electronics.mc6809.rcp.builder.AssemblerProjectBuilder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewAssemblerProject extends Wizard implements INewWizard {

	private NewAssemblerProjectPageOne pageOne;


	public NewAssemblerProject() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setWindowTitle(String newTitle) {
		getShell().setText("New Motorola project");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		pageOne = new NewAssemblerProjectPageOne();
		addPage(pageOne);
	}

	@Override
	public void addPages() {
		super.addPages();
	}


	@Override
	public boolean performFinish() {
		String baseWS = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath();
		String projectName = baseWS + File.separator + pageOne.getProjectName();

		File projectPath = new File(projectName);
		if (!projectPath.exists()) {
			projectPath.mkdir();
		}
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(pageOne.getProjectName());
		AssemblerProjectBuilder projectBuilder = new AssemblerProjectBuilder(project);
		projectBuilder.createProject(project, pageOne.getFileName());
		return true;
	}
}
