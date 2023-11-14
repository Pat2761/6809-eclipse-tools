package org.bpy.electronics.mc6809.assembler.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssemblerErrorManager {

	public static final String VALIDATION_ERROR = "validationError";
	public static AssemblerErrorManager eInstance;

	public Map<Object, List<AssemblerProblemManagerDescription>> problems;
	
	public AssemblerErrorManager() {
		problems = new HashMap<>();
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
		}
		descriptions.add(description);
	}
	
	public List<AssemblerProblemManagerDescription> getProblems(Object object) {
		return problems.get(object);
	}
}
