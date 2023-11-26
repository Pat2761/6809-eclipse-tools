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
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
public class TestFillDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check FILL directive with a simple values
   */
  @Test
  public void testFILLWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("FILL   $80,25 ");
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
      Assert.assertTrue("Must be an FILL directive line", (_directive instanceof FillDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with a simple identifier defined by an another EQU
   */
  @Test
  public void testFILLWithIdentifierValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Start\t\tEQU\t\t$8000");
      _builder.newLine();
      _builder.append("Val1       \tEQU    \t$40            ; Number ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("; Strating code section");
      _builder.newLine();
      _builder.append("           \t");
      _builder.append("ORG    \tStart         ; Start program at $4000");
      _builder.newLine();
      _builder.append("           \t");
      _builder.append("FILL   \tVal1,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line1 = result.getSourceLines().get(6);
      EObject _lineContent = line1.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line1.getLineContent();
      final DirectiveLine directiveLine1 = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine1.getDirective();
      Assert.assertTrue("Must be an FILL directive line", (_directive instanceof FillDirective));
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("PC value must be 800A", 0x800A, engine.getCurrentPcValue());
      final AbstractAssemblyLine line = engine.getAssembledLine(6);
      final AssembledFillDirectiveLine bszLine = ((AssembledFillDirectiveLine) line);
      Assert.assertEquals("Check line number", 7, bszLine.getLineNumber());
      Assert.assertNull("Check label", bszLine.getLabel());
      Assert.assertEquals("Check comment", "; Fill example", bszLine.getComment());
      int[] _values = bszLine.getValues();
      for (final int value : _values) {
        Assert.assertEquals("Reserved bytes must be equals to 64", 64, value);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with duplicate label
   */
  @Test
  public void testFILLWithDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Start\t\tEQU\t\t$8000");
      _builder.newLine();
      _builder.append("Val1       \tEQU    \t$40            ; Number ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("; Strating code section");
      _builder.newLine();
      _builder.append("           \t");
      _builder.append("ORG    \tStart         ; Start program at $4000");
      _builder.newLine();
      _builder.append("Val2       \tBSZ\t\t6\t");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \tVal1,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getDirectiveLine(), 
        AssemblerEngine.DUPLICATE_LABEL, 
        "Label Val2 is already defined");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with Low value limit
   */
  @Test
  public void testFILLWithLowValueLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t-128,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with High value limit
   */
  @Test
  public void testFILLWithHighValueLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t255,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with Low value limit
   */
  @Test
  public void testFILLWithLowBadValueLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t-129,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.Literals.FILL_DIRECTIVE, 
        DirectiveValidator.INVALID_RANGE, 
        "FILL value minimum value is -128");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with High value limit
   */
  @Test
  public void testFILLWithHighBadValueLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t256,10       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.Literals.FILL_DIRECTIVE, 
        DirectiveValidator.INVALID_RANGE, 
        "FILL maximum value to set is 255");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with Low occurrence limit
   */
  @Test
  public void testFILLWithLowOccurrenceLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t10,1       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with High occurrence limit
   */
  @Test
  public void testFILLWithHighOccurrenceLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t127,9       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with Low occurrence limit
   */
  @Test
  public void testFILLWithLowBadOccurrenceLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t45,-1       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.Literals.FILL_DIRECTIVE, 
        DirectiveValidator.INVALID_RANGE, 
        "FILL value occurrence can\'t be negative");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with no occurrence
   */
  @Test
  public void testFILLWithLowNoOccurrenceLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t45,0       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertWarning(result, AssemblerPackage.Literals.FILL_DIRECTIVE, 
        DirectiveValidator.INVALID_RANGE, 
        "FILL occurrence can\'t be null");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check FILL directive with High value limit
   */
  @Test
  public void testFILLWithHighBadOccurrenceLimit() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; Starting assembly file");
      _builder.newLine();
      _builder.append("Val2       \tFILL   \t255,65536       ; Fill example");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.Literals.FILL_DIRECTIVE, 
        DirectiveValidator.INVALID_RANGE, 
        "FILL value maximum value is $FFFF");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
