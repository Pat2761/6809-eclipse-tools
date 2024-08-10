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
package org.bpy.electronics.mc6809.rcp.builder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.XtextProjectHelper;

/**
 * Allow to create and populate this assembler project in the workspace.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerProjectBuilder {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerProjectBuilder.class.getSimpleName());

	
	/** Reference on the project */
	private IProject project;

	/** 
	 * Constructor of the class.
	 * 
	 * @param project reference on the project
	 */
	public AssemblerProjectBuilder(IProject project) {
		this.project = project;
	}

	/**
	 * Create and populate the project.
	 * 
	 * @param project reference on the project
	 * @param optionalFileName Name of the optional assembly file
	 */
	public void createProject(IProject project, String optionalFileName) {
		IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
		desc.setLocation(null);
		desc.setLocationURI(null);
		try {

			project.create(desc, new NullProgressMonitor());
			if (!project.isOpen()) {
				project.open(new NullProgressMonitor());
			}
			project.setDefaultCharset("UTF-8", new NullProgressMonitor());
			project.setDescription(desc, new NullProgressMonitor());

			if (!project.hasNature(AssemblerProjectNature.NATURE_ID)) {
				IProjectDescription description = project.getDescription();
				String[] newNatures = new String[2];
				newNatures[0] = AssemblerProjectNature.NATURE_ID;
				newNatures[1] = XtextProjectHelper.NATURE_ID;
				description.setNatureIds(newNatures);

				project.setDescription(description, new NullProgressMonitor());
			}

			createBinFolder();
			if (optionalFileName != null) {
				AssemblerFileBuilder fileBuilder = new AssemblerFileBuilder();
				fileBuilder.createAssemblyFile(project, optionalFileName);
			}

		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Create the bin folder.
	 */
	private void createBinFolder() {
		IFolder binFolder = project.getFolder("bin");

		try {
			binFolder.create(true, true, new NullProgressMonitor());
		} catch (CoreException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Bin folder error", e.getMessage());
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
