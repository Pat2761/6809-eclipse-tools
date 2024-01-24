package org.bpy.electronics.mc6809.assembler.tests.formatter;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;

@SuppressWarnings("all")
public class AbstractTestFormatter {
  public void setTabPolicy(final String policy) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.TAB_POLICY, policy);
  }

  public void setCommentPosition(final int position) {
    PreferenceManager.getInstance().setPreferenceValue(PreferenceManager.COMMENT_POSITION, position);
  }
}
