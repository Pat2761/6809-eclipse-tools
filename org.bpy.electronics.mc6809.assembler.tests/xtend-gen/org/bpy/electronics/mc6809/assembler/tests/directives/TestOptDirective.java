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
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledOptDirectiveLine;
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
public class TestOptDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check OPT directive with nothing
   */
  @Test
  public void testOPTEmpty() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    ");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with nothing
   */
  @Test
  public void testOPTEmptyWithoutExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with nothing and comment
   */
  @Test
  public void testOPTEmptyWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    ; All by default");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with one option
   */
  @Test
  public void testOPTWithOneOption() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    CON");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with list of options
   */
  @Test
  public void testOPTWithListOfOptions() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    CON,PAG,NOM,NOE");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with list of options and comment
   */
  @Test
  public void testOPTWithListOfOptionsAndComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    CON,PAG,NOM,NOE   ; Options");
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
      Assert.assertTrue("Must be an OPT directive line", (_directive instanceof OptDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with list duplicate option
   */
  @Test
  public void testOPTWithListOfDuplicateOption() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append(" \t\t   ");
      _builder.append("OPT    CON,PAG,CON,NOE   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.DUPLICATE_OPTION, "Duplicate option CON");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with duplicate label
   */
  @Test
  public void testOPTWithListOfDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("Label\t\tEQU\t\t10\t       ");
      _builder.newLine();
      _builder.append("Label\t   \tOPT    \tCON\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.UNEXPECTED_LABEL, "No label may be set for OPT directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with inconsistency PAG NOP option
   */
  @Test
  public void testOPTWithInconsistencyPAG_NOP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("Label\t\tEQU\t\t10\t       ");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("OPT    \tPAG,NOP\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR, "The OPT directive does not contain at the same time the PAG and NOP options");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with inconsistency CON NOC option
   */
  @Test
  public void testOPTWithInconsistencyCON_NOC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append(" \t\t   \t");
      _builder.append("OPT    \tCON,NOC\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR, "The OPT directive does not contain at the same time the CON and NOC options");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with inconsistency MAC NOM option
   */
  @Test
  public void testOPTWithInconsistencyMAC_NOM() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("OPT    \tMAC,NOM\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR, "The OPT directive does not contain at the same time the MAC and NOM options");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive with inconsistency EXP NOE option
   */
  @Test
  public void testOPTWithInconsistencyEXP_NOE() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("OPT    \tEXP,NOE\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR, "The OPT directive does not contain at the same time the EXP and NOE options");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check Page formatting
   */
  @Test
  public void testOPTPageFormating0() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \t\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check Page formatting
   */
  @Test
  public void testOPTPageFormating1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tPAG\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertTrue("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check Page formatting
   */
  @Test
  public void testOPTPageFormating2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOP\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check print conditionally skipped code
   */
  @Test
  public void testOPTPrintConditionallySkippedCode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tCON\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertTrue("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check print conditionally skipped code
   */
  @Test
  public void testOPTPrintConditionallySkippedCode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOC\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check suppress printing of macro calls
   */
  @Test
  public void testOPTSuppressPrintingOfMacroCalls1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOM\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertTrue("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check suppress printing of macro calls
   */
  @Test
  public void testOPTSuppressPrintingOfMacroCalls2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOC\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check Print macro expansion line
   */
  @Test
  public void testOPTSuppressPrintPrintMacroExpansionLine1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tEXP\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertTrue("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check Print macro expansion line
   */
  @Test
  public void testOPTSuppressPrintPrintMacroExpansionLine2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOE\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      final AbstractAssemblyLine line = engine.getAssembledLine(1);
      final AssembledOptDirectiveLine optLine = ((AssembledOptDirectiveLine) line);
      Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
      Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
      Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
      Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check OPT directive check program counter
   */
  @Test
  public void testOPTProgramCounter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("ORG\t\t$4000");
      _builder.newLine();
      _builder.append("\t\t\t   \t");
      _builder.append("OPT    \tNOE\t\t\t\t   ; Options");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC after OPT instruction", 0x4000, engine.getCurrentPcValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
