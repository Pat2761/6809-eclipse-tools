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
package org.bpy.electronics.mc6809.externaltools.launcher;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;

/**
 * Allow to execute a calculator.
 * 
 * @author Patrick BRIAND
 *
 */
public class CalculatorLauncher implements ILauncher {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(CalculatorLauncher.class.getSimpleName());

	@Override
	public boolean isAlreadyRunning() {
		return false;
	}

	@Override
	public void launch() {
		String calculatorLocation = PreferenceManager.getInstance().getCalculatorLocation();
		IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();

		try {
			String calculatorPath =  manager.performStringSubstitution(calculatorLocation);
			if (!isAlreadyRunning()) {
				Runtime.getRuntime().exec(calculatorPath);
			}
		} catch (IOException | CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
