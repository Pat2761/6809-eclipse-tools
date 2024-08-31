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

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.eclipse.xtext.validation.Check;

/**
 * This class is used only for detect editor change. 
 * it invokes the assembler for find validation problems
 * and signal to the observer any change in the editor.  
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerPrepareValidationAndSignalChange  extends AbstractAssemblerValidator {

	@Check
	public void assembleModel(Model model) {
		AssemblerManager.getInstance().getAssemblyModel(model,true);
	}
						
}
