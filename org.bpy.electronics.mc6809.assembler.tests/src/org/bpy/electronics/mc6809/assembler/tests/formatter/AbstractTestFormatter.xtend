package org.bpy.electronics.mc6809.assembler.tests.formatter

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager

class AbstractTestFormatter {
	
	def void setTabPolicy(String policy){
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::TAB_POLICY, policy)
	}
	
	def void setCommentPosition(int position) {
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::COMMENT_POSITION, position)
	}
}