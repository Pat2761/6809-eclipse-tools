/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.util;

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.eclipse.emf.common.util.EList;

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
	 * Return the comment associated to an EQU directive.
	 * 
	 * @param equDirective reference on the EQU directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(EquDirective equDirective) {
		DirectiveLine directiveLine = (DirectiveLine)equDirective.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an SET directive.
	 * 
	 * @param setDirective reference on the SET directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SetDirective setDirective) {
		DirectiveLine directiveLine = (DirectiveLine)setDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an SET directive.
	 * 
	 * @param setDirective reference on the SET directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SetDirective setDirective) {
		DirectiveLine directiveLine = (DirectiveLine)setDirective.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
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
	 * Return the label associated to an BSZ directive.
	 * 
	 * @param directive reference on the BSZ directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(BszDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an BSZ directive.
	 * 
	 * @param directive reference on the BSZ directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(BszDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
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

	public static int getByteToSet(FillDirective fillDirective) {
		Expression value = fillDirective.getValue();
		return ExpressionParser.resolveExpression(value);
	}

	public static int getQuantity(FillDirective fillDirective) {
		Expression value = fillDirective.getNumber();
		return ExpressionParser.resolveExpression(value);
	}

	/*
	 * Get name defined by a NAM directive
	 */
	public static String getName(NamDirective namDirective) {
		return namDirective.getOperand().getValue();
	}

	/**
	 * Get the list of registers in a REG directive
	 * 
	 * @param regDirective reference on the REG Directive
	 * @return List of registers name
	 */
	public static List<String> getRegisters(RegDirective regDirective) {
		List<String> registers = new ArrayList<>();
		EList<Register> options = regDirective.getOptions();
		for (Register option : options) {
			registers.add(option.getLiteral());
		}
		return registers;
	}

}
