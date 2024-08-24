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

import java.util.HashMap;
import java.util.Map;

import org.bpy.electronics.mc6809.assembler.assembler.Model;

/**
 * manager of assembly resources.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerManager {

	/** collection of assembly resources */
	private Map<Model, AssemblerEngine> engines;
	
	/** instance on the assembler manager */
	private static AssemblerManager instance;
	
	/**
	 * Constructor of the class
	 */
	private AssemblerManager() {
		engines = new HashMap<>();;
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
	 * 
	 * @param model reference on the model
	 * @param forceAssembly <b>true</b> force assembly, <b>false</b> otherwise
	 * 
	 * @return reference on the assembly result
	 */
	public AssemblerEngine getAssemblyModel(Model model, boolean forceAssembly) {
		AssemblerEngine assemblerEngine = null; 
		if (engines.containsKey(model)) {
			 assemblerEngine = engines.get(model);
		} else {
			assemblerEngine = new AssemblerEngine();
			assemblerEngine.engine(model);
			engines.put(model, assemblerEngine);
			return assemblerEngine;
		}
		
		if (forceAssembly) {
			assemblerEngine.engine(model);
		}
		return assemblerEngine;
	}
}
