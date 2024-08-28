package org.bpy.electronics.mc6809.rcp;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.rcp.builder.AssemblerProjectNature;
import org.bpy.electronics.mc6809.rcp.utils.AssemblerResourceVisitor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.ide.IDE;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	/** Logger of the class */
	public static final Logger logger = Logger.getLogger(ApplicationWorkbenchAdvisor.class.getSimpleName());

	private static final String PERSPECTIVE_ID = "org.bpy.electronics.mc6809.rcp.perspective";
	   
	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		configurer.setSaveAndRestore(true);
		IDE.registerAdapters();

		MessageConsole myConsole = new MessageConsole("Console", null); //$NON-NLS-1$

		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { myConsole });
		MessageConsoleStream stream = myConsole.newMessageStream();

		PrintStream myS = new PrintStream(stream);
		System.setOut(myS); // link standard output stream to the console
		System.setErr(myS); // link error output stream to the console
	}

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}
	
	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}

	@Override
	public IAdaptable getDefaultPageInput() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	@Override
	public void postStartup() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
		/* Activate the assembler Manager */
		AssemblerManager assemblerManager = AssemblerManager.getInstance();

		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.getNature(AssemblerProjectNature.NATURE_ID) != null) { //$NON-NLS-1$

					List<IFile> assemblyFiles = new ArrayList<>();
					project.accept(new AssemblerResourceVisitor(assemblyFiles));

					for (IFile assemblyFile : assemblyFiles) {
						assemblerManager.getAssemblyModel(assemblyFile);
					}
					
					project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		super.postStartup();
	}
}
