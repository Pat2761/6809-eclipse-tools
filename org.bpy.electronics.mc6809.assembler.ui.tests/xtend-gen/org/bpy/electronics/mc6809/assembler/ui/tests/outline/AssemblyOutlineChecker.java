package org.bpy.electronics.mc6809.assembler.ui.tests.outline;

import org.bpy.electronics.mc6809.assembler.ui.tests.AssemblerUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractOutlineTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerUiInjectorProvider.class)
@SuppressWarnings("all")
public class AssemblyOutlineChecker extends AbstractOutlineTest {
  @Test
  public void checkMacroDefinition() {
  }
}
