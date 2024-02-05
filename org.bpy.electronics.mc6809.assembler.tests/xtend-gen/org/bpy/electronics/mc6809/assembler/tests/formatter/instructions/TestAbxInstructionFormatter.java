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
  public void testFormatterSpaceOnly() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      this.setInstructionPosition(10);
      this.setOperandPosition(22);
      this.setCommentPosition(40);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ABX ; Instruction without operand");
      _builder.newLine();
      final String test1 = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("W ABX ; Instruction without operand");
      _builder_1.newLine();
      final String test2 = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("W2: ABX ; Instruction without operand");
      _builder_2.newLine();
      final String test3 = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Wait1234: ABX ; Instruction without operand");
      _builder_3.newLine();
      final String test4 = _builder_3.toString();
      final String result1 = this._iSerializer.serialize(this.parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "         A", result1.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "ABX                           ;", result1.substring(9, 40));
      Assert.assertEquals("Check comment", "; Instruction without operand", result1.substring(39, 68));
      final String result2 = this._iSerializer.serialize(this.parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "W        A", result2.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "ABX                           ;", result2.substring(9, 40));
      Assert.assertEquals("Check comment", "; Instruction without operand", result1.substring(39, 68));
      final String result3 = this._iSerializer.serialize(this.parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "W2:      A", result3.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "ABX                           ;", result3.substring(9, 40));
      Assert.assertEquals("Check comment", "; Instruction without operand", result1.substring(39, 68));
      final String result4 = this._iSerializer.serialize(this.parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Wait1234: A", result4.substring(0, 11));
      Assert.assertEquals("Check spaces after instruction", "ABX                           ;", result4.substring(10, 41));
      Assert.assertEquals("Check comment", "; Instruction without operand", result4.substring(40, 69));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
