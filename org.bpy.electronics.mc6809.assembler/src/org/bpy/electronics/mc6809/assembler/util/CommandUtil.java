package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;

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
	
	/**
	 * Return the label associated to an ORG directive.
	 * 
	 * @param equDirective reference on the ORG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OrgDirective orgDirective) {
		if ( orgDirective.getName() != null) {
			return orgDirective.getName().getValue();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the label associated to an END directive.
	 * 
	 * @param endDirective reference on the END directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(EndDirective endDirective) {
		if ( endDirective.getName() != null) {
			return endDirective.getName().getValue();
		} else {
			return null;
		}
	}
}
