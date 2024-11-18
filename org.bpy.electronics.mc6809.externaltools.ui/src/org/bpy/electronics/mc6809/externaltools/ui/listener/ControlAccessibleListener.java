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
package org.bpy.electronics.mc6809.externaltools.ui.listener;

import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;

/**
 * Control accessible Listener
 * 
 * @author Patrick BRIAND
 *
 */
public class ControlAccessibleListener extends AccessibleAdapter {

	/** Name of the control */
	String controlName;

	/**
	 * Constructor of the class.
	 * 
	 * @param name name of the control
	 */
 	public ControlAccessibleListener(String name) {
		controlName = name;
	}

	@Override
	public void getName(AccessibleEvent e) {
		e.result = controlName;
	}
}