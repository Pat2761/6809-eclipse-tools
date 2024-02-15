package org.bpy.electronics.mc6809.rcp.tests;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPreferences {

	@Test
	public void testPreferencesValues01() {
		PreferenceManager preferenceManager = PreferenceManager.getInstance();
		preferenceManager.resetPreferences();
		
		Assert.assertNotNull("Check existence of preferences", preferenceManager);
		Assert.assertEquals("Check Tab policy", PreferenceManager.SPACE_ONLY, preferenceManager.getStringPreferenceValue(PreferenceManager.TAB_POLICY));
		Assert.assertEquals("Check tab size", PreferenceManager.TAB_SIZE_DEFAULT_VALUE, preferenceManager.getIntPreferenceValue(PreferenceManager.TAB_SIZE));
		Assert.assertEquals("Check instruction size", PreferenceManager.INSTRUCTION_POSITION_DEFAULT_VALUE, preferenceManager.getIntPreferenceValue(PreferenceManager.INSTRUCTION_POSITION));
		Assert.assertEquals("Check operand size", PreferenceManager.OPERAND_POSITION_DEFAULT_VALUE, preferenceManager.getIntPreferenceValue(PreferenceManager.OPERAND_POSITION));
	}
	
	@Test
	public void testPreferencesValues02() {
		PreferenceManager preferenceManager = PreferenceManager.getInstance();

		preferenceManager.setPreferenceValue(PreferenceManager.TAB_POLICY, PreferenceManager.TAB_ONLY );
		preferenceManager.setPreferenceValue(PreferenceManager.TAB_SIZE, 4 );
		preferenceManager.setPreferenceValue(PreferenceManager.INSTRUCTION_POSITION, 10 );
		preferenceManager.setPreferenceValue(PreferenceManager.OPERAND_POSITION, 12 );

		Assert.assertEquals("Check Tab policy", PreferenceManager.TAB_ONLY, preferenceManager.getStringPreferenceValue(PreferenceManager.TAB_POLICY));
		Assert.assertEquals("Check Tab size", 4, preferenceManager.getIntPreferenceValue(PreferenceManager.TAB_SIZE));
		Assert.assertEquals("Check Instruction size", 10, preferenceManager.getIntPreferenceValue(PreferenceManager.INSTRUCTION_POSITION));
		Assert.assertEquals("Check Operand size", 12, preferenceManager.getIntPreferenceValue(PreferenceManager.OPERAND_POSITION));
	}
}
