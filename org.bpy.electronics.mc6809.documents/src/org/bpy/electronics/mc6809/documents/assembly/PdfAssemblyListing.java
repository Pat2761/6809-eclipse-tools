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
package org.bpy.electronics.mc6809.documents.assembly;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.ui.internal.AssemblerActivator;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import com.google.inject.Injector;

/**
 * Invoke the document creator.
 * 
 * @author Patrick BRIAND
 *
 */
public class PdfAssemblyListing {
	
	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(PdfAssemblyListing.class.getSimpleName());

	/** Injector on the Game parser */
	private static final Injector injector = AssemblerActivator.getInstance().getInjector("org.bpy.electronics.mc6809.assembler.Assembler"); //$NON-NLS-1$

	/**
	 * Constructor of the class
	 */
	public PdfAssemblyListing() {
		// nothing to do
	}
	
	/**
	 * Entry point for create and build a PDF listing file
	 * 
	 * @param fileToDo reference on the Assembly file in the project
	 */
	public void buildAssemblyFile(IFile fileToDo) {
		IFolder folder = getOrCreateDocumentFolder(fileToDo);
		File pdfFile = new File(folder.getLocation().toOSString(), fileToDo.getName().replace(".as9", "") + ".pdf");

		XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(fileToDo.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(URI.createURI(fileToDo.getLocationURI().toString()), true);
		Model model = (Model) resource.getContents().get(0);

		ListingPdfBuilder documentBuilder = new ListingPdfBuilder();
		documentBuilder.build(pdfFile, model);
	}

	/**
	 * Retrieve or create a document folder in the project.
	 * 
	 * @param fileToDo reference on the file in the project
	 * @return reference on the document folder
	 */
	private IFolder getOrCreateDocumentFolder(IFile fileToDo) {
		IProject project = fileToDo.getProject();
		IFolder folder = project.getFolder("documents");
		if (!folder.exists()) {
			try {
				folder.create(true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		return folder;
	}
}
