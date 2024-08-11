package org.bpy.electronics.mc6809.assembler.tests.formatter;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.junit.After;
import org.junit.Before;

public abstract class AbstractTestFormatter {

	@Before
	public void setJunitPreferences() {
///		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, true);
	}
	
	@After 
	public void unsetJunitPreferences() {
//		PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, false);
	}
	
	protected void setTabPolicy(String policy){
		PreferenceManager.getInstance().setTabPolicy(policy);
	}

	protected void setInstructionPosition(int position){
		PreferenceManager.getInstance().setInstructionPosition(position);
	}
	
	protected void setOperandPosition(int position){
		PreferenceManager.getInstance().setOperandPosition(position);
	}
	
	protected void setCommentPosition(int position) {
		PreferenceManager.getInstance().setCommentPosition(position);
	}

	protected void setTabSize(int size) {
		PreferenceManager.getInstance().setEditorTabSize(size);
	}

	protected void setCommentLineAtInstructionLevel(boolean state) {
		PreferenceManager.getInstance().setCommentLineAtInstructionPosition(state);
	}
}
