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
package org.bpy.electronics.mc6809.rcp.handlers;

import org.bpy.electronics.mc6809.documents.assembly.PdfAssemblyListing;
import org.bpy.electronics.mc6809.rcp.dialogs.AssemblerFileSelector;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Handler for generate PDF listing files when the command come from popup menus.
 * 
 * @author Patrick BRIAND
 *
 */
public class GenreateListingHandlerPopup implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof TextSelection) {
			IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	
			if ((part instanceof XtextEditor editor) && 
					(editor.getLanguageName().equals("org.bpy.electronics.mc6809.assembler.Assembler"))){
				IResource resource = editor.getResource();
				PdfAssemblyListing pdfAssemblyListing = new PdfAssemblyListing();
				pdfAssemblyListing.buildAssemblyFile((IFile)resource);
			}    
		} else if (selection instanceof TreeSelection treeSelection) {
		
			if (treeSelection.size() != 1) {
				AssemblerFileSelector fileSelector = new AssemblerFileSelector(Display.getCurrent().getActiveShell());
				fileSelector.initDialog(selection);
				fileSelector.open();
			} else {
				PdfAssemblyListing pdfAssemblyListing = new PdfAssemblyListing();
				pdfAssemblyListing.buildAssemblyFile((IFile)treeSelection.getFirstElement());
			}
		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Report generation", "Report is generated in the report folder");
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}
}
