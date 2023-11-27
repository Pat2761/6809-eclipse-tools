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
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.eclipse.emf.common.util.EList;

/**
 * Utility class for get informations about instructions or directives
 * 
 * @author Patrick
 *
 */
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
	 * Return the comment associated to an RMB directive.
	 * 
	 * @param rmbDirective reference on the RMB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RmbDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
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
	 * Return the comment associated to an FCB directive.
	 * 
	 * @param directive reference on the FCB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FcbDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
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
	 * Return the comment associated to an FDB directive.
	 * 
	 * @param directive reference on the FDB directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FdbDirective fdbDirective) {
		DirectiveLine directiveLine = (DirectiveLine)fdbDirective.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}
	
	/**
	 * Return the label associated to an FCC directive.
	 * 
	 * @param fccDirective reference on the FCC directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FccDirective fccDirective) {
		DirectiveLine directiveLine = (DirectiveLine)fccDirective.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an FCC directive.
	 * 
	 * @param fccDirective reference on the FCC directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FccDirective fccDirective) {
		DirectiveLine directiveLine = (DirectiveLine)fccDirective.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
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

	/**
	 * Return the comment associated to an END directive.
	 * 
	 * @param endDirective reference on the END directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(EndDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an FILL directive.
	 * 
	 * @param directive reference on the FILL directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(FillDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an FILL directive.
	 * 
	 * @param directive reference on the FILL directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(FillDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an OPT directive.
	 * 
	 * @param directive reference on the OPT directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(OptDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an OPT directive.
	 * 
	 * @param directive reference on the OPT directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(OptDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an PAG directive.
	 * 
	 * @param directive reference on the PAG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(PagDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an PAG directive.
	 * 
	 * @param directive reference on the PAG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(PagDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an NAM directive.
	 * 
	 * @param directive reference on the NAM directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(NamDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an NAM directive.
	 * 
	 * @param directive reference on the NAM directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(NamDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an SPC directive.
	 * 
	 * @param directive reference on the SPC directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(SpcDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an SPC directive.
	 * 
	 * @param directive reference on the SPC directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(SpcDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	/**
	 * Return the label associated to an REG directive.
	 * 
	 * @param directive reference on the REG directive
	 * @return value of the label, <b>null</b> if not found
	 */
	public static String getLabel(RegDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getName() != null) {
			return directiveLine.getName().getValue();
		} else {
			return null;
		}
	}

	/**
	 * Return the comment associated to an REG directive.
	 * 
	 * @param directive reference on the REG directive
	 * @return value of the comment, <b>null</b> if not found
	 */
	public static String getComment(RegDirective directive) {
		DirectiveLine directiveLine = (DirectiveLine)directive.eContainer();
		if ( directiveLine.getComment() != null) {
			return directiveLine.getComment();
		} else {
			return null;
		}
	}

	
	public static int getByteToSet(FillDirective fillDirective) {
		Expression value = fillDirective.getValue().getOperand();
		return ExpressionParser.resolveExpression(value);
	}

	public static int getQuantity(FillDirective fillDirective) {
		Expression value = fillDirective.getNumber().getOperand();
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
