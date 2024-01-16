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
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFcbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFdbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledPagDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSetDPDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSpcDirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

public class DirectiveValidator extends AbstractAssemblerValidator {

	public static final String INVALID_RANGE = "invalidRange";
	public static final String MISSING_LABEL = "missingLabel";
	public static final String UNEXPECTED_LABEL = "unexpectedLabel";
	public static final String DUPLICATE_OPTION = "duplicateOption";
	public static final String MISSING_OPTION = "missingOption";
	public static final String NAME_ERROR = "nameError";
	public static final String INCONSISTENCY_ERROR = "inconsistencyError";
	
	
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
		if ((directiveLine.getDirective() instanceof BszDirective) && (CommandUtil.getLabel(directiveLine) == null)) {
			warning("No label defined for BSZ directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
				MISSING_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof EquDirective) && (CommandUtil.getLabel(directiveLine) == null)) {
			error("No label defined for EQU directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
				MISSING_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof SetDirective) && (CommandUtil.getLabel(directiveLine) == null)) {
			error("No label defined for SET directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
				MISSING_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof EndDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for END directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof SpcDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for SPC directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof PagDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for PAG directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof RegDirective) && (CommandUtil.getLabel(directiveLine) == null)) {
			error("No label defined for REG directive",
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
				MISSING_LABEL);
		
		} else if ((directiveLine.getDirective() instanceof OptDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for OPT directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
   			
   		} else if ((directiveLine.getDirective() instanceof NamDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for NAM directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
   			
		} else if ((directiveLine.getDirective() instanceof SetDPDirective) && (CommandUtil.getLabel(directiveLine) != null)) {		
   			error("No label may be set for SETDP directive",                                                             
   				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
   				UNEXPECTED_LABEL);
		
   		} else {
			// nothing to do
		}
		
		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(directiveLine);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(directiveLine);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(equDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(equDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
		
		int equValue = AssemblerEngine.getInstance().getEquSetLabelValue(CommandUtil.getLabel(equDirective));
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
		
		AssembledOrgDirectiveLine assembledLine = (AssembledOrgDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(orgDirective);
		int orgValue = assembledLine.getValue();
		if (orgValue > 0xFFFF) {
			error("ORG value maximum value is $FFFF",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (orgValue < 0) {
			error("ORG value can't be negative",
					AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}
		

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(orgDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(orgDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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

		int valueToSet = CommandUtil.getByteToSet(fillDirective,AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE);
		int quantity = CommandUtil.getQuantity(fillDirective,AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER);
		if (valueToSet > 255) {
			error("FILL maximum value to set is 255",
					AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE,
					INVALID_RANGE);
		} else if (valueToSet < -128) {
			error("FILL value minimum value is -128",
					AssemblerPackage.Literals.FILL_DIRECTIVE__VALUE,
					INVALID_RANGE);
		} 		
			
		if (quantity < 0) {
			error("FILL value occurrence can't be negative",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		} else if (quantity == 0) {
			warning("FILL occurrence can't be null",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		} else if (quantity > 65535) {
			error("FILL value maximum value is $FFFF",
					AssemblerPackage.Literals.FILL_DIRECTIVE__NUMBER,
					INVALID_RANGE);
		}

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(fillDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(fillDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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
		List<String> listOfOptions = new ArrayList<>();
		for (AssemblyOption option : optDirective.getOptions()) {
			listOfOptions.add(option.getLiteral());
			if (options.contains(option.getLiteral())) {
				error("Duplicate option " + option.getLiteral(),
						AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
						DUPLICATE_OPTION);
			} else { 
				options.add(option.getLiteral());
			}
		}
		
		if (listOfOptions.contains("PAG") && listOfOptions.contains("NOP")) {
			error("The OPT directive does not contain at the same time the PAG and NOP options",
					AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
					INCONSISTENCY_ERROR);
		}
		if (listOfOptions.contains("CON") && listOfOptions.contains("NOC")) {
			error("The OPT directive does not contain at the same time the CON and NOC options",
					AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
					INCONSISTENCY_ERROR);
		}
		if (listOfOptions.contains("MAC") && listOfOptions.contains("NOM")) {
			error("The OPT directive does not contain at the same time the MAC and NOM options",
					AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
					INCONSISTENCY_ERROR);
		}
		if (listOfOptions.contains("EXP") && listOfOptions.contains("NOE")) {
			error("The OPT directive does not contain at the same time the EXP and NOE options",
					AssemblerPackage.Literals.OPT_DIRECTIVE__OPTIONS,
					INCONSISTENCY_ERROR);
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
		AssembledPagDirectiveLine assembledLine = (AssembledPagDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(pagDirective);
		int pagValue = assembledLine.getValue();
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

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(pagDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(pagDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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
	 * Can't be negative
	 * Doubt if equals to 0
	 * 
	 * @param bszDirective reference on the BSZ directive
	 */
	@Check
	public void checkBszConstraints(BszDirective bszDirective) {
		AssembledBszDirectiveLine assembledLine = (AssembledBszDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(bszDirective);
		int bszValue = assembledLine.getNbBytes();
	    if (bszValue < 0) {
			error("BSZ value can't be negative",
					AssemblerPackage.Literals.BSZ_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (bszValue == 0) {
			warning("Reserving no bytes makes no sense",
					AssemblerPackage.Literals.BSZ_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}

	    // Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(bszDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(bszDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
	}

	/**
	 * Check the SETDP directive constraints
	 * Can't be negative
	 * 
	 * @param setdpDirective reference on the SETDP directive
	 */
	@Check
	public void checkSetDPConstraints(SetDPDirective setdpDirective) {
		AssembledSetDPDirectiveLine assembledLine = (AssembledSetDPDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(setdpDirective);
		int setDPValue = assembledLine.getValue();
	    if (setDPValue < 0) {
			error("SETDP value can't be negative",
					AssemblerPackage.Literals.SET_DP_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (setDPValue > 255) {
			error("The SETDP value cannot be greater than 255",
					AssemblerPackage.Literals.SET_DP_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}

	    // Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(setdpDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(setdpDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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
	}
	
	/**   
	 * Check SET constraints
	 *                                				                                                                                        
	 * The 6809 is a 16 bits microprocessor, so value must be contains in 16 bits		                                                                                                       
	 * The Limit of a positive value is  65535
	 * The limit of a negative value is -32768
	 * 
	 * @param equDirective reference on the SET directive
	 */
	@Check
	public void checkSetConstraints(SetDirective setDirective) {

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(setDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(setDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}

		int setValue = AssemblerEngine.getInstance().getEquSetLabelValue(CommandUtil.getLabel(setDirective));
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
		AssembledSpcDirectiveLine assembledLine = (AssembledSpcDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(spcDirective);
		int spcValue = assembledLine.getSpaceCountValue();
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
		
		int keepCount = assembledLine.getkeepCountValue();
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
		

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(spcDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(spcDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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
		
		if (regs.contains("A") && regs.contains("D")) {
			error("D register overwrite the A register in the REG Directive",
					AssemblerPackage.Literals.REG_DIRECTIVE__OPTIONS,
					DUPLICATE_OPTION);
		}
		if (regs.contains("B") && regs.contains("D")) {
			error("D register overwrite the B register in the REG Directive",
					AssemblerPackage.Literals.REG_DIRECTIVE__OPTIONS,
					DUPLICATE_OPTION);
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
		
		AssembledFcbDirectiveLine assembledLine = (AssembledFcbDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(fcbDirective);
		int[] fcbValues = assembledLine.getValues();
		int location = 1;
		for (Integer fcbValue : fcbValues) {
			if (fcbValue > 255) {
				error("FCB value maximum value is $FF at location " + location ,
						AssemblerPackage.Literals.FCB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			} else if (fcbValue < -127) {
				error("FCB value can't lower than -127 at location " + location,
						AssemblerPackage.Literals.FCB_DIRECTIVE__OPERAND,
						INVALID_RANGE);
			}
			location++;
		}

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(fcbDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(fcbDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
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
		
		AssembledFdbDirectiveLine assembledLine = (AssembledFdbDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(fdbDirective);
		int[] rmbValues = assembledLine.getValues();
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

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(fdbDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(fdbDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
	}
	
	@Check
	/**
	 * Check the RMB directive limits (1-FFFF)
	 * 
	 * @param rmbDirective reference on the RMB directive
	 */
	public void checkRmdConstraints(RmbDirective rmbDirective) {
		AssembledRmbDirectiveLine assembledLine = (AssembledRmbDirectiveLine)AssemblerEngine.getInstance().getAssemblyLine(rmbDirective);
		int rmbValue = assembledLine.getNbBytesReserved();
		if (rmbValue > 0xFFFF) {
			error("RMB value maximum value is $FFFF",
					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		} else if (rmbValue < 1) {
			error("RMB value can't lower than 1",
					AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND,
					INVALID_RANGE);
		}

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(rmbDirective);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(rmbDirective);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
	}
}
