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
import java.util.List;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
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
public class TestFcbDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check FCB directive with a simple value
   */
  @Test
  public void testFcbWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FCB    12 ");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only one value defined", 1, values.size());
      Assert.assertEquals("First value must be set to 12", 12, (values.get(0)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with two values
   */
  @Test
  public void testFcbWithTwoValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FCB    $FF,\'A ");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only two value defined", 2, values.size());
      Assert.assertEquals("Value 1 must be set to 255", 255, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 65", 65, (values.get(1)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with three values
   */
  @Test
  public void testFcbWithThreeValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FCB    1,0,3 ");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with three values
   */
  @Test
  public void testFcbWithThreeValuesWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FCB    1,0,3      ; Set 1,0,3");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with three values
   */
  @Test
  public void testFcbWithThreeValuesWithCommentAndLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("FcbL       FCB    1,0,3      ; Set 1,0,3");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertEquals("Label must be equald to ", "FcbL", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with three values
   */
  @Test
  public void testFcbWithThreeValuesWithLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("FcbL       FCB    1,0,3      ");
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
      Assert.assertTrue("Must be an FCB directive line", (_directive instanceof FcbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final FcbDirective fcbDirective = ((FcbDirective) _directive_1);
      Assert.assertEquals("Label must be equals to FcbL", "FcbL", CommandUtil.getLabel(fcbDirective));
      final List<Integer> values = ExpressionParser.parse(fcbDirective);
      Assert.assertEquals("Only three value defined", 3, values.size());
      Assert.assertEquals("Value 1 must be set to 1", 1, (values.get(0)).intValue());
      Assert.assertEquals("Value 2 must be set to 0", 0, (values.get(1)).intValue());
      Assert.assertEquals("Value 3 must be set to 3", 3, (values.get(2)).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with a limit negative value
   */
  @Test
  public void testFCBWithLimitNegativeValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FCB    10,-127,128,40 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FCB directive with a limit positive value
   */
  @Test
  public void testFCBWithLimitPositiveValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1       FCB    10,127,128,255 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
