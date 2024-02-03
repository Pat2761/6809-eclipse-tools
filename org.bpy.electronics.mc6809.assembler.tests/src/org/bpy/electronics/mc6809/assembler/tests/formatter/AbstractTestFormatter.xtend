package org.bpy.electronics.mc6809.assembler.tests.formatter

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager

abstract class AbstractTestFormatter {
	
	def void setTabPolicy(String policy){
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::TAB_POLICY, policy)
	}

	def void setInstructionPosition(int position){
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::INSTRUCTION_POSITION, position)
	}
	
	def void setOperandPosition(int position){
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::OPERAND_POSITION, position)
	}
	
	def void setCommentPosition(int position) {
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::COMMENT_POSITION, position)
	}

	def void setTabSize(int size) {
		PreferenceManager.instance.setPreferenceValue(PreferenceManager::TAB_SIZE, size)
	}
}