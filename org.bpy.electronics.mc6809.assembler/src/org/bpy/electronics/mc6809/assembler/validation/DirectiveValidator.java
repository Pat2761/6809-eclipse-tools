package org.bpy.electronics.mc6809.assembler.validation;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.xtext.validation.Check;

public class DirectiveValidator  extends AbstractAssemblerValidator {

	public static final String INVALID_RANGE = "invalidRange";
	public static final String MISSING_LABEL = "missingLabel";

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

}
