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
		return problems.get(object);
	}
	
	public List<AssemblerProblemManagerDescription> getWarnings(Object object) {
		return warnings.get(object);
	}
}
