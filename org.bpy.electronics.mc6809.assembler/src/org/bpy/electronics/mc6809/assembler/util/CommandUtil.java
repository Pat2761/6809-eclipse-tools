package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
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
		DirectiveLine directiveLine = (DirectiveLine)equDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the label associated to an ORG directive.
	 * 
	 * @param orgDirective reference on the ORG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OrgDirective orgDirective) {
		DirectiveLine directiveLine = (DirectiveLine)orgDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an ORG directive.
	 * 
	 * @param orgDirective reference on the ORG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OrgDirective orgDirective) {
		DirectiveLine directiveLine = (DirectiveLine)orgDirective.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
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
		DirectiveLine directiveLine = (DirectiveLine)rmbDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
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
		DirectiveLine directiveLine = (DirectiveLine)fcbDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
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
		DirectiveLine directiveLine = (DirectiveLine)fdbDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
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
		DirectiveLine directiveLine = (DirectiveLine)endDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}
}
