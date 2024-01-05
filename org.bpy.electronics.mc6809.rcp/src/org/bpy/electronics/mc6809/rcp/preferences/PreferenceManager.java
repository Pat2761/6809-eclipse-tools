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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.Preferences;

public class PreferenceManager {
	private static final String PREFERENCE_NAME = "org.bpy.electronics.mc6809.application"; //$NON-NLS-1$

	public static final String TAB_POLICY = "tabPolicy";
	public static final String TAB_ONLY = "Tab only";
	public static final String SPACE_ONLY = "Space only";
	public static final String MIXED = "Mixed";
	
	public static final String TAB_SIZE = "tabSize";
	public static final String LABEL_SIZE = "labelSize";
	public static final String INSTRUCTION_SIZE = "instructionSize";
	public static final String OPERAND_SIZE = "operandSize";
	
	public static PreferenceManager eInstance;
	
	private Map<String,Object> preferenceValues;
	
	private PreferenceManager() {
		preferenceValues = new HashMap<>();
		initializePreferences();
	}
	
	public static PreferenceManager getInstance() {
		if (eInstance == null) {
			eInstance = new PreferenceManager();
		}
		return eInstance;
	}
	
	private void initializePreferences() {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PREFERENCE_NAME);
		
		readStringPreferenceValue(preferences, TAB_POLICY,SPACE_ONLY);
		readIntPreferenceValue(preferences, TAB_SIZE,"3");
		readIntPreferenceValue(preferences, LABEL_SIZE,"15");
		readIntPreferenceValue(preferences, INSTRUCTION_SIZE,"6");
		readIntPreferenceValue(preferences, OPERAND_SIZE,"18");
	}

	public String getStringPreferenceValue(String key) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PREFERENCE_NAME);
		Preferences prefValue = preferences.node(key);
		return prefValue.get(key, "");
	}

	public int getIntPreferenceValue(String key) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PREFERENCE_NAME);
		Preferences prefValue = preferences.node(key);
		String strVal = prefValue.get(key, "0");
		return Integer.parseInt(strVal);
	}
	
	public void savePreference(String key, String value) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PREFERENCE_NAME);
		Preferences node = preferences.node(key);
		node.put(key, value);
		preferenceValues.put(key, value);
	}
	
	public void savePreference(String key, int value) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(PREFERENCE_NAME);
		preferences.put(key, "" + value);
		preferenceValues.put(key, "" + value);
	}
	
	private void readStringPreferenceValue(IEclipsePreferences preferences, String key, String defaultValue) {
		Preferences prefValue = preferences.node(key);
		if (prefValue == null) {
			preferences.put(key, defaultValue);
		}
		preferenceValues.put(key, prefValue.get(key, defaultValue));
	}

	private void readIntPreferenceValue(IEclipsePreferences preferences, String key, String defaultValue) {
		Preferences prefValue = preferences.node(key);
		if (prefValue == null) {
			preferences.put(key, defaultValue);
		}
		try {
			int value = Integer.parseInt(prefValue.get(key, defaultValue));
			preferenceValues.put(key, value);
		} catch(NumberFormatException ex) {
			// nothing to do
		}
	}
	
}
