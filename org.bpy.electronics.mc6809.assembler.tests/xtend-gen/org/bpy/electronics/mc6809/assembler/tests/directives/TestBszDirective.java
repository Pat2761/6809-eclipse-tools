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
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
public class TestBszDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper h;

  /**
   * Check BSZ directive with a simple decimal value
   */
  @Test
  public void testBSZWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("BSZ    100 ");
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
      Assert.assertTrue("Must be an BSZ directive line", (_directive instanceof BszDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ZMB directive with a simple decimal value
   */
  @Test
  public void testZMBWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ZMB    100 ");
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
      Assert.assertTrue("Must be an BSZ directive line", (_directive instanceof BszDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive with a simple identifier defined by an another EQU
   */
  @Test
  public void testBSZWithIdentifierValue() {
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
      _builder.append("BSZ    Start*2");
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
      Assert.assertTrue("Must be an BSZ directive line", (_directive_1 instanceof BszDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive with a negative value
   */
  @Test
  public void testBSZWithNegativeValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t         ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("Label1       BSZ    -1 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertError(result, AssemblerPackage.eINSTANCE.getBszDirective(), DirectiveValidator.INVALID_RANGE, "BSZ value can\'t be negative");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive with the lowest limit
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
      _builder.append("BSZ    1 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive with 0 value
   */
  @Test
  public void testWithNothingValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("BSZ    0 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertWarning(result, AssemblerPackage.eINSTANCE.getBszDirective(), DirectiveValidator.INVALID_RANGE, "Reserving no bytes makes no sense");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive with missing label
   */
  @Test
  public void testBszMissingLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append(" \t\t       ");
      _builder.append("BSZ    10 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertWarning(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL, "No label defined for BSZ directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ duplicate label
   */
  @Test
  public void testBszDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$8000 \t; With value");
      _builder.newLine();
      _builder.append("MyBsz\t\t   \tBSZ  \t10\t           ");
      _builder.newLine();
      _builder.append("MyBsz\t       \tBSZ    \t10 \t\t; A comment for BSZ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), 
        AssemblerEngine.DUPLICATE_LABEL, 
        "Label MyBsz is already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ directive behavior
   */
  @Test
  public void testBszBehavior() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           ");
      _builder.append("ORG    $8000 \t; With value");
      _builder.newLine();
      _builder.append("MyBsz\t       BSZ    10 \t\t; A comment for BSZ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("PC value must be 800A", 0x800A, engine.getCurrentPcValue());
      final AbstractAssemblyLine line = engine.getAssembledLine(2);
      final AssembledBszDirectiveLine bszLine = ((AssembledBszDirectiveLine) line);
      final int[] values = bszLine.getValues();
      for (final int value : values) {
        Assert.assertEquals("Reserved bytes must be equals to 0", 0, value);
      }
      Assert.assertEquals("Check line number", 3, bszLine.getLineNumber());
      Assert.assertEquals("Check label", "MyBsz", bszLine.getLabel());
      Assert.assertEquals("Check comment", "; A comment for BSZ", bszLine.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ Sorek directive
   */
  @Test
  public void testBszSorek() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000   \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tBSZ    \t$10 \t\t; Toto vaudra $2000");
      _builder.newLine();
      _builder.append("TITI\t\t\tEQU\t\t* \t\t\t; TITI vaudra $2010");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("; Et en mémoire entre $2000 et $2010, il y aura des 0");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ with error in expression
   */
  @Test
  public void testBszWithErrorExpression() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tBSZ    \t10*Deux \t\t; Toto vaudra $2000");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t\t");
      _builder.append("; Et en mémoire entre $2000 et $2010, il y aura des 0");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this.h.assertError(result, AssemblerPackage.eINSTANCE.getBszDirective(), ExpressionParser.EXPRESSION_ERROR, "Can\'t find Deux definition");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check BSZ with binary error syntax
   */
  @Test
  public void testBszWithBinaryErrorSyntax() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tBSZ    \t%01111211 \t\t; Toto vaudra $2000");
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
   * Check BSZ with octal error syntax
   */
  @Test
  public void testBszWithOctalErrorSyntax() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t           \t");
      _builder.append("ORG    \t$2000  \t\t \t; With value");
      _builder.newLine();
      _builder.append("TOTO\t       \tBSZ    \t@128\t \t\t; Toto vaudra $2000");
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
