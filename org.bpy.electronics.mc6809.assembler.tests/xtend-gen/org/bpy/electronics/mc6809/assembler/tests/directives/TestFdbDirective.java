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
package org.bpy.electronics.mc6809.assembler.tests.directives;

import com.google.inject.Inject;
import java.util.List;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
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
public class TestFdbDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check FDB directive with a simple value
   */
  @Test
  public void testFdbWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FDB    1234 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FDB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only one value defined", 1, values.size());
      Assert.assertEquals("First value must be set to 1234", 1234, (values.get(0)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with two values
   */
  @Test
  public void testFDBWithTwoValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FDB    $FF,125+4000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FDB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only two value defined", 2, values.size());
      Assert.assertEquals("Value 1 must be set to 255", 255, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 4125", 4125, (values.get(1)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with three values
   */
  @Test
  public void testFdbWithThreeValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FDB    1,0,3 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FDB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with three values
   */
  @Test
  public void testFdbWithThreeValuesWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FDB    1,0,3      ; Set 1,0,3");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FDB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with three values
   */
  @Test
  public void testRmbWithThreeValuesWithCommentAndLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("FcbL       FDB    1,0,3      ; Set 1,0,3");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertEquals("Label must be equal to ", "FcbL", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with three values
   */
  @Test
  public void testFdbWithThreeValuesWithLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("FcbL       FDB    1,0,3      ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an FDB directive line", (_directive instanceof FdbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FdbDirective fdbDirective = ((FdbDirective) _directive_1);
      Assert.assertEquals("Label must be equals to FcbL", "FcbL", CommandUtil.getLabel(fdbDirective));
      final List<Integer> values = ExpressionParser.parse(fdbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with a bad negative value
   */
  @Test
  public void testFDBWithBadNegativeValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FDB    10,0,-32769,40 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getFdbDirective(), DirectiveValidator.INVALID_RANGE, "FDB value can\'t lower than -32768 at location 3");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with a limit negative value
   */
  @Test
  public void testFCBWithLimitNegativeValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FDB    10,-32768,128,40 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with a bad positive value
   */
  @Test
  public void testFDBWithBadPositiveValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FDB    65536,0,128,40 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getFdbDirective(), DirectiveValidator.INVALID_RANGE, "FDB value maximum value is 65535 at location 1");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FDB directive with a limit positive value
   */
  @Test
  public void testFDBWithLimitPositiveValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FDB    10,127,128,65535 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
