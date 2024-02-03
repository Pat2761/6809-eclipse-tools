package org.bpy.electronics.mc6809.assembler.tests.formatter.instructions;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.tests.formatter.AbstractTestFormatter;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestAbxInstructionFormatter extends AbstractTestFormatter {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ISerializer _iSerializer;

  @Test
  public void testFormatterSpaceOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      this.setInstructionPosition(10);
      this.setOperandPosition(22);
      this.setCommentPosition(40);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ABX  ; comment");
      _builder.newLine();
      final String test = _builder.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "         ", result.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "ABX                          ", result.substring(10, 39));
      Assert.assertEquals("Check comment", "; comment", result.substring(40, 49));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterSpaceOnly02() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      this.setInstructionPosition(10);
      this.setOperandPosition(22);
      this.setCommentPosition(40);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label ABX  ; comment");
      _builder.newLine();
      final String test = _builder.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Label    ", result.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "ABX                          ", result.substring(10, 39));
      Assert.assertEquals("Check comment", "; comment", result.substring(40, 49));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterSpaceOnly03() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      this.setInstructionPosition(10);
      this.setOperandPosition(22);
      this.setCommentPosition(40);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label: ABX  ; comment");
      _builder.newLine();
      final String test = _builder.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Label:   ", result.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "ABX                          ", result.substring(10, 39));
      Assert.assertEquals("Check comment", "; comment", result.substring(40, 49));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterTabOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.TAB_ONLY);
      this.setTabSize(3);
      this.setInstructionPosition(10);
      this.setOperandPosition(25);
      this.setCommentPosition(49);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ABX  ; comment");
      _builder.newLine();
      final String test = _builder.toString();
      final String result = this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "\t\t\tA", result.substring(0, 4));
      Assert.assertEquals("Check spaces after instruction", "ABX\t\t\t\t\t\t\t\t\t\t\t\t;", result.substring(3, 19));
      Assert.assertEquals("Check comment", "; comment", result.substring(19, 25));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
