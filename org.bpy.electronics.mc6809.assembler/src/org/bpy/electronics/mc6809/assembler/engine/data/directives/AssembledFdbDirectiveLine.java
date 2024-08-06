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
package org.bpy.electronics.mc6809.assembler.engine.data.directives;

import java.util.Arrays;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about FDB directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledFdbDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the FDB directive in the edited file */
	private FdbDirective directive;
	/** Integer value defined by the FCB directive */ 
	private int[] values;	
	/**
	 * Constructor of the class
	 */
	public AssembledFdbDirectiveLine() {
		// nothing to do
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the FDB directive
	 * @param currentPcValu;e value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (FdbDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);

		int size = 1;
		if (this.directive.getOperand().getCommaExpressions() != null) {
			size += this.directive.getOperand().getCommaExpressions().size();
		}
		values = new int[size];	
		Arrays.fill(values, 0);
	}

	@Override
	public void parsePass2() {
		List<Integer> listValues;
		try {
			listValues = ExpressionParser.parse(this.directive);
			values = new int[listValues.size()];
			for (int i=0; i<listValues.size(); i++) {
				values[i] = listValues.get(i);	
			}
		} catch (UnresolvedException e) {
			values = new int[0];
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					e.getDescriptor().getMessage(), 
					e.getDescriptor().getReference(), 
					InstructionValidator.EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(directive, errorDescription);
		}
	}

	/**
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public FdbDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(FdbDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get values
	 *  
	 * @return values
	 */
	public int[] getValues() {
		return values;
	}

	@Override
	public int getPcIncrement() {
		return values.length*2;
	}
}
