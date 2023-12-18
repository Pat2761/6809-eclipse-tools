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
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRegDirectiveLine;
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
public class TestRegDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check REG directive without comment
   */
  @Test
  public void testREGWithoutCommentWithSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("RGT_S \t\tREG \tPC,U,Y,X,DP,D,CC \t; tous les registres sauf S");
      _builder.newLine();
      _builder.append("RGT_U \t\tREG \tPC,S,Y,X,DP,D,CC \t; tous les registres sauf U");
      _builder.newLine();
      _builder.append("RGABCC \t\tREG \tA,B,CC \t\t\t\t; on peut aussi écrire D,CC");
      _builder.newLine();
      _builder.append("RGUYX \t\tREG \tU,Y,X");
      _builder.newLine();
      _builder.append("RGUDCC \t\tREG \tU,D,CC \t\t\t\t; on peut aussi écrire U,A,B,CC \t\t   FAIL    ");
      _builder.newLine();
      _builder.append("RegD \t\tREG\t\tD");
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
      Assert.assertTrue("Must be an REG directive line", (_directive instanceof RegDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with a missing label
   */
  @Test
  public void testWithMissingLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append(" \t    ");
      _builder.append("REG     A ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL, "No label defined for REG directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with a missing register
   */
  @Test
  public void testWithMissingRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("Regs \t    REG     \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.MISSING_OPTION, "no register defined in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with a duplicate register
   */
  @Test
  public void testWithDuplicateRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("Regs \t    REG    A,B,U,S,A \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION, "Register A is duplicate in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with missing label
   */
  @Test
  public void testRegWithMissingLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("REG    A,B,U,S,A \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL, "No label defined for REG directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive impact on PC Address
   */
  @Test
  public void testRegPcAddress() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t   $C000");
      _builder.newLine();
      _builder.append("RegV \t    REG    A,B,U,S \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Address", 0xC000, engine.getCurrentPcValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with D and A register
   */
  @Test
  public void testRegWithAAndDRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("REG    A,D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION, "D register overwrite the A register in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with D and B register
   */
  @Test
  public void testRegWithBAndDRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("REG    B,D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION, "D register overwrite the B register in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive with duplicate label
   */
  @Test
  public void testRegWithDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("Lab1\t\tEQU\t\t100");
      _builder.newLine();
      _builder.append("Lab1\t \tREG    \tB,D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), AssemblerEngine.DUPLICATE_LABEL, "The label Lab1 for an REG directive is already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check equ value forREG directive
   */
  @Test
  public void testRegEquValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("Lab2\t \tREG    \tB,X \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledRegDirectiveLine line = ((AssembledRegDirectiveLine) _assembledLine);
      Assert.assertEquals("Check equ value", 0x14, (engine.getEquSetLabelValue(line.getLabel())).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check REG directive value CC
   */
  @Test
  public void testRegValueCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("CC1\t \t    REG    CC \t\t ");
      _builder.newLine();
      _builder.append("L_A\t \t    REG    A \t\t ");
      _builder.newLine();
      _builder.append("L_B\t \t    REG    B \t\t ");
      _builder.newLine();
      _builder.append("L_D \t    REG    D");
      _builder.newLine();
      _builder.append("L_DP \t    REG    DP");
      _builder.newLine();
      _builder.append("L_X\t \t    REG    X \t\t ");
      _builder.newLine();
      _builder.append("L_Y\t \t    REG    Y \t\t ");
      _builder.newLine();
      _builder.append("L_U\t \t    REG    U \t\t ");
      _builder.newLine();
      _builder.append("L_S\t \t    REG    S \t\t ");
      _builder.newLine();
      _builder.append("L_PC\t \tREG    PC \t\t ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledRegDirectiveLine regLineCC = ((AssembledRegDirectiveLine) _assembledLine);
      Assert.assertEquals("Check value CC", 1, regLineCC.getValue());
      AbstractAssemblyLine _assembledLine_1 = engine.getAssembledLine(2);
      final AssembledRegDirectiveLine regLineA = ((AssembledRegDirectiveLine) _assembledLine_1);
      Assert.assertEquals("Check value A", 2, regLineA.getValue());
      AbstractAssemblyLine _assembledLine_2 = engine.getAssembledLine(3);
      final AssembledRegDirectiveLine regLineB = ((AssembledRegDirectiveLine) _assembledLine_2);
      Assert.assertEquals("Check value B", 4, regLineB.getValue());
      AbstractAssemblyLine _assembledLine_3 = engine.getAssembledLine(4);
      final AssembledRegDirectiveLine regLineD = ((AssembledRegDirectiveLine) _assembledLine_3);
      Assert.assertEquals("Check value D", 6, regLineD.getValue());
      AbstractAssemblyLine _assembledLine_4 = engine.getAssembledLine(5);
      final AssembledRegDirectiveLine regLineDP = ((AssembledRegDirectiveLine) _assembledLine_4);
      Assert.assertEquals("Check value DP", 8, regLineDP.getValue());
      AbstractAssemblyLine _assembledLine_5 = engine.getAssembledLine(6);
      final AssembledRegDirectiveLine regLineX = ((AssembledRegDirectiveLine) _assembledLine_5);
      Assert.assertEquals("Check value X", 16, regLineX.getValue());
      AbstractAssemblyLine _assembledLine_6 = engine.getAssembledLine(7);
      final AssembledRegDirectiveLine regLineY = ((AssembledRegDirectiveLine) _assembledLine_6);
      Assert.assertEquals("Check value Y", 32, regLineY.getValue());
      AbstractAssemblyLine _assembledLine_7 = engine.getAssembledLine(8);
      final AssembledRegDirectiveLine regLineU = ((AssembledRegDirectiveLine) _assembledLine_7);
      Assert.assertEquals("Check value U", 64, regLineU.getValue());
      AbstractAssemblyLine _assembledLine_8 = engine.getAssembledLine(9);
      final AssembledRegDirectiveLine regLineS = ((AssembledRegDirectiveLine) _assembledLine_8);
      Assert.assertEquals("Check value S", 64, regLineS.getValue());
      AbstractAssemblyLine _assembledLine_9 = engine.getAssembledLine(10);
      final AssembledRegDirectiveLine regLinePC = ((AssembledRegDirectiveLine) _assembledLine_9);
      Assert.assertEquals("Check value PC", 128, regLinePC.getValue());
      Assert.assertEquals("Check memorization", 128, (engine.getRegDefintionValue("L_PC")).intValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
