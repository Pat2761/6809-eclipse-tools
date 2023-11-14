package org.bpy.electronics.mc6809.assembler.validation;

import org.eclipse.emf.ecore.EStructuralFeature;

public class AssemblerErrorDescription extends AssemblerProblemManagerDescription {
	
	public AssemblerErrorDescription(String message, EStructuralFeature feature, String issueCode) {
		this.setMessage(message);
		this.setFeature(feature);
		this.setIssueData(issueCode);
	}
}