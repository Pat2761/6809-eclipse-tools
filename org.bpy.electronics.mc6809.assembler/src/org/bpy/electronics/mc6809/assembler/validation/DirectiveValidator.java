package org.bpy.electronics.mc6809.assembler.validation;

import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.xtext.validation.Check;

public class DirectiveValidator  extends AbstractAssemblerValidator {

	public static final String INVALID_RANGE = "invalidRange";
	public static final String MISSING_LABEL = "missingLabel";
	public static final String UNEXPECTED_LABEL = "unexpectedLabel";

	@Check
	/**
	 * The 6809 is a 16 bits microprocessor, so value must be contains in 16 bits
	 * The Limit of a positive value is  65535
	 * The limit of a negative value is -32768
	 * An EQU directive must have a label
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	public void checkEquConstraints(EquDirective equDirective) {
		if (equDirective.getName() == null) {
			error("EQU directive must have a label)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__NAME,
					MISSING_LABEL);
		}

		int equValue = ExpressionParser.parse(equDirective);
		if (equValue > 65535) {
			error("EQU value can't exceed 65535 (16 bits value)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else 	if (equValue < -32768) {
			error("EQU value can't be lower than -32768 (16 bits value)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} 
	}

	@Check
	/**
	 * Check the ORG directive limits (0-FFFF)
	 * ORG can't have a label
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	public void checkOrgConstraints(OrgDirective orgDirective) {
		String label = CommandUtil.getLabel(orgDirective);
		if (label != null) {
			error("Label isn't not allow for ORG directive",
					AssemblerPackage.Literals.ORG_DIRECTIVE__NAME,
					UNEXPECTED_LABEL);
		}

		int orgValue = ExpressionParser.parse(orgDirective);
		if (orgValue > 0xFFFF) {
			error("ORG value maximum value is $FFFF",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (orgValue < 0) {
			error("ORG value can't be negative",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * An END directive can't have a label
	 * Check the END directive limits (0-FFFF)
	 * 
	 * @param endDirective reference on the END directive
	 */
	public void checkEndConstraints(EndDirective endDirective) {
		
		String label = CommandUtil.getLabel(endDirective);
		if (label != null) {
			error("Label isn't not allow for END directive",
					AssemblerPackage.Literals.END_DIRECTIVE__NAME,
					UNEXPECTED_LABEL);
		}

		int equValue = ExpressionParser.parse(endDirective);
		if (equValue > 0xFFFF) {
			error("END value maximum value is $FFFF",
					AssemblerPackage.Literals.END_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (equValue < 0) {
			error("END value can't be negative",
					AssemblerPackage.Literals.END_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * Check the RMB directive limits (1-FFFF)
	 * 
	 * @param rmbDirective reference on the RMB directive
	 */
	public void checkRmdConstraints(RmbDirective rmbDirective) {
		
		int rmbValue = ExpressionParser.parse(rmbDirective);
		if (rmbValue > 0xFFFF) {
			error("RMB value maximum value is $FFFF",
					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (rmbValue < 1) {
			error("RMB value can't lower than 1",
					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * Check the FCB constraints
	 * Values must be defined in the range [-127..255]
	 * 
	 * @param fcbDirective reference on the FCB directive
	 */
	public void checkFcbConstraints(FcbDirective fcbDirective) {
		
		List<Integer> rmbValues = ExpressionParser.parse(fcbDirective);
		int location = 1;
		for (Integer rmbValue : rmbValues) {
			if (rmbValue > 255) {
				error("FCB value maximum value is $FF at location " + location ,
						AssemblerPackage.Literals.FCB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			} else if (rmbValue < -127) {
				error("FCB value can't lower than -127 at location " + location,
						AssemblerPackage.Literals.FCB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			}
			location++;
		}
	}

	@Check
	/**
	 * Check the FDB constraints
	 * Values must be defined in the range [-32768..65535]
	 * 
	 * @param fdbDirective reference on the FDB directive
	 */
	public void checkFdbConstraints(FdbDirective fdbDirective) {
		
		List<Integer> rmbValues = ExpressionParser.parse(fdbDirective);
		int location = 1;
		for (Integer rmbValue : rmbValues) {
			if (rmbValue > 65535) {
				error("FDB value maximum value is 65535 at location " + location ,
						AssemblerPackage.Literals.FDB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			} else if (rmbValue < -32768) {
				error("FDB value can't lower than -32768 at location " + location,
						AssemblerPackage.Literals.FDB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			}
			location++;
		}
	}
}
