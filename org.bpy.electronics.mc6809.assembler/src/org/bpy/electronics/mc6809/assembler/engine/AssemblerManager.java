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
package org.bpy.electronics.mc6809.assembler.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.ui.util.ResourceUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * manager of assembly resources.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerManager {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerManager.class.getSimpleName());

	public static final String STUB_FILE_NAME = "junit.as9";

	/**
	 * collection of assembly resources key: Full path of the file, Content:
	 * Reference on the assembler engine
	 */
	private Map<String, AssemblerEngine> engines;

	/** instance on the assembler manager */
	private static AssemblerManager instance;

	@Inject
	private IParser parser;

	/**
	 * Constructor of the class
	 */
	private AssemblerManager() {
		Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);

		engines = new HashMap<>();
	}

	/**
	 * get the Assembler engine associated to a file.
	 * 
	 * @param fileName full path of the file
	 * @return reference on the assembler engine, <b>null</b> if not found
	 */
	public AssemblerEngine getRegistredAssemblyEngine(String fileName) {
		if (engines.containsKey(fileName)) {
			return engines.get(fileName);
		}
		return null;
	}

	/**
	 * Get the instance on the assembler manager.
	 * 
	 * @return instance on the assembler manager.
	 */
	public static AssemblerManager getInstance() {
		if (instance == null) {
			instance = new AssemblerManager();
		}
		return instance;
	}

	/**
	 * Find the assembly model corresponding to a File
	 * 
	 * @param assemblyFile Reference on the file
	 * @return reference on the model, <b>null</b> otherwise
	 */
	public AssemblerEngine getAssemblyModel(IFile assemblyFile) {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(assemblyFile.getLocation().toOSString())));
			IParseResult parsingResult = parser.parse(reader);
			AssemblerEngine engine = new AssemblerEngine();
			Model model = (Model) parsingResult.getRootNode().getSemanticElement();
			engine.engine(model);
			engines.put(assemblyFile.getFullPath().toOSString(), engine);

			return engine;
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param model         reference on the model
	 * @param forceAssembly <b>true</b> force assembly, <b>false</b> otherwise
	 * 
	 * @return reference on the assembly result
	 */
	public AssemblerEngine getAssemblyModel(Model model) {
		AssemblerEngine assemblerEngine = null;
		String fileName = STUB_FILE_NAME;
		if ((model.eResource().getURI().scheme() != null) && (!model.eResource().getURI().toString().contains(STUB_FILE_NAME))) {
			IFile file = ResourceUtil.getFile(model.eResource());
			if (file != null) {
				fileName = file.getFullPath().toOSString();
			}
		}

		if (engines.containsKey(fileName)) {
			return engines.get(fileName);
		} else {
			assemblerEngine = new AssemblerEngine();
			assemblerEngine.engine(model);

			engines.put(fileName, assemblerEngine);
			return assemblerEngine;
		}
	}

	/**
	 * 
	 * @param model         reference on the model
	 * @param forceAssembly <b>true</b> force assembly, <b>false</b> otherwise
	 * 
	 * @return reference on the assembly result
	 */
	public AssemblerEngine getAssemblyModel(Model model, String fileName) {
		AssemblerEngine assemblerEngine = null;

		if (engines.containsKey(fileName)) {
			return engines.get(fileName);
		} else {
			assemblerEngine = new AssemblerEngine();
			assemblerEngine.engine(model);

			engines.put(fileName, assemblerEngine);
			return assemblerEngine;
		}
	}

	/**
	 * 
	 * @param model         reference on the model
	 * @param forceAssembly <b>true</b> force assembly, <b>false</b> otherwise
	 * 
	 * @return reference on the assembly result
	 */
	public AssemblerEngine getAssemblyModel(Model model, boolean forceAssembly) {
		String fileName = STUB_FILE_NAME;
		if ((model.eResource().getURI().scheme() != null) && (!model.eResource().getURI().toString().contains(STUB_FILE_NAME))) {
			// normal mode
			IFile file = ResourceUtil.getFile(model.eResource());
			fileName = file.getFullPath().toOSString();
		}
		if (forceAssembly && engines.containsKey(fileName)) {
			engines.remove(fileName);
		}
		return getAssemblyModel(model);
	}
}
