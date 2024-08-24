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
package org.bpy.electronics.mc6809.assembler.engine.data.comment;

import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.eclipse.emf.ecore.EObject;

/**
 * Assemble blank line (nothing to do)
 * 
 * @author Patrick BRIAND
 *
 */
public class AssembledBlankLine extends AbstractAssemblyLine {

	/**
	 * Constructor of the class.
	 * @param engine reference on the assemblerEngine
	 */
	public AssembledBlankLine(AssemblerEngine engine) {
		super(engine);
	}
	
	@Override
	public void parsePass1(EObject blankLine, int currentPcValue, int lineNumber) {
		this.lineNumber = lineNumber;
		pcAddress = currentPcValue;
	}

	@Override
	public void parsePass2() {
		// Nothing to do here
	}

	@Override
	public int getPcIncrement() {
		return 0;
	}

	@Override
	public boolean canDisplayPcAddress() {
		return false;
	}
}
