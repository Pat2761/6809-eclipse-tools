package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;

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
	 * Return the label associated to an RMB directive.
	 * 
	 * @param rmbDirective reference on the RMB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RmbDirective rmbDirective) {
		if ( rmbDirective.getName() != null) {
			return rmbDirective.getName().getValue();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the label associated to an FCB directive.
	 * 
	 * @param fcbDirective reference on the FCB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FcbDirective fcbDirective) {
		if ( fcbDirective.getName() != null) {
			return fcbDirective.getName().getValue();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the label associated to an FDB directive.
	 * 
	 * @param fdbDirective reference on the FDB directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FdbDirective fdbDirective) {
		if ( fdbDirective.getName() != null) {
			return fdbDirective.getName().getValue();
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
