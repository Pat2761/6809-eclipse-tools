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

import org.bpy.electronics.mc6809.rcp.Activator;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * This class manage the all preferences linked to this application
 * 
 * @author briand
 *
 */
public class PreferenceManager {
	/** Name of node which store the preferences */
	public static final String ASSEMBLER_PREFERENCE_NODE = "assemblerPreferenceNode";
	
	/** Key of the preference which store the Tab policy */
	public static final String TAB_POLICY = "tabPolicy";
	/** for a define a tab policy base on tab characters only */
	public static final String TAB_ONLY = "Tab only";
	/** for a define a tab policy base on space characters only */
	public static final String SPACE_ONLY = "Space only";
	/** for a define a tab policy base on tab and space characters only */
	public static final String MIXED = "Mixed";
	
	/** Key of the preference which store the tab size */
	public static final String TAB_SIZE = "tabSize";
	/** Key of the preference which store the label size */
	public static final String LABEL_SIZE = "labelSize";
	/** Key of the preference which store the instruction size */
	public static final String INSTRUCTION_SIZE = "instructionSize";
	/** Key of the preference which store the operand size */
	public static final String OPERAND_SIZE = "operandSize";
	
	/** Define the default value of the Tab policy preference */
	public static final String TAB_POLICY_DEFAULT_VALUE = SPACE_ONLY;
	/** Define the default value of the tab size preference */
	public static final int TAB_SIZE_DEFAULT_VALUE = 3;
	/** Define the default value of the label size preference */
	public static final int LABEL_SIZE_DEFAULT_VALUE = 15;
	/** Define the default value of the instruction size preference */
	public static final int INSTRUCTION_SIZE_DEFAULT_VALUE = 6;
	/** Define the default value of the operand size preference */
	public static final int OPERAND_SIZE_DEFAULT_VALUE = 20;
	
	/** Instance of the preference manager singleton */ 
	public static PreferenceManager eInstance;

	/** Store the default values */
	private Map<String,String> defaultsValues;

	/** Memorize the preference instance */
	private Preferences preferences;
	
	/** 
	 * Constructor of the preference manager.
	 * Initialize field of the object
	 */
	private PreferenceManager() {
		IEclipsePreferences node = (IEclipsePreferences) InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		preferences = node.node(ASSEMBLER_PREFERENCE_NODE);
		defaultsValues = new HashMap<>();
		
		defaultsValues.put(TAB_POLICY, SPACE_ONLY);
		defaultsValues.put(TAB_SIZE, "" + TAB_SIZE_DEFAULT_VALUE);
		defaultsValues.put(LABEL_SIZE,""+  LABEL_SIZE_DEFAULT_VALUE);
		defaultsValues.put(INSTRUCTION_SIZE,"" + INSTRUCTION_SIZE_DEFAULT_VALUE);
		defaultsValues.put(OPERAND_SIZE,"" + OPERAND_SIZE_DEFAULT_VALUE);
	}
	
	/**
	 * Get singleton instance of the preference manager.
	 * 
	 * @return instance of the preference manager
	 */
	public static PreferenceManager getInstance() {
		if (eInstance == null) {
			eInstance = new PreferenceManager();
		}
		return eInstance;
	}

	/**
	 * Get String value of the preference.
	 * 
	 * @param key Key which define the reference
	 * 
	 * @return Value of the preference, default value if the preference isn't defined
	 */
	public String getStringPreferenceValue(String key) {
		return preferences.get(key,defaultsValues.get(key)); 
	}

	/**
	 * Get Integer value of the preference.
	 * 
	 * @param key Key which define the reference
	 * 
	 * @return Value of the preference, default value if the preference isn't defined
	 */
	public int getIntPreferenceValue(String key) {
		String intValue = preferences.get(key, defaultsValues.get(key));
		try {
			return Integer.parseInt(intValue);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	/**
	 * Set String value of the preference.
	 * 
	 * @param key Key which define the reference
	 */
	public void setPreferenceValue(String key, String value) {
		preferences.put(key, value);
		savePreference();
	}

	/**
	 * Set integer value of the preference.
	 * 
	 * @param key Key which define the reference
	 */
	public void setPreferenceValue(String key, int value) {
		preferences.put(key, ""+value);
		savePreference();
	}

	/**
	 * Reset the preference values
	 */
	public void resetPreferences() {
		try {
			preferences.clear();
			preferences.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Update file which store the preference in the workspace
	 */
	private void savePreference() {
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
