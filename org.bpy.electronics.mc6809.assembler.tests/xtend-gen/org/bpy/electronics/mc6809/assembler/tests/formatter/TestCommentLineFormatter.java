package org.bpy.electronics.mc6809.assembler.tests.formatter;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestCommentLineFormatter extends AbstractTestFormatter {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ISerializer _iSerializer;

  @Test
  public void testFormatterSpaceOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("; test");
      _builder.newLine();
      final String test = _builder.toString();
      InputOutput.<String>println(test);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("                                                    ");
      _builder_1.append("; test");
      _builder_1.newLine();
      final String expectedResult = _builder_1.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals(expectedResult, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterTabOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.TAB_ONLY);
      this.setCommentPosition(54);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("; test");
      _builder.newLine();
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      _builder_1.append("; test");
      _builder_1.newLine();
      final String expectedResult = _builder_1.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals(expectedResult, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterMixed01() {
    try {
      this.setTabPolicy(PreferenceManager.MIXED);
      this.setCommentPosition(52);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      _builder.append("; test");
      _builder.newLine();
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");
      _builder_1.append("; test");
      _builder_1.newLine();
      final String expectedResult = _builder_1.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals(expectedResult, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
