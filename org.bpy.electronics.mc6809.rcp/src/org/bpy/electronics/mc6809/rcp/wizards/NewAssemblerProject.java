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

import java.io.File;

import org.bpy.electronics.mc6809.rcp.Activator;
import org.bpy.electronics.mc6809.rcp.builder.AssemblerProjectBuilder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard for define the attribute of a an assembler project.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewAssemblerProject extends Wizard implements INewWizard {

	/** reference on the first page of the wizard */
	private NewAssemblerProjectPageOne pageOne;

	public NewAssemblerProject() {
		// Nothing to do here
	}

	@Override
	public void setWindowTitle(String newTitle) {
		setWindowTitle("New Motorola project");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setDefaultPageImageDescriptor(Activator.getImageDescriptor("icons/motorola256.jpg"));

		pageOne = new NewAssemblerProjectPageOne();
		addPage(pageOne);
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
