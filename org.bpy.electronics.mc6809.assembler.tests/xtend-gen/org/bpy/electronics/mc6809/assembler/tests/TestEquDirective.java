/**
 * European Scoring Tool For Baseball
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bpy.electronics.mc6809.assembler.tests;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
public class TestEquDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  /**
   * Check EQU directive with a simple decimal value
   */
  @Test
  public void testWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    1234 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 1234", 1234, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithAdditionOfTwoDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    12+24\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 36", 36, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithAdditionOfThreeDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    12+24+5\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 41", 41, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithAdditionOfTwoDecimalValueAndMultiplication() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    (12+24)*5\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 180", 180, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithHexadecimalvalue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    $FF00\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 65280", 65280, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithAdditionHexadecimalvalue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    $A7+$25\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 204", 204, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with an addition of a decimal values and a hexadecimal value
   */
  @Test
  public void testWithMultiplicationHexadecimalvalue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    125*$A\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 1250", 1250, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a binary value
   */
  @Test
  public void testWithABinaryValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    %10010011\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      Assert.assertEquals("", 1, 1);
      EquDirective _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EquDirective _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 147", 147, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
