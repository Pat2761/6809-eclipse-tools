package org.bpy.electronics.mc6809.assembler.engine.tests.directives;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class OrgDirectiveTest {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void checkSimpleORGDirective() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tORG \t$8000\t\t; Start code at $8000\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      final AssemblerEngine engine = new AssemblerEngine();
      engine.engine(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
