package org.bpy.electronics.mc6809.assembler.tests.formatter;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.junit.After;
import org.junit.Before;

@SuppressWarnings("all")
public abstract class AbstractTestFormatter {
  @Before
  public void setJunitPreferences() {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, true);
  }

  @After
  public void unsetJunitPreferences() {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.JUNIT_PREFERENCE, false);
  }

  public void setTabPolicy(final String policy) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_POLICY, policy);
  }

  public void setInstructionPosition(final int position) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.INSTRUCTION_POSITION, position);
  }

  public void setOperandPosition(final int position) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.OPERAND_POSITION, position);
  }

  public void setCommentPosition(final int position) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_POSITION, position);
  }

  public void setTabSize(final int size) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_SIZE, size);
  }
}
