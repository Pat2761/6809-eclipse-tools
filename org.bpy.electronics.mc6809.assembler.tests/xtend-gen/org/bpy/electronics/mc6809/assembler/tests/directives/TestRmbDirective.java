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
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
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
public class TestRmbDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper h;

  /**
   * Check RMB directive with a simple value
   */
  @Test
  public void testRmbWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("RMB    12 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
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
      Assert.assertTrue("Must be an RMB directive line", (_directive instanceof RmbDirective));
      EObject _directive_1 = directiveLine.getDirective();
      final RmbDirective rmbDirective = ((RmbDirective) _directive_1);
      Assert.assertNull("Label must be null", CommandUtil.getLabel(rmbDirective));
      Assert.assertEquals("Operand must be equals to 12", 12, ExpressionParser.parse(rmbDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive with a simple identifier defined by an another EQU
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
      _builder.append("; Starting code section");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("ORG    Start         ; Start program at $4000");
      _builder.newLine();
      _builder.append("RmbLabel    RMB    Start/2       ; reserve $2000");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
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
      Assert.assertTrue("Must be an RMB directive line", (_directive_1 instanceof RmbDirective));
      EObject _directive_2 = directiveLine1.getDirective();
      final RmbDirective rmbDirective = ((RmbDirective) _directive_2);
      Assert.assertEquals("Label must be RmbLabel", "RmbLabel", CommandUtil.getLabel(rmbDirective));
      Assert.assertEquals("Operand must be equals to $2000", 0x2000, ExpressionParser.parse(rmbDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive with the lowest limit
   */
  @Test
  public void testRMBWithLowestValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("RMB    1 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive with the upper limit
   */
  @Test
  public void testRMBWithUpperLimitValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t   ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("RMB    $FFFF ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive with the too high limit
   */
  @Test
  public void testRMBWithToHighLimitValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("RMB    $FFFF+1 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertError(result, AssemblerPackage.eINSTANCE.getRmbDirective(), DirectiveValidator.INVALID_RANGE, "RMB value maximum value is $FFFF");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive with duplicate Label
   */
  @Test
  public void testFCBWithDuplicateLabels() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("Label1\t     BSZ\t10    ");
      _builder.newLine();
      _builder.append("Label1       RMB    32 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertError(result, 
        AssemblerPackage.eINSTANCE.getDirectiveLine(), 
        AssemblerEngine.DUPLICATE_LABEL, 
        "Label Label1 is already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB directive assembly result
   */
  @Test
  public void testRmbAssemblyResult() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t        \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("Label1       \tRMB    \t32 \t\t; 32 bytes reserved");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledRmbDirectiveLine line = ((AssembledRmbDirectiveLine) _assembledLine);
      Assert.assertEquals("Check Label", "Label1", line.getLabel());
      Assert.assertEquals("Check Comment", "; 32 bytes reserved", line.getComment());
      Assert.assertEquals("Check Impact on PC", 0x8020, engine.getCurrentPcValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB with error in expression
   */
  @Test
  public void testRmbWithErrorExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tRMB    \t10*Deux \t\t; Toto vaudra $2000");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; Et en mémoire entre $2000 et $2010, il y aura des 0");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertIssue(result.eResource(), AssemblerPackage.Literals.RMB_DIRECTIVE, ExpressionParser.EXPRESSION_ERROR, 112, 7, Severity.ERROR, "Can\'t find Deux definition");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB with binary error syntax
   */
  @Test
  public void testRmbWithBinaryErrorSyntax() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tRMB    \t%01111211 \t\t; Toto vaudra $2000");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; Et en mémoire entre $2000 et $2010, il y aura des 0");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertIssue(result.eResource(), AssemblerPackage.Literals.BINARY_VALUE, AssemblerValidator.INVALID_FIGURE, 113, 8, Severity.ERROR, "2 is invalid in binary value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check RMB with octal error syntax
   */
  @Test
  public void testRmbWithOctalErrorSyntax() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tRMB    \t@128\t \t\t; Toto vaudra $2000");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; Et en mémoire entre $2000 et $2010, il y aura des 0");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertIssue(result.eResource(), AssemblerPackage.Literals.OCTAL_VALUE, AssemblerValidator.INVALID_FIGURE, 113, 3, Severity.ERROR, "8 is invalid in octal value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
