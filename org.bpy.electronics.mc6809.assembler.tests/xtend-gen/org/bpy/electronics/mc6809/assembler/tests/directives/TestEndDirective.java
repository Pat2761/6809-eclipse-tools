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
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
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
public class TestEndDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check END directive with a simple decimal value
   */
  @Test
  public void testOrgWithHexaDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("END    1000 ");
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
      Assert.assertTrue("Must be an End directive line", (_directive instanceof EndDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EndDirective endDirective = ((EndDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective));
      Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ORG directive with no value , return 0
   */
  @Test
  public void testEndWithNoValueValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("END");
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
      Assert.assertTrue("Must be an END directive line", (_directive instanceof EndDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final EndDirective endDirective = ((EndDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective));
      Assert.assertEquals("Operand must be equals to 0", 0, ExpressionParser.parse(endDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ORG directive with a simple identifier defined by an anothoer EQU
   */
  @Test
  public void testWithIdentifierValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Start       EQU    $4000         ; Starting code");
      _builder.newLine();
      _builder.newLine();
      _builder.append("; Strating code section");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("ORG    Start         ; Start program at $4000");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("END    Start*2");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line0 = result.getSourceLines().get(1);
      EObject _lineContent = line0.getLineContent();
      final DirectiveLine directiveLine0 = ((DirectiveLine) _lineContent);
      EObject _directive = directiveLine0.getDirective();
      final EquDirective equDirective0 = ((EquDirective) _directive);
      ExpressionParser.parse(equDirective0);
      final SourceLine line1 = result.getSourceLines().get(5);
      EObject _lineContent_1 = line1.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent_1 instanceof DirectiveLine));
      EObject _lineContent_2 = line1.getLineContent();
      final DirectiveLine directiveLine1 = ((DirectiveLine) _lineContent_2);
      EObject _directive_1 = directiveLine1.getDirective();
      Assert.assertTrue("Must be an END directive line", (_directive_1 instanceof EndDirective));
      EObject _directive_2 = directiveLine1.getDirective();
      final EndDirective endDirective = ((EndDirective) _directive_2);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective));
      Assert.assertEquals("Operand must be equals to $8000", 0x8000, ExpressionParser.parse(endDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check END directive with the lowest limit
   */
  @Test
  public void testWithLowestValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("END    0 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check END directive with the upper limit
   */
  @Test
  public void testWithUpperLimitValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("END    $FFFF ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ORG directive with the too high limit
   */
  @Test
  public void testWithToHighLimitValue() {
  }

  /**
   * Check ORG directive with the too high limit
   */
  @Test
  public void testEndUnexpectedLabel() {
  }
}
