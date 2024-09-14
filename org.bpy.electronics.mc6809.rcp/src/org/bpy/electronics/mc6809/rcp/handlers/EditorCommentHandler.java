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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * Allow to comment / uncomment block of code
 * 
 * @author Patrick BRIAND
 *
 */
public class EditorCommentHandler implements IHandler {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(EditorCommentHandler.class.getSimpleName());
	
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

				TextSelection textSelection = (TextSelection) editor.getSelectionProvider().getSelection();
				int startLine = textSelection.getStartLine();
				int lastLine = textSelection.getEndLine();
				
				IDocumentProvider documentProvider = editor.getDocumentProvider();
				IDocument document = documentProvider.getDocument(editor.getEditorInput());
				
				try {
					for (int line = startLine; line <= lastLine; line++) {
						int offset = document.getLineOffset(line);
						if (Character.isWhitespace(document.getChar(offset)) || Character.isLetter(document.getChar(offset))) {
							document.replace(offset, 0, ";");
						} else if (document.getChar(offset) == ';') {
							document.replace(offset, 1, "");
						}
					}
				} catch (BadLocationException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			}
		}	
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
