package org.bpy.electronics.mc6809.assembler.tests.formatter;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractTestFormatter {

	@Before
	public void setJunitPreferences() {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, true);
	}
	
	@After 
	public void unsetJunitPreferences() {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, false);
	}
	
	protected void setTabPolicy(String policy){
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_POLICY, policy);
	}

	protected void setInstructionPosition(int position){
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.INSTRUCTION_POSITION, position);
	}
	
	protected void setOperandPosition(int position){
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.OPERAND_POSITION, position);
	}
	
	protected void setCommentPosition(int position) {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_POSITION, position);
	}

	protected void setTabSize(int size) {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_SIZE, size);
	}

	protected void setCommentLineAtInstructionLevel(boolean state) {
		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_LINE_AT_INSTRUCTION_LEVEL, state);
	}
}
