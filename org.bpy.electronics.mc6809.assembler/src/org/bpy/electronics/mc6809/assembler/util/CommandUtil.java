package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;

public class CommandUtil {

	/**
	 * Return the label associated to an EQU directive.
	 * 
	 * @param equDirective reference on the EQU directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(EquDirective equDirective) {
		if ( equDirective.getName() != null) {
			return equDirective.getName().getValue();
		} else {
			return null;
		}
	}
	
}
