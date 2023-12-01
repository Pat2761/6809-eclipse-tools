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
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.eclipse.xtext.validation.Check;

/**
 * Allow to record error coming from instruction validation
 * 
 * @author briand
 *
 */
public class InstructionValidator extends AbstractAssemblerValidator  {


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
