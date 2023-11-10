/**
 * MC6809 Toolkit
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
package org.bpy.electronics.mc6809.assembler.tests.directives;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestEquDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a simple negative decimal value
   */
  @Test
  public void testWithNegativeDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    -25 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
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
      _builder.append("Label1       EQU   %10010011\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a simple octal value
   */
  @Test
  public void testWithOctalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    @1234 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a simple identifier defined by an anothoer EQU
   */
  @Test
  public void testWithIdentifierValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Five       EQU    5         ; Five = 5");
      _builder.newLine();
      _builder.append("Result     EQU    Five*2    ; so 10");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line0 = result.getSourceLines().get(0);
      EObject _lineContent = line0.getLineContent();
      final DirectiveLine directiveLine0 = ((DirectiveLine) _lineContent);
      EObject _directive = directiveLine0.getDirective();
      final EquDirective equDirective0 = ((EquDirective) _directive);
      ExpressionParser.parse(equDirective0);
      final SourceLine line1 = result.getSourceLines().get(1);
      EObject _lineContent_1 = line1.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent_1 instanceof DirectiveLine));
      EObject _lineContent_2 = line1.getLineContent();
      final DirectiveLine directiveLine1 = ((DirectiveLine) _lineContent_2);
      EObject _directive_1 = directiveLine1.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive_1 instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a simple octal value
   */
  @Test
  public void testWithCharacterValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    \'A ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a relative value to PC
   */
  @Test
  public void testEQURelativeToPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("             ");
      _builder.append("ORG    $2000");
      _builder.newLine();
      _builder.append("Label1       EQU    * ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(1);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a relative value to PC with expression
   */
  @Test
  public void testEQURelativeToPCWithEpxression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("             ");
      _builder.append("ORG    $2000");
      _builder.newLine();
      _builder.append("Label1       EQU    *-3 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(1);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEQUWithSamples() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    65535 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a value which is upper to 65535
   */
  @Test
  public void testWithHighestLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    65535 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a value which is upper to 65535
   */
  @Test
  public void testWithTooHighValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    65536 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(), DirectiveValidator.INVALID_RANGE, "EQU value can\'t exceed 65535 (16 bits value)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a value which is lower than -32768
   */
  @Test
  public void testWithTooLowValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    -32769 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(), DirectiveValidator.INVALID_RANGE, "EQU value can\'t be lower than -32768 (16 bits value)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a value which is lower than -32768
   */
  @Test
  public void testWithLowestNegativeValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    -32768 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EQU directive with a missing label
   */
  @Test
  public void testWithMissingLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test EQU without label");
      _builder.newLine();
      _builder.append(" \t    ");
      _builder.append("EQU    100 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL, "No label defined for EQU directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithSubstractionOfTwoDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    32-15\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 17", 17, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithModuloOfTwoDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    46%5\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 1", 1, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithLogicalAndOfTwoHexaDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    $FFFF&&$FF\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 255", 255, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithLogicalOrOfTwoHexaDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    $FF00||$FF\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 65535", 65535, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithLogicalXOrOfTwoBinaryValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    %01010101^%00001111\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 90", 90, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithNegateOfHexaDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    !$AA\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 65365", 65365, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithLeftShiftValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    20<<2\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 80", 80, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testWithRightShiftValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label1       EQU    88>>2\t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an EQU directive line", (_directive instanceof EquDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EquDirective equDirective = ((EquDirective) _directive_1);
      Assert.assertEquals("Label must be set to Label1", "Label1", CommandUtil.getLabel(equDirective));
      Assert.assertEquals("Operand must be equals to 22", 22, ExpressionParser.parse(equDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSorek() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("START\t\t\tORG\t\t\t$2000");
      _builder.newLine();
      _builder.append("DEBUT\t\t\tEQU\t\t\tSTART");
      _builder.newLine();
      _builder.append("COMPT \t\t\tEQU \t\t$05 \t\t\t\t\t; donnée 8 bits");
      _builder.newLine();
      _builder.append("ADRDEB\t\t\tEQU \t\t1000 \t\t\t\t\t; donnée 16 bits");
      _builder.newLine();
      _builder.append("FIN \t\t\tEQU \t\tDEBUT+$60 \t\t\t\t; ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("VALHEX \t\t\tEQU \t\t$8000 \t\t\t\t\t; VALHEX aura pour valeur $8000");
      _builder.newLine();
      _builder.append(";DEBBIN \t\tEQU \t\t-$0200 \t\t\t\t\t; ==> negative hexa decimal not managed");
      _builder.newLine();
      _builder.append("FINATT \t\t\tEQU \t\tNOMVAR+30 \t\t\t\t;");
      _builder.newLine();
      _builder.append("FINTIT \t\t\tEQU \t\tNOMVAR-VARFIN \t\t\t;");
      _builder.newLine();
      _builder.append("TOUCHA \t\t\tEQU \t\t\'A \t\t\t\t\t\t; assigne $0041 au symbole TOUCHA");
      _builder.newLine();
      _builder.append("FONCTA \t\t\tEQU \t\tTOUCHA+%10000000 \t\t; assigne $00C1 au symbole FONCTA");
      _builder.newLine();
      _builder.newLine();
      _builder.append("TOTO \t\t\tEQU \t\t* \t\t\t\t\t\t; TOTO aura pour valeur $2000, car on affecte la");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; valeur courante de l\'adresse à TOTO");
      _builder.newLine();
      _builder.append("TITI \t\t\tEQU \t\t*-3 \t\t\t\t\t; TITI aura pour valeurs $1FFD ($2000-3)");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
