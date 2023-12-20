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

import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DaaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRegDirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.xtext.validation.Check;

/**
 * Allow to record error coming from instruction validation
 * 
 * @author briand
 *
 */
public class InstructionValidator extends AbstractAssemblerValidator  {

	public static final String ILLEGAL_MODE = "illegalMode";
	public static final String ILLEGAL_EXCHANGE = "illegalExchange";
	public static final String MISSING_DIRECTIVE = "missingDirective";
	public static final String MISSING_OPTION = "missingOption";
	public static final String DUPLICATE_OPTION = "duplicateOption";
	public static final String ILLEGAL_REGISTER = "illegalRegister";

	/**
	 * Check duplicate labels
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkDuplicateLabels(InstructionLine instruction) {
		
		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(instruction);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(instruction);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
	}

	/**
	 * Check errors on the AdcInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkDirectiveLine(AdcInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AddInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkDirectiveLine(AddInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AdddInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkDirectiveLine(AdddInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AndInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(AndInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AndCCInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(AndCCInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AslInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(AslInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the AsrInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(AsrInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the BitInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(BitInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the ClrInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(ClrInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the CmpInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(CmpInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the ComInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(ComInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the CwaiInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(CwaiInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the DaaInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(DaaInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the DecInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(DecInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the EorInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(EorInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the ExgInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(ExgInstruction instruction) {
		exposeProblems(instruction);
	}	

	/**
	 * Check errors on the IncInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(IncInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the JmpInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(JmpInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the TfrInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(TfrInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the JsrInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(JsrInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the LdInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(LdInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the LeaInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(LeaInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the LslInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(LslInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the LsrInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(LsrInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the MulInstruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(MulInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the Neg Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(NegInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the Or Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(OrInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the Or Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(OrCCInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the PSHS Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(PshsInstruction instruction) {
		
		if (instruction.getOperand() == null) {
			List<String> regs = CommandUtil.getRegisters(instruction);
			List<String> testReg = new ArrayList<>();
			
			if (regs.isEmpty()) {
				error("no register defined in the PSHS instruction",
						AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
						MISSING_OPTION);
				
			} else {
				for (String reg : regs) {
					if (testReg.contains(reg)) {
						error("Register " + reg + " is duplicate in the REG Directive",
								AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
								DUPLICATE_OPTION);
						break;
					} else {
						testReg.add(reg);
					}
		 		}
			}

			if (regs.contains("A") && regs.contains("D")) {
				error("D register overwrite the A register in the REG Directive",
						AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("B") && regs.contains("D")) {
				error("D register overwrite the B register in the REG Directive",
						AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("S")) {
				error("S register can't be push for a PSHS instruction",
						AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
						ILLEGAL_REGISTER);
			}
		} else {
			AbstractAssemblyLine regInstruction = AssemblerEngine.getInstance().getLabelsEquSet().get(instruction.getOperand().getValue());
			if ( (regInstruction!= null) && (regInstruction instanceof AssembledRegDirectiveLine )) {
				if (((AssembledRegDirectiveLine)regInstruction).checkRegister(Register.S)) {
					error("S register can't be push for a PSHS instruction",
							AssemblerPackage.Literals.PSHS_INSTRUCTION__OPERAND,
							ILLEGAL_REGISTER);
				}
			}
		}
		
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the PSHU Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(PshuInstruction instruction) {
		
		if (instruction.getOperand() == null) {
			List<String> regs = CommandUtil.getRegisters(instruction);
			List<String> testReg = new ArrayList<>();
			
			if (regs.isEmpty()) {
				error("no register defined in the PSHU instruction",
						AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
						MISSING_OPTION);
				
			} else {
				for (String reg : regs) {
					if (testReg.contains(reg)) {
						error("Register " + reg + " is duplicate in the REG Directive",
								AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
								DUPLICATE_OPTION);
						break;
					} else {
						testReg.add(reg);
					}
		 		}
			}

			if (regs.contains("A") && regs.contains("D")) {
				error("D register overwrite the A register in the REG Directive",
						AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("B") && regs.contains("D")) {
				error("D register overwrite the B register in the REG Directive",
						AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("U")) {
				error("U register can't be push for a PSHU instruction",
						AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
						ILLEGAL_REGISTER);
			}
		} else {
			AbstractAssemblyLine regInstruction = AssemblerEngine.getInstance().getLabelsEquSet().get(instruction.getOperand().getValue());
			if ( (regInstruction!= null) && (regInstruction instanceof AssembledRegDirectiveLine )) {
				if (((AssembledRegDirectiveLine)regInstruction).checkRegister(Register.U)) {
					error("U register can't be push for a PSHU instruction",
							AssemblerPackage.Literals.PSHU_INSTRUCTION__OPERAND,
							ILLEGAL_REGISTER);
				}
			}
		}
		
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the PULS Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(PulsInstruction instruction) {
		
		if (instruction.getOperand() == null) {
			List<String> regs = CommandUtil.getRegisters(instruction);
			List<String> testReg = new ArrayList<>();
			
			if (regs.isEmpty()) {
				error("no register defined in the PULS instruction",
						AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
						MISSING_OPTION);
				
			} else {
				for (String reg : regs) {
					if (testReg.contains(reg)) {
						error("Register " + reg + " is duplicate in the REG Directive",
								AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
								DUPLICATE_OPTION);
						break;
					} else {
						testReg.add(reg);
					}
		 		}
			}

			if (regs.contains("A") && regs.contains("D")) {
				error("D register overwrite the A register in the REG Directive",
						AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("B") && regs.contains("D")) {
				error("D register overwrite the B register in the REG Directive",
						AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("S")) {
				error("S register can't be push for a PULS instruction",
						AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
						ILLEGAL_REGISTER);
			}
		} else {
			AbstractAssemblyLine regInstruction = AssemblerEngine.getInstance().getLabelsEquSet().get(instruction.getOperand().getValue());
			if ( (regInstruction!= null) && (regInstruction instanceof AssembledRegDirectiveLine )) {
				if (((AssembledRegDirectiveLine)regInstruction).checkRegister(Register.S)) {
					error("S register can't be pull for a PULS instruction",
							AssemblerPackage.Literals.PULS_INSTRUCTION__OPERAND,
							ILLEGAL_REGISTER);
				}
			}
		}
		
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the PULS Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(PuluInstruction instruction) {
		
		if (instruction.getOperand() == null) {
			List<String> regs = CommandUtil.getRegisters(instruction);
			List<String> testReg = new ArrayList<>();
			
			if (regs.isEmpty()) {
				error("no register defined in the PULU instruction",
						AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
						MISSING_OPTION);
				
			} else {
				for (String reg : regs) {
					if (testReg.contains(reg)) {
						error("Register " + reg + " is duplicate in the REG Directive",
								AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
								DUPLICATE_OPTION);
						break;
					} else {
						testReg.add(reg);
					}
		 		}
			}

			if (regs.contains("A") && regs.contains("D")) {
				error("D register overwrite the A register in the REG Directive",
						AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("B") && regs.contains("D")) {
				error("D register overwrite the B register in the REG Directive",
						AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
						DUPLICATE_OPTION);
			}
			if (regs.contains("U")) {
				error("U register can't be pull for a PULU instruction",
						AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
						ILLEGAL_REGISTER);
			}
		} else {
			AbstractAssemblyLine regInstruction = AssemblerEngine.getInstance().getLabelsEquSet().get(instruction.getOperand().getValue());
			if ( (regInstruction!= null) && (regInstruction instanceof AssembledRegDirectiveLine )) {
				if (((AssembledRegDirectiveLine)regInstruction).checkRegister(Register.U)) {
					error("U register can't be pull for a PULU instruction",
							AssemblerPackage.Literals.PULU_INSTRUCTION__OPERAND,
							ILLEGAL_REGISTER);
				}
			}
		}
		
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the ROL Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(RolInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the ROR Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(RorInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the RTI Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(RtiInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the RTS Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(RtsInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Check errors on the SBC Instruction line
	 * 
	 * @param instruction reference on the instruction line
	 */
	@Check
	public void checkInstructionLine(SbcInstruction instruction) {
		exposeProblems(instruction);
	}	
	
	/**
	 * Declare problems and warnings detected during the assembly step for an Instruction
	 * 
	 * @param instruction reference on the instruction
	 */
	private void exposeProblems(Object instruction) {

		// Management of errors after code analyse 
		List<AssemblerProblemManagerDescription> errors = AssemblerErrorManager.getInstance().getProblems(instruction);
		for (AssemblerProblemManagerDescription error : errors) {
			error(error.getMessage(), error.getFeature(), error.getIssueData());
		}

		// Management of warnings after code analyse 
		List<AssemblerProblemManagerDescription> warnings = AssemblerErrorManager.getInstance().getWarnings(instruction);
		for (AssemblerProblemManagerDescription warning : warnings) {
			warning(warning.getMessage(), warning.getFeature(), warning.getIssueData());
		}
	}
}
