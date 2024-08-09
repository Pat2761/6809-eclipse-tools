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

import org.bpy.electronics.mc6809.rcp.Activator;
import org.bpy.electronics.mc6809.rcp.builder.FileBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

/**
 * Wizard which allows to add a new assembler file in a project.
 * 
 * @author Patrick BRIAND
 *
 */
public class NewAssemblerFile extends BasicNewResourceWizard implements INewWizard {

	/** Reference on the page */
	private NewAssemblerFilePage page;
	/** Selected project */
	private IProject currentProject;
	private WizardNewFileCreationPage mainPage;

	/**
	 * Constructor of the class.
	 */
	public NewAssemblerFile() {
		setWindowTitle("New assembly file");
	}

	@Override
	public void addPages() {
		mainPage = new WizardNewFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
		mainPage.setFileExtension("as9");
		mainPage.setTitle("Create assembly file");
		mainPage.setDescription("Create a motorola assembly file");
		addPage(mainPage);
	}

	@Override
	protected void initializeDefaultPageImageDescriptor() {
		ImageDescriptor desc = Activator.getImageDescriptor("icons/asmfile96.png");//$NON-NLS-1$
		setDefaultPageImageDescriptor(desc);
	}

	@Override
	public boolean performFinish() {
		FileBuilder fileBuilder = new FileBuilder();
		fileBuilder.createAssemblyFile((IProject)getSelection(), mainPage.getFileName());

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
	}

}
