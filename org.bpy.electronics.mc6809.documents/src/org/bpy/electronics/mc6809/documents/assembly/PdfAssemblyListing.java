package org.bpy.electronics.mc6809.documents.assembly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfAssemblyListing {

	/** Injector on the Game parser */
	private static final Injector injector = AssemblerActivator.getInstance().getInjector("org.bpy.electronics.mc6809.assembler.Assembler"); //$NON-NLS-1$

	public PdfAssemblyListing() {

	}

	public void buildAssemblyFile(IFile fileToDo) {
		IFolder folder = getOrCreateDocumentFolder(fileToDo);
		File pdfFile = new File(folder.getLocation().toOSString() + "/" + fileToDo.getName() + ".pdf");

		XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(fileToDo.getProject());
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(URI.createURI(fileToDo.getLocationURI().toString()), true);
		Model model = (Model) resource.getContents().get(0);

		ListingPdfBuilder documentBuilder = new ListingPdfBuilder();
		documentBuilder.build(pdfFile, model);
	}

	private IFolder getOrCreateDocumentFolder(IFile fileToDo) {
		IProject project = fileToDo.getProject();
		IFolder folder = project.getFolder("documents");
		if (!folder.exists()) {
			try {
				folder.create(true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return folder;
	}
}
