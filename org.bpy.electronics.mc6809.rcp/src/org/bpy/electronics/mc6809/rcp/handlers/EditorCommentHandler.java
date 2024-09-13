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

public class EditorCommentHandler implements IHandler {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(EditorCommentHandler.class.getSimpleName());
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

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
				System.out.println(("BPY: Startline=" + startLine + "  End line = " + lastLine));
			}
		}	
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
