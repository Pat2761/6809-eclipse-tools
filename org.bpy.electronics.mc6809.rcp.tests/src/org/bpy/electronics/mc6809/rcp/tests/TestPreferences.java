package org.bpy.electronics.mc6809.rcp.tests;

import org.bpy.electronics.mc6809.rcp.preferences.PreferenceManager;
import org.junit.Assert;
import org.junit.Test;

public class TestPreferences {

	@Test
	public void testInitialeValues() {
		PreferenceManager preferenceManager = PreferenceManager.getInstance();
	
		Assert.assertNotNull("Check existence of preferences", preferenceManager);
		Assert.assertEquals("Check Tab policy", PreferenceManager.SPACE_ONLY, preferenceManager.getStringPreferenceValue(PreferenceManager.TAB_POLICY));
		Assert.assertEquals("Check tab size", 3, preferenceManager.getIntPreferenceValue(PreferenceManager.TAB_SIZE));
		Assert.assertEquals("Check label size", 15, preferenceManager.getIntPreferenceValue(PreferenceManager.LABEL_SIZE));
		Assert.assertEquals("Check instruction size", 6, preferenceManager.getIntPreferenceValue(PreferenceManager.INSTRUCTION_SIZE));
		Assert.assertEquals("Check operand size", 20, preferenceManager.getIntPreferenceValue(PreferenceManager.OPERAND_SIZE));
	}
}
