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
package org.bpy.electronics.mc6809.rcp.preferences;

import org.bpy.electronics.mc6809.rcp.Activator;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceManager {
	public static final String TAB_POLICY = "tabPolicy";
	public static final String TAB_ONLY = "Tab only";
	public static final String SPACE_ONLY = "Space only";
	public static final String MIXED = "Mixed";
	
	public static final String TAB_SIZE = "tabSize";
	public static final String LABEL_SIZE = "labelSize";
	public static final String INSTRUCTION_SIZE = "instructionSize";
	public static final String OPERAND_SIZE = "operandSize";
	
	public static PreferenceManager eInstance;

	private PreferenceManager() {
	}
	
	public static PreferenceManager getInstance() {
		if (eInstance == null) {
			eInstance = new PreferenceManager();
		}
		return eInstance;
	}
	
	public String getStringPreferenceValue(String key) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		return store.getString(key); 
	}

	public void setPreferenceValue(String key, String value) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setValue(key, value); 
	}

	public int getIntPreferenceValue(String key) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		return store.getInt(key); 
	}

	public void setPreferenceValue(String key, int value) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setValue(key, value); 
	}
}
