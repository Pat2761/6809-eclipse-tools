package org.bpy.electronics.mc6809.rcp.builder;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.XtextProjectHelper;

public class AssemblerProjectBuilder /* implements IAssemblerProjectBuilder */{

	private static final Logger logger = Logger.getLogger(AssemblerProjectBuilder.class.getSimpleName());

	/** Reference on the project */
	private IProject project;

	public AssemblerProjectBuilder(IProject project) {
		this.project= project;
	}
	
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
			
			createBinFolder(project);
			if (optionalFileName != null) {
				createAssemblyFile(project, optionalFileName);
			}	
			
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	private void createBinFolder(IProject project2) {
//		project.// TODO Auto-generated method stub
	}

	private void createAssemblyFile(IProject project2, String optionalFileName) {
		// TODO Auto-generated method stub
		
	}
}
