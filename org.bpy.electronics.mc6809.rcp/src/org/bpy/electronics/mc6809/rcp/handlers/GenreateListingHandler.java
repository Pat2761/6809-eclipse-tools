package org.bpy.electronics.mc6809.rcp.handlers;

import org.bpy.electronics.mc6809.assembler.ui.AssemblerUiModule;
import org.bpy.electronics.mc6809.documents.assembly.PdfAssemblyListing;
import org.bpy.electronics.mc6809.rcp.dialogs.AssemblerFileSelector;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

public class GenreateListingHandler implements IHandler {

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
		if (selection instanceof TextSelection textSelection) {
			IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	
			if ((part instanceof XtextEditor editor) && 
					(editor.getLanguageName().equals("org.bpy.electronics.mc6809.assembler.Assembler"))){
				IResource resource = editor.getResource();
				PdfAssemblyListing pdfAssemblyListing = new PdfAssemblyListing();
				pdfAssemblyListing.buildAssemblyFile((File)resource);
				
				IDocumentProvider documentProvider = editor.getDocumentProvider();
				IXtextDocument document = editor.getDocument();
				
			    System.out.println("done");
		}    
			
		} else  {
		
		AssemblerFileSelector fileSelector = new AssemblerFileSelector(Display.getCurrent().getActiveShell());
		fileSelector.initDialog(selection);
		fileSelector.open();
		}
		/* TextSelection, TreeSelection */
//		
//		if (selection instanceof TreeSelection treeSelection) {
			// Element selected, so create reports for this element 
//			System.out.println(treeSelection.getFirstElement().getClass().getName());
			
//		} else {
			// Call dialog for select an element
			
//			System.out.println(selection.getClass().getName());
//		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
				"Report generation",
				"Report is generated in the report folder");

		
		
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
