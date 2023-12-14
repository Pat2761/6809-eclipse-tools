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

import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DaaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
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
