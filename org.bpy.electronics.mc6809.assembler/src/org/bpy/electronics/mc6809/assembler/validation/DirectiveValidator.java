package org.bpy.electronics.mc6809.assembler.validation;

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

public class DirectiveValidator  extends AbstractAssemblerValidator {

	public static final String INVALID_RANGE = "invalidRange";
	public static final String MISSING_LABEL = "missingLabel";
	public static final String UNEXPECTED_LABEL = "unexpectedLabel";
	public static final String DUPLICATE_OPTION = "duplicateOption";
	public static final String MISSING_OPTION = "missingOption";
	public static final String NAME_ERROR = "nameError";
	
	@Override
	public void register(EValidatorRegistrar registrar) {
	}

	/**
	 * Check labels on the directive line
	 * 
	 * @param directiveLine reference on the directive line
	 */
	@Check
	public void checkDirectiveLine(DirectiveLine directiveLine) {
		if ((directiveLine.getDirective() instanceof BszDirective) && (directiveLine.getName() == null)) {
			warning("No label defined for BSZ directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
				MISSING_LABEL);
		} else if ((directiveLine.getDirective() instanceof EquDirective) && (directiveLine.getName() == null)) {
			error("No label defined for EQU directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
				MISSING_LABEL);
		} else if ((directiveLine.getDirective() instanceof SetDirective) && (directiveLine.getName() == null)) {
			error("No label defined for SET directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
				MISSING_LABEL);
		} else if ((directiveLine.getDirective() instanceof EndDirective) && (directiveLine.getName() != null)) {		
   			error("No label may be set for END directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
   				UNEXPECTED_LABEL);
		} else if ((directiveLine.getDirective() instanceof SpcDirective) && (directiveLine.getName() != null)) {		
   			error("No label may be set for SPC directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
   				UNEXPECTED_LABEL);
		} else if ((directiveLine.getDirective() instanceof PagDirective) && (directiveLine.getName() != null)) {		
   			error("No label may be set for PAG directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
   				UNEXPECTED_LABEL);
		} else if ((directiveLine.getDirective() instanceof RegDirective) && (directiveLine.getName() == null)) {
			error("No label defined for REG directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
				MISSING_LABEL);
		}	
	}
	
	/**                                  				                                                                                        
	 * The 6809 is a 16 bits microprocessor, so value must be contains in 16 bits		                                                                                                       
	 * The Limit of a positive value is  65535
	 * The limit of a negative value is -32768
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	@Check
	public void checkEquConstraints(EquDirective equDirective) {
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
	
	/**
	 * Check the ORG directive limits (0-FFFF)
	 * ORG can't have a label
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	@Check
	public void checkOrgConstraints(OrgDirective orgDirective) {
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
	
	/**
	 * Check the FILL directive limits
	 * First operand must be [0-255]
	 * Second operand must be [1-65535]
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	@Check
	public void checkFillConstraints(FillDirective fillDirective) {
		int valueToSet = CommandUtil.getByteToSet(fillDirective);
		int quantity = CommandUtil.getQuantity(fillDirective);
		if (valueToSet > 255) {
			error("FILL value maximum value is $FF",
					AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE,
					INVALID_RANGE);
		} else if (valueToSet < 0) {
			error("FILL value minimum value is $00",
					AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE,
					INVALID_RANGE);
		} 		
			
		if (quantity < 0) {
			error("FILL value can't be negative",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		} else if (quantity == 0) {
			error("FILL value can't be null",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		} else if (quantity > 65535) {
			error("FILL value maximum value is $FFFF",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		}
	}

	/**
	 * Check Opt directive constraints.
	 * check duplicate options
	 * 
	 * @param optDirective reference on the OPT directive
	 */
	@Check
	public void checkOptConstraints(OptDirective optDirective) {
		List<String> options = new ArrayList<>();
		for (AssemblyOption option : optDirective.getOptions()) {
			if (options.contains(option.getLiteral())) {
				error("Duplicate option " + option.getLiteral(),
						AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
						DUPLICATE_OPTION);
			} else { 
				options.add(option.getLiteral());
			}
		}
	}

	/**
	 * Check PAG directive constraints.
	 * operand can't be negative
	 * operand = 0 is ambiguous
	 * operand > 10 is suspicious
	 * 
	 * @param pagDirective reference on the PAG directive
	 */
	@Check
	public void checkPagConstraints(PagDirective pagDirective) {
		int pagValue = ExpressionParser.parse(pagDirective);
		if (pagValue < 0) {
			error("PAG value can't be negative",
					AssemblerPackage.Literals.PAG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (pagValue == 0) {
			warning("Null page value is suspicious",
					AssemblerPackage.Literals.PAG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (pagValue > 9) {
			warning("PAG value superior to 9 is suspicious",
					AssemblerPackage.Literals.PAG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
	}

	/**
	 * Check NAM directive constraints.
	 * NAM operand shall contains at least on character
	 * 
	 * @param namDirective reference on the NAM directive
	 */
	@Check
	public void checkNamConstraints(NamDirective namDirective) {
		String namValue = CommandUtil.getName(namDirective);
		if (namValue.length() > 6) {
			warning("Program name must be defined by 6 characters max",
					AssemblerPackage.Literals.NAM_DIRECTIVE__OPERAND,
					NAME_ERROR);
		}	
	}

	/**
	 * Check the BSZ directive constraints
	 * can't be negative
	 * Doubt if equals to 0
	 * 
	 * @param bszDirective reference on the BSZ directive
	 */
	@Check
	public void checkBszConstraints(BszDirective bszDirective) {
		int bszValue = ExpressionParser.parse(bszDirective);
	    if (bszValue < 0) {
			error("BSZ value can't be negative",
					AssemblerPackage.Literals.BSZ_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (bszValue == 0) {
			warning("Reserving no bytes makes no sense",
					AssemblerPackage.Literals.BSZ_DIRECTIVE__OPERAND,
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
	
	/**   
	 * Check SET constraints
	 *                                				                                                                                        
	 * The 6809 is a 16 bits microprocessor, so value must be contains in 16 bits		                                                                                                       
	 * The Limit of a positive value is  65535
	 * The limit of a negative value is -32768
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	@Check
	public void checkSetConstraints(SetDirective setDirective) {
		int setValue = ExpressionParser.parse(setDirective);
		if (setValue > 65535) {
			error("SET value can't exceed 65535 (16 bits value)",
					AssemblerPackage.Literals.SET_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else 	if (setValue < -32768) {
			error("SET value can't be lower than -32768 (16 bits value)",
					AssemblerPackage.Literals.SET_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} 
	}
	
	/**   
	 * Check SPC constraints
	 *   can't be negative                                				                                                                                        
	 *   can't be zero
	 *   Suspicious if over 9
	 *   
	 * @param spcDirective reference on the SPC directive
	 */
	@Check
	public void checkSpcConstraints(SpcDirective spcDirective) {
		int spcValue = ExpressionParser.getSpaceCount(spcDirective);
		if (spcValue < 0) {
			error("SPC space value can't be negative",
					AssemblerPackage.Literals.SPC_DIRECTIVE__SPACE_COUNT,
					INVALID_RANGE);
		} else if (spcValue == 0) {
			warning("0 Space count value is suspicious",
					AssemblerPackage.Literals.SPC_DIRECTIVE__SPACE_COUNT,
					INVALID_RANGE);
		} else if (spcValue > 9) {
			warning("SPC value superior to 9 is suspicious",
					AssemblerPackage.Literals.SPC_DIRECTIVE__SPACE_COUNT,
					INVALID_RANGE);
		}
		
		int keepCount = ExpressionParser.getKeepCount(spcDirective);
		if (keepCount < 0) {
			error("SPC keep count value can't be negative",
					AssemblerPackage.Literals.SPC_DIRECTIVE__KEEP_COUNT,
					INVALID_RANGE);
		} else if (keepCount == 0) {
			warning("0 keep count value is suspicious",
					AssemblerPackage.Literals.SPC_DIRECTIVE__KEEP_COUNT,
					INVALID_RANGE);
		} else if (keepCount > 9) {
			warning("SPC keep count value superior to 9 is suspicious",
					AssemblerPackage.Literals.SPC_DIRECTIVE__KEEP_COUNT,
					INVALID_RANGE);
		}
	}

	@Check
	/**
	 * Check the REG directive (avoid duplicate register)
	 * 
	 * @param regDirective reference on the REG directive
	 */
	public void checkRegConstraints(RegDirective regDirective) {
		List<String> regs = CommandUtil.getRegisters(regDirective);
		List<String> testReg = new ArrayList<>();
		if (regs.isEmpty()) {
			error("no register defined in the REG Directive",
					AssemblerPackage.Literals.REG_DIRECTIVE__OPTIONS,
					MISSING_OPTION);
			
		} else {
			for (String reg : regs) {
				if (testReg.contains(reg)) {
					error("Register " + reg + " is duplicate in the REG Directive",
							AssemblerPackage.Literals.REG_DIRECTIVE__OPTIONS,
							DUPLICATE_OPTION);
					break;
				} else {
					testReg.add(reg);
				}
	 		}
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
	@Check
	/**
	 * Check the RMB directive limits (1-FFFF)
	 * 
	 * @param rmbDirective reference on the RMB directive
	 */
	public void checkRmdConstraints(RmbDirective rmbDirective) {
		
//		int rmbValue = ExpressionParser.parse(rmbDirective);
//		if (rmbValue > 0xFFFF) {
//			error("RMB value maximum value is $FFFF",
//					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
//					INVALID_RANGE);
//		} else if (rmbValue < 1) {
//			error("RMB value can't lower than 1",
//					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
//					INVALID_RANGE);
//		}
	}
}
