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
package org.bpy.electronics.mc6809.preferences.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import org.bpy.electronics.mc6809.preferences.Activator;
import org.bpy.electronics.mc6809.preferences.core.data.MacroInstructionData;

/**
 * This class manage the all preferences linked to this application
 * 
 * @author briand
 *
 */
public class PreferenceManager {
	
	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(PreferenceManager.class.getSimpleName());

	/** Separator of macros */
	private static final String MACRO_SEPARATOR = ";";
	/** Content separator for the macro description */
	private static final String MACRO_FIELD_SEPARATOR = "@@";
	/** Index of the macro name */
	private static final int MACRO_INSTRUCTION_NAME = 0;
	/** Index of the equivalent instruction name */
	private static final int MACRO_EQUIVALENT_NAME = 1;
	/** Index of the equivalent instruction operand */
	private static final int MACRO_EQUIVALENT_OPERAND_STRING = 2;
	/** Index of the equivalent instruction opcode */
	private static final int MACRO_EQUIVALENT_OPCODE = 3;
	/** Index of the equivalent instruction opcode */
	private static final int MACRO_EQUIVALENT_OPERAND = 4;
	
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

	/** for a define JUNIT case  */
	public static final String JUNIT_PREFERENCE = "junitPreference";

	
	/** Key of the preference which store the tab size */
	public static final String TAB_SIZE = "tabSize";
	/** Key of the preference which store the instruction starting column */
	public static final String INSTRUCTION_POSITION = "instructionPosition";
	/** Key of the preference which store the operand starting column */
	public static final String OPERAND_POSITION = "operandPosition";
	/** Key of the preference which store the comment starting column */
	public static final String COMMENT_POSITION = "commentPosition";
	
	
	/** Key of the preference which store the enable preference folding */
	public static final String ENABLE_FOLDING = "enableFolding";
	/** Key of the preference which store the enable comment folding preference */
	public static final String COMMENT_FOLDING_A_INIT = "CommentFoldingAtInit";
	/** Key of the preference which store the operand starting column */
	public static final String MACRO_FOLDING_A_INIT = "macroFoldingAtInit";
	
	/** key for store empty line before label */
	public static final String EMPTY_LINE_BEFORE_LABEL = "emptyLineBeforeLabel";
	/** key for comment line at instruction level */
	public static final String COMMENT_LINE_AT_INSTRUCTION_LEVEL = "commentLineAtInstructionLevel";
	
	
	/** Define the default value of the Tab policy preference */
	public static final String TAB_POLICY_DEFAULT_VALUE = SPACE_ONLY;
	/** Define the default value of the tab size preference */
	public static final int TAB_SIZE_DEFAULT_VALUE = 3;
	/** Define the default value of the instruction size preference */
	public static final int INSTRUCTION_POSITION_DEFAULT_VALUE = 10;
	/** Define the default value of the operand size preference */
	public static final int OPERAND_POSITION_DEFAULT_VALUE = 26;
	/** Define the default value of the operand size preference */
	public static final int COMMENT_POSITION_DEFAULT_VALUE = 52;
	
	/** Default value of the preference which store the enable preference folding */
	public static final boolean ENABLE_FOLDING_DEFAULT_VALUE = true;
	/** Default value the preference which store the enable comment folding preference */
	public static final boolean COMMENT_FOLDING_A_INIT_DEFAULT_VALUE = true;
	/** Default value the preference which store the operand starting column */
	public static final boolean MACRO_FOLDING_A_INIT_DEFAULT_VALUE = true;
	
	/** define the orientation preference of the listing */
	public static final String LISTING_ORIENTATION = "listingOrienation";
	/** define the number of spaces for the line number information in the listing */
	public static final String LISTING_LINE_NUMBER_SPACES = "listingLineNumberSpaces";
	/** define the number of spaces for the address information in the listing */
	public static final String LISTING_ADDRESS_NUMBER_SPACES = "listingAddressNumberSpaces";
	/** define the number of spaces for the opcode information in the listing */
	public static final String LISTING_OPCODE_NUMBER_SPACES = "listingOpcodeNumberSpaces";
	/** define the number of spaces for the operand information in the listing */
	public static final String LISTING_OPERAND_NUMBER_SPACES = "listingOperandNumberSpaces";
	/** define the number of spaces for the label information in the listing */
	public static final String LISTING_LABEL_NUMBER_SPACES = "listingLabelNumberSpaces";
	/** define the number of spaces for the instruction information in the listing */
	public static final String LISTING_INSTRUCTION_NUMBER_SPACES = "listingInstructionNumberSpaces";
	/** define the number of spaces for the operand instruction information in the listing */
	public static final String LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES = "listingOperandInstructionNumberSpaces";

	/** define the default orientation preference of the listing */
	public static final String DEFAULT_LISTING_ORIENTATION = "Portrait";
	/** define the default number of spaces for the line number information in the listing */
	public static final int DEFAULT_LISTING_LINE_NUMBER_SPACES = 4;
	/** define the default number of spaces for the address information in the listing */
	public static final int DEFAULT_LISTING_ADDRESS_NUMBER_SPACES = 4;
	/** define the default number of spaces for the opcode information in the listing */
	public static final int DEFAULT_LISTING_OPCODE_NUMBER_SPACES = 6;
	/** define the default number of spaces for the operand information in the listing */
	public static final int DEFAULT_LISTING_OPERAND_NUMBER_SPACES = 6;
	/** define the default number of spaces for the label information in the listing */
	public static final int DEFAULT_LISTING_LABEL_NUMBER_SPACES = 6;
	/** define the default number of spaces for the instruction information in the listing */
	public static final int DEFAULT_LISTING_INSTRUCTION_NUMBER_SPACES = 5;
	/** define the default number of spaces for the operand instruction information in the listing */
	public static final int DEFAULT_LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES = 20;

	/** define the key for store macro instructions */
	public static final String MACRO_INSTRUCTION_KEY = "macroInstructionKey";
	/** define the default value for macro instructions */
	public static final String DEFAULT_MACRO_INSTRUCTION = "";
	
	
	/** Instance of the preference manager singleton */ 
	private static PreferenceManager eInstance;

	/** Store the default values */
	private Map<String,String> defaultsValues;

	/** Memorize the preference instance */
	private Preferences preferences;

	/** Reference on the preference store */
	private IPreferenceStore store;
	
	
	/** 
	 * Constructor of the preference manager.
	 * Initialize field of the object
	 */
	private PreferenceManager() {
		IEclipsePreferences node = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
		preferences = node.node(ASSEMBLER_PREFERENCE_NODE);
		defaultsValues = new HashMap<>();
		
		defaultsValues.put(TAB_POLICY, SPACE_ONLY);
		defaultsValues.put(TAB_SIZE, "" + TAB_SIZE_DEFAULT_VALUE);
		defaultsValues.put(INSTRUCTION_POSITION,""+  INSTRUCTION_POSITION_DEFAULT_VALUE);
		defaultsValues.put(OPERAND_POSITION,"" + OPERAND_POSITION_DEFAULT_VALUE);
		defaultsValues.put(COMMENT_POSITION,"" + COMMENT_POSITION_DEFAULT_VALUE);
		defaultsValues.put(COMMENT_LINE_AT_INSTRUCTION_LEVEL,"" + false);
		defaultsValues.put(EMPTY_LINE_BEFORE_LABEL,"" + false);
		defaultsValues.put(MACRO_FOLDING_A_INIT, "" + MACRO_FOLDING_A_INIT_DEFAULT_VALUE);
		defaultsValues.put(COMMENT_FOLDING_A_INIT, "" + COMMENT_FOLDING_A_INIT_DEFAULT_VALUE);
		defaultsValues.put(ENABLE_FOLDING, "" + ENABLE_FOLDING_DEFAULT_VALUE);
		
		defaultsValues.put(LISTING_LINE_NUMBER_SPACES,""+DEFAULT_LISTING_LINE_NUMBER_SPACES);
		defaultsValues.put(LISTING_ADDRESS_NUMBER_SPACES,""+DEFAULT_LISTING_ADDRESS_NUMBER_SPACES);
		defaultsValues.put(LISTING_OPCODE_NUMBER_SPACES,""+DEFAULT_LISTING_OPCODE_NUMBER_SPACES);
		defaultsValues.put(LISTING_OPERAND_NUMBER_SPACES,""+DEFAULT_LISTING_OPERAND_NUMBER_SPACES);
		defaultsValues.put(LISTING_LABEL_NUMBER_SPACES,""+DEFAULT_LISTING_LABEL_NUMBER_SPACES);
		defaultsValues.put(LISTING_INSTRUCTION_NUMBER_SPACES,""+DEFAULT_LISTING_INSTRUCTION_NUMBER_SPACES);
		defaultsValues.put(LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES,""+DEFAULT_LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES);
		
		defaultsValues.put(MACRO_INSTRUCTION_KEY, ""+DEFAULT_MACRO_INSTRUCTION);

		store = EditorsUI.getPreferenceStore();	
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
	 * Get the Listing preference page orientation.
	 * 
	 * @return value of the page orientation
	 */
	public String getListingPageOrientation() {
		return preferences.get(LISTING_ORIENTATION, DEFAULT_LISTING_ORIENTATION);
	}

	/**
	 * Set the Listing preference page orientation.
	 * 
	 * @param orientation page orientation
	 */
	public void setListingPageOrientation(String orientation) {
		preferences.put(LISTING_ORIENTATION, orientation);
		savePreference();
	}

	/**
	 * Get the Listing preference line number size.
	 * 
	 * @return value of the line number size
	 */
	public int getListingLineNumberSize() {
		return preferences.getInt(LISTING_LINE_NUMBER_SPACES, DEFAULT_LISTING_LINE_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference line number size.
	 * 
	 * @param size line number size
	 */
	public void setListingLineNumberSize(int size) {
		preferences.putInt(LISTING_LINE_NUMBER_SPACES, size);
		savePreference();
	}

	/**
	 * Get the Listing preference address size.
	 * 
	 * @return value of the address size
	 */
	public int getListingAddressSize() {
		return preferences.getInt(LISTING_ADDRESS_NUMBER_SPACES, DEFAULT_LISTING_ADDRESS_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference address size.
	 * 
	 * @param size address size
	 */
	public void setListingAddressSize(int size) {
		preferences.putInt(LISTING_ADDRESS_NUMBER_SPACES, size);
		savePreference();
	}

	/**
	 * Get the Listing preference opcode size.
	 * 
	 * @return value of the opcode size
	 */
	public int getListingOpcodeSize() {
		return preferences.getInt(LISTING_OPCODE_NUMBER_SPACES, DEFAULT_LISTING_OPCODE_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference opcode size.
	 * 
	 * @param size opcode size
	 */
	public void setListingOpcodeSize(int size) {
		preferences.putInt(LISTING_OPCODE_NUMBER_SPACES, size);
		savePreference();
	}

	/**
	 * Get the Listing preference operand size.
	 * 
	 * @return value of the operand size
	 */
	public int getListingOperandSize() {
		return preferences.getInt(LISTING_OPERAND_NUMBER_SPACES, DEFAULT_LISTING_OPERAND_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference operand size.
	 * 
	 * @param size operand size
	 */
	public void setListingOperandize(int size) {
		preferences.putInt(LISTING_OPERAND_NUMBER_SPACES, size);
		savePreference();
	}

	/**
	 * Get the Listing preference label size.
	 * 
	 * @return value of the label size
	 */
	public int getListingLabelSize() {
		return preferences.getInt(LISTING_LABEL_NUMBER_SPACES, DEFAULT_LISTING_LABEL_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference label size.
	 * 
	 * @param size label size
	 */
	public void setListingLabelize(int size) {
		preferences.putInt(LISTING_LABEL_NUMBER_SPACES, size);
		savePreference();
	}
	
	/**
	 * Get the Listing preference instruction size.
	 * 
	 * @return value of the instruction size
	 */
	public int getListingInstructionSize() {
		return preferences.getInt(LISTING_INSTRUCTION_NUMBER_SPACES, DEFAULT_LISTING_INSTRUCTION_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference instruction size.
	 * 
	 * @param size instruction size
	 */
	public void setListingInstructionize(int size) {
		preferences.putInt(LISTING_INSTRUCTION_NUMBER_SPACES, size);
		savePreference();
	}
	
	/**
	 * Get the Listing preference operand instruction size.
	 * 
	 * @return value of the operand instruction size
	 */
	public int getListingOperandInstructionSize() {
		return preferences.getInt(LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES, DEFAULT_LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES);
	}
	
	/**
	 * Set the Listing preference operand instruction size.
	 * 
	 * @param size value of the operand instruction size
	 */
	public void setListingOperandInstructionize(int size) {
		preferences.putInt(LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES, size);
		savePreference();
	}
	
	/**
	 * Get the system tab size.
	 * 
	 * @return value of the tab size
	 */
	public int getEditorTabSize() {
		return store.getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH);
	}

	/**
	 * Set the system tab size.
	 * 
	 * @param tabSize value of the tab size
	 */
	public void setEditorTabSize(int tabSize) {
		store.setValue(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH, tabSize);
		savePreference();
	}

	/**
	 * Get the tab policy used in the workspace.
	 * 
	 * @return tab policy value
	 */
	public String getTabPolicy() {
		return preferences.get(TAB_POLICY, TAB_POLICY_DEFAULT_VALUE);
	}
	
	/**
	 * Set the new tab policy.
	 * 
	 * @param tabPolicy tab policy value (SPACE_ONLY, TAB_ONLY, MIXED).
	 */
	public void setTabPolicy(String tabPolicy) {
		preferences.put(TAB_POLICY, tabPolicy);
		savePreference();
	}

	/**
	 * Get the column position number of the instruction.
	 *  
	 * @return column position number of the instruction.
	 */
	public int getInstructionPosition() {
		return preferences.getInt(INSTRUCTION_POSITION, INSTRUCTION_POSITION_DEFAULT_VALUE);
	}

	/**
	 * Set the column position number of the instruction.
	 *  
	 * @param column position number of the instruction.
	 */
	public void setInstructionPosition(int position) {
		preferences.putInt(INSTRUCTION_POSITION, position);
		savePreference();
	}

	/**
	 * Get the column position number of the operand.
	 *  
	 * @return column position number of the operand.
	 */
	public int getOperandPosition() {
		return preferences.getInt(OPERAND_POSITION, OPERAND_POSITION_DEFAULT_VALUE);
	}

	/**
	 * Set the column position number of the operand.
	 *  
	 * @param column position number of the operand.
	 */
	public void setOperandPosition(int position) {
		preferences.putInt(OPERAND_POSITION, position);
		savePreference();
	}

	/**
	 * Get the column position number of the comment.
	 *  
	 * @return column position number of the comment.
	 */
	public int getCommentPosition() {
		return preferences.getInt(COMMENT_POSITION, COMMENT_POSITION_DEFAULT_VALUE);
	}

	/**
	 * Set the column position number of the comment.
	 *  
	 * @param column position number of the comment.
	 */
	public void setCommentPosition(int position) {
		preferences.putInt(COMMENT_POSITION, position);
		savePreference();
	}

	/**
	 * Get if comment it at the same column than instruction.
	 *  
	 * @return column position number of the instruction.
	 */
	public boolean getCommentLineAtInstructionPosition() {
		return preferences.getBoolean(COMMENT_LINE_AT_INSTRUCTION_LEVEL, false);
	}

	/**
	 * Get set comment line at the same column than instruction.
	 *  
	 * @return column line position number of the instruction.
	 */
	public void setCommentLineAtInstructionPosition(boolean state) {
		preferences.putBoolean(COMMENT_LINE_AT_INSTRUCTION_LEVEL, state);
		savePreference();
	}
	
	/**
	 * check preference for allow folding.
	 *  
	 * @return <b>true</b> folding is allow, <b>false</b> otherwise.
	 */
	public boolean getEnableFolding( ) {
		return preferences.getBoolean(ENABLE_FOLDING, ENABLE_FOLDING_DEFAULT_VALUE);
	}

	/**
	 * Set preference for allow folding.
	 *  
	 * @param state <b>true</b> folding is allow, <b>false</b> otherwise.
	 */
	public void setEnableFolding(boolean state ) {
		preferences.putBoolean(ENABLE_FOLDING,state);
		savePreference();
	}
	
	/**
	 * check preference for allow comment folding.
	 *  
	 * @return <b>true</b> comment folding is allow, <b>false</b> otherwise.
	 */
	public boolean getCommentFolding( ) {
		return preferences.getBoolean(COMMENT_FOLDING_A_INIT, COMMENT_FOLDING_A_INIT_DEFAULT_VALUE);
	}

	/**
	 * Set preference for allow comment folding.
	 *  
	 * @param state <b>true</b> comment folding is allow, <b>false</b> otherwise.
	 */
	public void setCommentFolding(boolean state ) {
		preferences.putBoolean(COMMENT_FOLDING_A_INIT,state);
		savePreference();
	}
	
	/**
	 * check preference for allow macro folding.
	 *  
	 * @return <b>true</b> macro folding is allow, <b>false</b> otherwise.
	 */
	public boolean getMacroFolding( ) {
		return preferences.getBoolean(MACRO_FOLDING_A_INIT, MACRO_FOLDING_A_INIT_DEFAULT_VALUE);
	}

	/**
	 * Set preference for allow macro folding.
	 *  
	 * @param state <b>true</b> macro folding is allow, <b>false</b> otherwise.
	 */
	public void setMacroFolding(boolean state ) {
		preferences.putBoolean(MACRO_FOLDING_A_INIT,state);
		savePreference();
	}
	
	/** 
	 * Return the collection of macro instructions defined in the preferences.
	 * 
	 * @return collection of macro instructions defined in the preferences
	 */
	public Map<String, MacroInstructionData> getMacroInstructionPreferences() {
		Map<String, MacroInstructionData> macros = new HashMap<>();

		String preferedMacros = preferences.get(MACRO_INSTRUCTION_KEY, DEFAULT_MACRO_INSTRUCTION);
		String[] macroDescriptions = preferedMacros.split(MACRO_SEPARATOR);
		
		for (String macroDescription : macroDescriptions) {
			String[] fields = macroDescription.split(MACRO_FIELD_SEPARATOR);
			if (fields.length == 5) {
				
				MacroInstructionData macroInstructionData = new MacroInstructionData();
				String macroName = fields[MACRO_INSTRUCTION_NAME];
				macroInstructionData.setMacroInstructionName(macroName);
				macroInstructionData.setEquivalentInstructionName(fields[MACRO_EQUIVALENT_NAME]);
				macroInstructionData.setEquivalentOperand(fields[MACRO_EQUIVALENT_OPERAND_STRING]);
				
				String strOpcode = fields[MACRO_EQUIVALENT_OPCODE];
				String[] strOpcodes = strOpcode.split(",");
				byte[] opcodes = new byte[strOpcodes.length];
				for (int i=0; i<strOpcodes.length; i++ ) {
					opcodes[i] = (byte) (Integer.parseInt(strOpcodes[i]) & 0xFF);
				}
				macroInstructionData.setOpcode(opcodes);
				
				String strOperand = fields[MACRO_EQUIVALENT_OPERAND];
				String[] strOperands = strOperand.split(",");
				byte[] operands = new byte[strOperands.length];
				for (int i=0; i<strOperands.length; i++ ) {
					operands[i] = (byte) (Integer.parseInt(strOperands[i]) & 0xFF);
				}
				macroInstructionData.setOperand(operands);

				macros.put(macroName, macroInstructionData);
				
			} else {
				logger.log(Level.SEVERE, "Bad format for Macro instruction description : {0}", macroDescription);
			}
		}
		
		return macros;
	}

	/**
	 * Save macro instructions in the preference store.
	 * 
	 * @param macros Collection of macro instructions to save
	 */
	public void setMacroInstructionPreferences(Map<String, MacroInstructionData> macros) {
		StringBuilder strBuilder = new StringBuilder();
		for (Entry<String, MacroInstructionData> entry : macros.entrySet()) {
			if (!strBuilder.isEmpty()) {
				strBuilder.append(MACRO_SEPARATOR);
			}
			
			strBuilder.append(entry.getKey() + MACRO_FIELD_SEPARATOR);
			strBuilder.append(entry.getValue().getEquivalentInstructionName() + MACRO_FIELD_SEPARATOR);
			strBuilder.append(entry.getValue().getEquivalenoperand() + MACRO_FIELD_SEPARATOR);
			
			StringBuilder opcodeBuilder = new StringBuilder("");
//			for (byte opcode : entry.getValue().getOpcode()) {
//				if (!opcodeBuilder.isEmpty()) {
//					opcodeBuilder.append(",");
//				}
//				opcodeBuilder.append(String.format("%0x2X", opcode&0xFF));
//			}
			strBuilder.append(opcodeBuilder.toString() + MACRO_FIELD_SEPARATOR);
			
			StringBuilder operandBuilder = new StringBuilder("");
//			for (byte operand : entry.getValue().getOperand()) {
//				if (!operandBuilder.isEmpty()) {
//					operandBuilder.append(",");
//				}
//				operandBuilder.append(String.format("%0x2X", operand&0xFF));
//			}
			strBuilder.append(operandBuilder.toString());
		}
		
		System.out.println("BPY: Put macros = " + strBuilder.toString());
		preferences.put(MACRO_INSTRUCTION_KEY, strBuilder.toString());
	
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
			e.printStackTrace();
		}
	}
}
