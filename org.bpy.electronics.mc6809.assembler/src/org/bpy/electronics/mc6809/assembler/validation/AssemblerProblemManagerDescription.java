package org.bpy.electronics.mc6809.assembler.validation;

import org.eclipse.emf.ecore.EStructuralFeature;

class AssemblerProblemManagerDescription {
	private String message;
	private EStructuralFeature feature;
	private String issueData;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EStructuralFeature getFeature() {
		return feature;
	}
	public void setFeature(EStructuralFeature feature) {
		this.feature = feature;
	}
	public String getIssueData() {
		return issueData;
	}
	public void setIssueData(String issueData) {
		this.issueData = issueData;
	}
}