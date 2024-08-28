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
package org.bpy.electronics.mc6809.rcp.utils;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * Class for visit a resource and get the list of assembly files.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerResourceVisitor implements IResourceVisitor {

	/** List of assembly files */
	List<IFile> assemblyFiles;
	
	/**
	 * Constructor of the class.
	 * @param assemblyFiles2 
	 */
	public AssemblerResourceVisitor(List<IFile> assemblyFiles) {
		this.assemblyFiles = assemblyFiles;
	}
	
	@Override
	public boolean visit(IResource resource) throws CoreException {
		if ((resource instanceof IFile resourceFile) && (resourceFile.getName().toLowerCase().endsWith(".as9"))) {
			assemblyFiles.add(resourceFile);
		}
		return true;
	}
}
