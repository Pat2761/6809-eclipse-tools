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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@ComposedChecks(validators = {DirectiveValidator.class})
public class AssemblerValidator extends AbstractAssemblerValidator {
	
	public static final String INVALID_FIGURE = "invalidFigure";

	@Check
	public void prepareValidation(Model model) {
		AssemblerEngine.getInstance().clear();
		AssemblerEngine.getInstance().engine(model);
	}
	
	@Check
	public void checkFigureInBinary(BinaryValue binaryValue) {
		String strVal = binaryValue.getValue();
		for (int i=0;  i<strVal.length(); i++) {
			if (strVal.charAt(i)!='0' && strVal.charAt(i) != '1') {
				error(strVal.charAt(i) + " is invalid in binary value",
						AssemblerPackage.Literals.BINARY_VALUE__VALUE,
						INVALID_FIGURE);
				break;
			}
		}
		this.addIssue(strVal, binaryValue, strVal);
	}

	@Check
	public void checkFigureInOctal(OctalValue octalValue) {
		String strVal = octalValue.getValue();
		for (int i=0;  i<strVal.length(); i++) {
			if (strVal.charAt(i)<'0' || strVal.charAt(i) > '7') {
				error(strVal.charAt(i) + " is invalid in octal value",
						AssemblerPackage.Literals.OCTAL_VALUE__VALUE,
						INVALID_FIGURE);
				break;
			}
		}
	}

	@Check
	public void checkOrgDirective(OrgDirective orgDirective) {
		List<AssemblerProblemManagerDescription> problems = AssemblerErrorManager.getInstance().getProblems(orgDirective);
		if (problems != null) {
			for (AssemblerProblemManagerDescription problem : problems) {
				System.out.println(problem.getMessage());
			}
		}
	}
}
