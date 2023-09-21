package org.bpy.electronics.mc6809.assembler.tests;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestComment {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Test
  public void testComment01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; ---------------------------------------------------------------");
      _builder.newLine();
      _builder.append("; Check for comment");
      _builder.newLine();
      _builder.append("; ---------------------------------------------------------------");
      _builder.newLine();
      _builder.newLine();
      _builder.append("; it is the end");
      _builder.newLine();
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOneMainLine() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; ---------------------------------------------------------------");
      _builder.newLine();
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOneMainLinePlusSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; ---------------------------------------------------------------");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
