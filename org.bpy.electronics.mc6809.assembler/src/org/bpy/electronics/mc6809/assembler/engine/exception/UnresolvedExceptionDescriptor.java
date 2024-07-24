package org.bpy.electronics.mc6809.assembler.engine.exception;

import org.eclipse.emf.ecore.EReference;

public class UnresolvedExceptionDescriptor {
	private String message;
	private EReference reference;
	
	public UnresolvedExceptionDescriptor(String message, EReference reference)  {
		this.message = message;
		this.reference = reference;
	}

	public String getMessage() {
		return message;
	}

	public EReference getReference() {
		return reference;
	}

	
}
