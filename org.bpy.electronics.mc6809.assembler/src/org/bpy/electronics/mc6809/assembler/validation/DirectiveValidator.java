package org.bpy.electronics.mc6809.assembler.validation;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
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
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	public void checkUpperRange(EquDirective equDirective) {
		int equValue = ExpressionParser.parse(equDirective);
		if (equValue > 65535) {
			error("EQU value can't exceed 65535 (16 bits value)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * The 6809 is a 16 bits microprocessor, so value must be contains in 16 bits
	 * The limit of a negative value is -32768
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	public void checkLowerRange(EquDirective equDirective) {
		int equValue = ExpressionParser.parse(equDirective);
		if (equValue < -32768) {
			error("EQU value can't be lower than -32768 (16 bits value)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * An EQU directive must have a label
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	public void checkMissingLabel(EquDirective equDirective) {
		if (equDirective.getName() == null) {
			error("EQU directive must have a label)",
					AssemblerPackage.Literals.EQU_DIRECTIVE__NAME,
					MISSING_LABEL);
		}
	}

	@Check
	/**
	 * An ORG directive can't be negative
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	public void checkLabelPresence(OrgDirective orgDirective) {
		String label = CommandUtil.getLabel(orgDirective);
		if (label != null) {
			error("Label isn't not allow for ORG directive",
					AssemblerPackage.Literals.ORG_DIRECTIVE__NAME,
					UNEXPECTED_LABEL);
		}
	}

	@Check
	/**
	 * An ORG directive can't be negative
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	public void checkInvalidNegativeValue(OrgDirective orgDirective) {
		int equValue = ExpressionParser.parse(orgDirective);
		if (equValue < 0) {
			error("ORG value can't be negative",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * An ORG directive with a value > 0xFFFF
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	public void checkInvalidpositiveValue(OrgDirective orgDirective) {
		int equValue = ExpressionParser.parse(orgDirective);
		if (equValue > 0xFFFF) {
			error("ORG value maximum value is $FFFF",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}
}
