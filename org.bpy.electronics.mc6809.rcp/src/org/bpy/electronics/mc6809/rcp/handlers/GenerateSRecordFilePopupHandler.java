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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.binaries.SRECDataFormatter;
import org.bpy.electronics.mc6809.rcp.Activator;
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
 * Handler for the SRecord file generation (Command from popup menu). 
 * 
 * @author Patrick BRIAND
 *
 */
public class GenerateSRecordFilePopupHandler implements IHandler {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(GenerateSRecordFilePopupHandler.class.getSimpleName());

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do here
	}

	@Override
	public void dispose() {
		// Nothing to do here
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof TextSelection) {
			IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	
			if ((part instanceof XtextEditor editor) && 
					(editor.getLanguageName().equals("org.bpy.electronics.mc6809.assembler.Assembler"))){
				IResource resource = editor.getResource();
				createSREcFile((IFile) resource);
				
			}    
		} else if (selection instanceof TreeSelection treeSelection) {
		
			if (treeSelection.size() != 1) {
				AssemblerFileSelector fileSelector = new AssemblerFileSelector(Display.getCurrent().getActiveShell());
				fileSelector.initDialog(selection);
				fileSelector.open();
				
				if (!fileSelector.getSelectedFiles().isEmpty()) {
					for (IFile selectedFile : fileSelector.getSelectedFiles()) {
						createSREcFile((IFile) selectedFile);
					}
				}
			} else {
				createSREcFile((IFile) treeSelection.getFirstElement());
			}
		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Binary file generation", "Binary file is generated in the bin folder");
		return null;
	}

	/**
	 * Generate a SRECORD file.
	 * 
	 * @param resource reference on the assembly file
	 */
	private void createSREcFile(IFile resource) {
		SRECDataFormatter dataFormatter = new SRECDataFormatter();
		dataFormatter.initiateSRECData(Activator.TOOL_NAME + ": Version=" + Activator.VERSION);
		try {
			dataFormatter.fillData((IFile)resource);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
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
		// Nothing to do here
	}

}
