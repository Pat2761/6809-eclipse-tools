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

import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.emf.ecore.EObject;

/**
 * Used to store information about REG directive.
 * 
 * @author Patrick BRIAND
 */
public class AssembledRegDirectiveLine extends AbstractAssembledDirectiveLine {

	/** reference to the REG directive in the edited file */
	private RegDirective directive;
	/** Integer value defined by the REG directive */ 
	private int value;	
	
	/**
	 * Constructor of the class
	 */
	public AssembledRegDirectiveLine(AssemblerEngine engine) {
		super(engine);
	}

	/**
	 * Extract information from the edited line.
	 * 
	 * @param directive reference to the Xtext description of the BSZ directive
	 * @param currentPcValue value on the PC counter
	 * @param lineNumber line number in the source file 
	 */
	public void parsePass1(EObject directive, int currentPcValue, int lineNumber) {
		this.directive = (RegDirective) directive;
		this.pcAddress = currentPcValue;
		this.lineNumber = lineNumber;
		this.label = CommandUtil.getLabel(this.directive);
		this.comment = CommandUtil.getComment(this.directive);

		AssemblerEngine assemblerEngine = getAssemblerEngine(directive);
		value = assemblerEngine.getEquSetManager().getValue(label);
	}

	@Override
	public void parsePass2() {
		// Nothing to do here
	}

	/**
	 * Return the reference on the directive line.
	 * 
	 * @return reference on the directive line.
	 */
	public RegDirective getDirective() {
		return directive;
	}

	/**
	 * set the reference on the directive line.
	 * 
	 * @param directive reference on the directive line.
	 */
	public void setDirective(RegDirective directive) {
		this.directive = directive;
	}

	/**
	 * Get value.
	 *  
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Set value.
	 *  
	 * @param value value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

	@Override
	public boolean canDisplayPcAddress() {
		return false;
	}

	@Override
	public String getDirectiveName() {
		return directive.getDirective();
	}
}
