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
package org.bpy.electronics.mc6809.externaltools.ui.handlers;

import java.io.File;

import org.bpy.electronics.mc6809.externaltools.launcher.CalculatorLauncher;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

/**
 * Handler for invoke a calculator
 * 
 * @author Patrick BRIAND
 *
 */
public class ExecuteExternalCalculatorHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}

	@Override
	public void dispose() {
		// Nothing to do
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CalculatorLauncher launcher = new CalculatorLauncher();
		launcher.launch();
		return null;
	}

	@Override
	public boolean isEnabled() {
		String calculatorPath = PreferenceManager.getInstance().getCalculatorLocation();
		File calculatorFile = new File(calculatorPath);
		return (calculatorFile.isFile() && calculatorFile.exists());
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// Nothing to do
	}

}
