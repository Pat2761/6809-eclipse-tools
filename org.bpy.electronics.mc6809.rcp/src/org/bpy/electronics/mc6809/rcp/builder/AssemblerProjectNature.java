package org.bpy.electronics.mc6809.rcp.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class AssemblerProjectNature implements IProjectNature {

	/** Reference on the project */
	private IProject project;

	/** Nature ID */
	public static final String NATURE_ID = "org.bpy.electronics.mc6809.assemblerNature"; //$NON-NLS-1$

	@Override
	public void configure() throws CoreException {
		// nothing to do here
	}

	@Override
	public void deconfigure() throws CoreException {
		// nothing to do here
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}
}
