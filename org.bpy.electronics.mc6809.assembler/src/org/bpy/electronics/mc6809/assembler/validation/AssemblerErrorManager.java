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
package org.bpy.electronics.mc6809.assembler.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssemblerErrorManager {

	public static final String VALIDATION_ERROR = "validationError";
	private static AssemblerErrorManager eInstance;

	private Map<Object, List<AssemblerProblemManagerDescription>> problems;
	private Map<Object, List<AssemblerProblemManagerDescription>> warnings;
	
	public AssemblerErrorManager() {
		problems = new HashMap<>();
		warnings = new HashMap<>();
	}
	
	public static AssemblerErrorManager getInstance() {
		if (eInstance == null) {
			eInstance = new AssemblerErrorManager();
		}
		return eInstance;
	}
	
	public void clear() {
		problems.clear();
	}
	
	public void addProblem(Object object, AssemblerProblemManagerDescription description) {
		List<AssemblerProblemManagerDescription> descriptions = null;
		if (problems.containsKey(object)) {
			descriptions = problems.get(object);
		} else {
			descriptions = new ArrayList<>();
			problems.put(object, descriptions);
		}
		descriptions.add(description);
	}
	
	public void addWarning(Object object, AssemblerProblemManagerDescription description) {
		List<AssemblerProblemManagerDescription> descriptions = null;
		if (warnings.containsKey(object)) {
			descriptions = warnings.get(object);
		} else {
			descriptions = new ArrayList<>();
			warnings.put(object, descriptions);
		}
		descriptions.add(description);
	}
	
	public List<AssemblerProblemManagerDescription> getProblems(Object object) {
		if (problems.containsKey(object)) {
			return problems.get(object);
		} else {
			return new ArrayList<AssemblerProblemManagerDescription>();
		}
	}
	
	public List<AssemblerProblemManagerDescription> getWarnings(Object object) {
		if (warnings.containsKey(object)) {
			return warnings.get(object);
		} else {
			return new ArrayList<AssemblerProblemManagerDescription>();
		}
	}
}
