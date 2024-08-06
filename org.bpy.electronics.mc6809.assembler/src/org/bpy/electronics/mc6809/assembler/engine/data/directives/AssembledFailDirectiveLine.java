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

import org.bpy.electronics.mc6809.assembler.assembler.FailDirective;
import org.eclipse.emf.ecore.EObject;

/**
 * Store the Fail directive description
 * 
 * @author Patrick BRIAND
 *
 */
public class AssembledFailDirectiveLine  extends AbstractAssembledDirectiveLine {

	/** Memorize the reference on the directive */
	private FailDirective failDirective;

	@Override
	public int getPcIncrement() {
		return 0;
	}

	public void parsePass1(EObject failDirective, int currentPcValue, int lineNumber) {
		this.lineNumber = lineNumber;
		this.pcAddress = currentPcValue;
		this.failDirective = (FailDirective) failDirective;
	}

	@Override
	public void parsePass2() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get reference on the fail directive.
	 * 
	 * @return reference on the fail directive.
	 */
	public FailDirective getDirective() {
		return failDirective;
	}

}
