package org.bpy.electronics.mc6809.binaries.exceptions;

public class BadSRECFileFormat extends Exception {

	/** Serial UID version */
	private static final long serialVersionUID = 561120899028871104L;

	public BadSRECFileFormat(String message) {
		super(message);
	}
}
