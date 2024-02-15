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
public class TestADCAInstructionFormatter extends AbstractTestFormatter {
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
      _builder.append("ADCA #$25 ; Instruction with operand");
      _builder.newLine();
      final String test1 = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("W ADCA #$25 ; Instruction with operand");
      _builder_1.newLine();
      final String test2 = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("W2: ADCA #$25 ; Instruction with operand");
      _builder_2.newLine();
      final String test3 = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("Wait1234: ADCA #$25 ; Instruction with operand");
      _builder_3.newLine();
      final String test4 = _builder_3.toString();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Wait1234: ADCA #$25+$A ; Instruction with operand");
      _builder_4.newLine();
      final String test5 = _builder_4.toString();
      final String result1 = this._iSerializer.serialize(this.parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "         A", result1.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "A        #", result1.substring(12, 22));
      Assert.assertEquals("Check spaces after operand", "#$25              ;", result1.substring(21, 40));
      Assert.assertEquals("Check comment", "; Instruction with operand", result1.substring(39, 65));
      final String result2 = this._iSerializer.serialize(this.parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "W        A", result2.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "A        #", result2.substring(12, 22));
      Assert.assertEquals("Check spaces after operand", "#$25              ;", result2.substring(21, 40));
      Assert.assertEquals("Check comment", "; Instruction with operand", result2.substring(39, 65));
      final String result3 = this._iSerializer.serialize(this.parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "W2:      A", result3.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "A        #", result3.substring(12, 22));
      Assert.assertEquals("Check spaces after operand", "#$25              ;", result3.substring(21, 40));
      Assert.assertEquals("Check comment", "; Instruction with operand", result3.substring(39, 65));
      final String result4 = this._iSerializer.serialize(this.parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Wait1234: A", result4.substring(0, 11));
      Assert.assertEquals("Check spaces after instruction", "A        #", result4.substring(13, 23));
      Assert.assertEquals("Check spaces after operand", "#$25              ;", result4.substring(22, 41));
      Assert.assertEquals("Check comment", "; Instruction with operand", result4.substring(40, 66));
      final String result5 = this._iSerializer.serialize(this.parseHelper.parse(test5), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Wait1234: A", result5.substring(0, 11));
      Assert.assertEquals("Check spaces after instruction", "A        #", result5.substring(13, 23));
      Assert.assertEquals("Check spaces after operand", "#$25+$A          ;", result5.substring(22, 41));
      Assert.assertEquals("Check comment", "; Instruction with operand", result5.substring(40, 65));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterTabOnly() {
    try {
      this.setTabPolicy(PreferenceManager.TAB_ONLY);
      this.setInstructionPosition(10);
      this.setOperandPosition(22);
      this.setCommentPosition(40);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ADCA #$25 ; Instruction with operand");
      _builder.newLine();
      final String test1 = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Z ADCA #$25 ; Instruction with operand");
      _builder_1.newLine();
      final String test2 = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("X2: ADCA #$25 ; Instruction with operand");
      _builder_2.newLine();
      final String test3 = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("X2c:\tADCA #$25\t; Instruction with operand");
      _builder_3.newLine();
      final String test4 = _builder_3.toString();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("X23 ADCA #$25 ; Instruction with operand");
      _builder_4.newLine();
      final String test5 = _builder_4.toString();
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Xai1 ADCA #$25\t; Instruction with operand");
      _builder_5.newLine();
      final String test6 = _builder_5.toString();
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("Xai2: ADCA #$25 ; Instruction with operand");
      _builder_6.newLine();
      final String test7 = _builder_6.toString();
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("Xait3: ADCA #$25 ; Instruction with operand");
      _builder_7.newLine();
      final String test8 = _builder_7.toString();
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("Xait31: ADCA #$25 ; Instruction with operand");
      _builder_8.newLine();
      final String test9 = _builder_8.toString();
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("XXait312: ADCA #$25 ; Instruction with operand");
      _builder_9.newLine();
      final String test10 = _builder_9.toString();
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("Xait4 ADCA 1+2+3+4+5+6+7+8+9+10\t; Instruction with operand");
      _builder_10.newLine();
      final String test11 = _builder_10.toString();
      final String result1 = this._iSerializer.serialize(this.parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "\t\t\tA", result1.substring(0, 4));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result1.substring(6, 11));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result1.substring(10, 20));
      Assert.assertEquals("Check comment", "; Instruction with operand", result1.substring(19, 45));
      final String result2 = this._iSerializer.serialize(this.parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Z\t\t\tA", result2.substring(0, 5));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result2.substring(7, 12));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result2.substring(11, 21));
      Assert.assertEquals("Check comment", "; Instruction with operand", result2.substring(20, 46));
      final String result3 = this._iSerializer.serialize(this.parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X2:\t\tA", result3.substring(0, 6));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result3.substring(8, 13));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result3.substring(12, 22));
      Assert.assertEquals("Check comment", "; Instruction with operand", result3.substring(21, 47));
      final String result4 = this._iSerializer.serialize(this.parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X2c:\t\tA", result4.substring(0, 7));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result4.substring(9, 14));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result4.substring(13, 23));
      Assert.assertEquals("Check comment", "; Instruction with operand", result4.substring(22, 48));
      final String result5 = this._iSerializer.serialize(this.parseHelper.parse(test5), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X23\t\tA", result5.substring(0, 6));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result5.substring(8, 13));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result5.substring(12, 22));
      Assert.assertEquals("Check comment", "; Instruction with operand", result5.substring(21, 47));
      final String result6 = this._iSerializer.serialize(this.parseHelper.parse(test6), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xai1\t\tA", result6.substring(0, 7));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result6.substring(9, 14));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result6.substring(13, 23));
      Assert.assertEquals("Check comment", "; Instruction with operand", result6.substring(22, 48));
      final String result7 = this._iSerializer.serialize(this.parseHelper.parse(test7), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xai2:\t\tA", result7.substring(0, 8));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result7.substring(10, 15));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result7.substring(14, 24));
      Assert.assertEquals("Check comment", "; Instruction with operand", result7.substring(23, 49));
      final String result8 = this._iSerializer.serialize(this.parseHelper.parse(test8), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xait3:\tA", result8.substring(0, 8));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result8.substring(10, 15));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result8.substring(14, 24));
      Assert.assertEquals("Check comment", "; Instruction with operand", result8.substring(23, 49));
      final String result9 = this._iSerializer.serialize(this.parseHelper.parse(test9), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xait31:\tA", result9.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result9.substring(11, 16));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result9.substring(15, 25));
      Assert.assertEquals("Check comment", "; Instruction with operand", result9.substring(24, 50));
      final String result10 = this._iSerializer.serialize(this.parseHelper.parse(test10), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "XXait312:\tA", result10.substring(0, 11));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t#", result10.substring(13, 18));
      Assert.assertEquals("Check spaces after operand", "#$25\t\t\t\t\t;", result10.substring(17, 27));
      Assert.assertEquals("Check comment", "; Instruction with operand", result10.substring(26, 52));
      final String result11 = this._iSerializer.serialize(this.parseHelper.parse(test11), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xait4\t\tA", result11.substring(0, 8));
      Assert.assertEquals("Check spaces after instruction", "A\t\t\t1", result11.substring(10, 15));
      Assert.assertEquals("Check spaces after operand", "1+2+3+4+5+6+7+8+9+10\t;", result11.substring(14, 3));
      Assert.assertEquals("Check comment", "; Instruction with operand", result11.substring(26, 52));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterMixed() {
    try {
      this.setTabPolicy(PreferenceManager.MIXED);
      this.setInstructionPosition(11);
      this.setOperandPosition(26);
      this.setCommentPosition(41);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("ADCA #$25 ; Instruction with operand");
      _builder.newLine();
      final String test1 = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Z ADCA #$25 ; Instruction with operand");
      _builder_1.newLine();
      final String test2 = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("X2: ADCA #$25 ; Instruction with operand");
      _builder_2.newLine();
      final String test3 = _builder_2.toString();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("X2c:\tADCA #$25\t; Instruction with operand");
      _builder_3.newLine();
      final String test4 = _builder_3.toString();
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("X23 ADCA #$25 ; Instruction with operand");
      _builder_4.newLine();
      final String test5 = _builder_4.toString();
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("Xai1 ADCA #$25\t; Instruction with operand");
      _builder_5.newLine();
      final String test6 = _builder_5.toString();
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("Xai2: ADCA #$25 ; Instruction with operand");
      _builder_6.newLine();
      final String test7 = _builder_6.toString();
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("Xait3: ADCA #$25 ; Instruction with operand");
      _builder_7.newLine();
      final String test8 = _builder_7.toString();
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("Xait31: ADCA #$25 ; Instruction with operand");
      _builder_8.newLine();
      final String test9 = _builder_8.toString();
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("XXait312: ADCA #$25 ; Instruction with operand");
      _builder_9.newLine();
      final String test10 = _builder_9.toString();
      final String result1 = this._iSerializer.serialize(this.parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "\t\t\t A", result1.substring(0, 5));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result1.substring(4, 18));
      Assert.assertEquals("Check comment", "; Instruction with operand", result1.substring(17, 46));
      final String result2 = this._iSerializer.serialize(this.parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Z\t\t\t A", result2.substring(0, 6));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result2.substring(5, 19));
      Assert.assertEquals("Check comment", "; Instruction with operand", result2.substring(18, 47));
      final String result3 = this._iSerializer.serialize(this.parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X2:\t\t A", result3.substring(0, 7));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result3.substring(6, 20));
      Assert.assertEquals("Check comment", "; Instruction with operand", result3.substring(19, 48));
      final String result4 = this._iSerializer.serialize(this.parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X2c:\t\t A", result4.substring(0, 8));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result4.substring(7, 21));
      Assert.assertEquals("Check comment", "; Instruction with operand", result4.substring(20, 49));
      final String result5 = this._iSerializer.serialize(this.parseHelper.parse(test5), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "X23\t\t A", result5.substring(0, 7));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result5.substring(6, 20));
      Assert.assertEquals("Check comment", "; Instruction with operand", result5.substring(19, 48));
      final String result6 = this._iSerializer.serialize(this.parseHelper.parse(test6), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xai1\t\t A", result6.substring(0, 8));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result6.substring(7, 21));
      Assert.assertEquals("Check comment", "; Instruction with operand", result6.substring(20, 49));
      final String result7 = this._iSerializer.serialize(this.parseHelper.parse(test7), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xai2:\t\t A", result7.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result7.substring(8, 22));
      Assert.assertEquals("Check comment", "; Instruction with operand", result7.substring(21, 50));
      final String result8 = this._iSerializer.serialize(this.parseHelper.parse(test8), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xait3:\t A", result8.substring(0, 9));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result8.substring(8, 22));
      Assert.assertEquals("Check comment", "; Instruction with operand", result8.substring(21, 50));
      final String result9 = this._iSerializer.serialize(this.parseHelper.parse(test9), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "Xait31:\t A", result9.substring(0, 10));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result9.substring(9, 23));
      Assert.assertEquals("Check comment", "; Instruction with operand", result9.substring(22, 51));
      final String result10 = this._iSerializer.serialize(this.parseHelper.parse(test10), SaveOptions.newBuilder().format().getOptions());
      Assert.assertEquals("Check spaces before instruction", "XXait312: A", result10.substring(0, 11));
      Assert.assertEquals("Check spaces after instruction", "ADCA #$25\t\t\t\t\t\t\t\t\t ;", result10.substring(10, 24));
      Assert.assertEquals("Check comment", "; Instruction with operand", result10.substring(23, 52));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
