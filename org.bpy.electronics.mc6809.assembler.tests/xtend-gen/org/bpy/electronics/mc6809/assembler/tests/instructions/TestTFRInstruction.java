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
package org.bpy.electronics.mc6809.assembler.tests.instructions;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
public class TestTFRInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check TFR 8 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tA,B  ");
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
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 8 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tCC,DP  ");
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
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tU,S  ");
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
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tX,Y  ");
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
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tX,PC  ");
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
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,A
   */
  @Test
  public void testSimpleTFRResultAA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,B
   */
  @Test
  public void testSimpleTFRResultAB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,D
   */
  @Test
  public void testSimpleTFRResultAD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,CC
   */
  @Test
  public void testSimpleTFRResultACC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,DP
   */
  @Test
  public void testSimpleTFRResultADP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,X
   */
  @Test
  public void testSimpleTFRResultAX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,Y
   */
  @Test
  public void testSimpleTFRResultAY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,S
   */
  @Test
  public void testSimpleTFRResultAS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,U
   */
  @Test
  public void testSimpleTFRResultAU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,PC
   */
  @Test
  public void testSimpleTFRResultAPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,A
   */
  @Test
  public void testSimpleTFRResultBA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,B
   */
  @Test
  public void testSimpleTFRResultBB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,D
   */
  @Test
  public void testSimpleTFRResultBD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,CC
   */
  @Test
  public void testSimpleTFRResultBCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR A,DP
   */
  @Test
  public void testSimpleTFRResultBDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,X
   */
  @Test
  public void testSimpleTFRResultBX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,Y
   */
  @Test
  public void testSimpleTFRResultBY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,S
   */
  @Test
  public void testSimpleTFRResultBS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,U
   */
  @Test
  public void testSimpleTFRResultBU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR B,PC
   */
  @Test
  public void testSimpleTFRResultBPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,A
   */
  @Test
  public void testSimpleTFRResultCCA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,B
   */
  @Test
  public void testSimpleTFRResultCCB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,D
   */
  @Test
  public void testSimpleTFRResultCCD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,CC
   */
  @Test
  public void testSimpleTFRResultCCCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,DP
   */
  @Test
  public void testSimpleTFRResultCCDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,X
   */
  @Test
  public void testSimpleTFRResultCCX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,Y
   */
  @Test
  public void testSimpleTFRResultCCY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,S
   */
  @Test
  public void testSimpleTFRResultCCS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,U
   */
  @Test
  public void testSimpleTFRResultCCU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR CC,PC
   */
  @Test
  public void testSimpleTFRResultCCPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,A
   */
  @Test
  public void testSimpleTFRResultDPA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,B
   */
  @Test
  public void testSimpleTFRResultDPB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,D
   */
  @Test
  public void testSimpleTFRResultDPD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,CC
   */
  @Test
  public void testSimpleTFRResultDPCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,DP
   */
  @Test
  public void testSimpleTFRResultDPDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,X
   */
  @Test
  public void testSimpleTFRResultDPX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,Y
   */
  @Test
  public void testSimpleTFRResultDPY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,S
   */
  @Test
  public void testSimpleTFRResultDPS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,U
   */
  @Test
  public void testSimpleTFRResultDPU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR DP,PC
   */
  @Test
  public void testSimpleTFRResultDPPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,A
   */
  @Test
  public void testSimpleTFRResultDA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,B
   */
  @Test
  public void testSimpleTFRResultDB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,D
   */
  @Test
  public void testSimpleTFRResultDD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,CC
   */
  @Test
  public void testSimpleTFRResultDCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,DP
   */
  @Test
  public void testSimpleTFRResultDDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,X
   */
  @Test
  public void testSimpleTFRResultDX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,Y
   */
  @Test
  public void testSimpleTFRResultDY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,S
   */
  @Test
  public void testSimpleTFRResultDS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,U
   */
  @Test
  public void testSimpleTFRResultDU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR D,PC
   */
  @Test
  public void testSimpleTFRResultDPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,A
   */
  @Test
  public void testSimpleTFRResultXA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,B
   */
  @Test
  public void testSimpleTFRResultXB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,D
   */
  @Test
  public void testSimpleTFRResultXD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,CC
   */
  @Test
  public void testSimpleTFRResultXCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,DP
   */
  @Test
  public void testSimpleTFRResultXDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,X
   */
  @Test
  public void testSimpleTFRResultXX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,Y
   */
  @Test
  public void testSimpleTFRResultXY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,S
   */
  @Test
  public void testSimpleTFRResultXS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,U
   */
  @Test
  public void testSimpleTFRResultXU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,PC
   */
  @Test
  public void testSimpleTFRResultXPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,A
   */
  @Test
  public void testSimpleTFRResultYA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,B
   */
  @Test
  public void testSimpleTFRResultYB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,D
   */
  @Test
  public void testSimpleTFRResultYD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,CC
   */
  @Test
  public void testSimpleTFRResultYCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,DP
   */
  @Test
  public void testSimpleTFRResultYDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,X
   */
  @Test
  public void testSimpleTFRResultYX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,Y
   */
  @Test
  public void testSimpleTFRResultYY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,S
   */
  @Test
  public void testSimpleTFRResultYS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR X,U
   */
  @Test
  public void testSimpleTFRResultYU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR Y,PC
   */
  @Test
  public void testSimpleTFRResultYPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,A
   */
  @Test
  public void testSimpleTFRResultUA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,B
   */
  @Test
  public void testSimpleTFRResultUB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,D
   */
  @Test
  public void testSimpleTFRResultUD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,CC
   */
  @Test
  public void testSimpleTFRResultUCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,DP
   */
  @Test
  public void testSimpleTFRResultUDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,X
   */
  @Test
  public void testSimpleTFRResultUX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,Y
   */
  @Test
  public void testSimpleTFRResultUY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,S
   */
  @Test
  public void testSimpleTFRResultUS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,U
   */
  @Test
  public void testSimpleTFRResultUU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR U,PC
   */
  @Test
  public void testSimpleTFRResultUPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,A
   */
  @Test
  public void testSimpleTFRResultSA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,B
   */
  @Test
  public void testSimpleTFRResultSB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,D
   */
  @Test
  public void testSimpleTFRResultSD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,CC
   */
  @Test
  public void testSimpleTFRResultSCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,DP
   */
  @Test
  public void testSimpleTFRResultSDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,X
   */
  @Test
  public void testSimpleTFRResultSX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,Y
   */
  @Test
  public void testSimpleTFRResultSY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,S
   */
  @Test
  public void testSimpleTFRResultSS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,U
   */
  @Test
  public void testSimpleTFRResultSU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR S,PC
   */
  @Test
  public void testSimpleTFRResultSPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,A
   */
  @Test
  public void testSimpleTFRResultPCA() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,B
   */
  @Test
  public void testSimpleTFRResultPCB() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,D
   */
  @Test
  public void testSimpleTFRResultPCD() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,CC
   */
  @Test
  public void testSimpleTFRResultPCCC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,DP
   */
  @Test
  public void testSimpleTFRResultPCDP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,X
   */
  @Test
  public void testSimpleTFRResultPCX() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,Y
   */
  @Test
  public void testSimpleTFRResultPCY() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,S
   */
  @Test
  public void testSimpleTFRResultPCS() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,U
   */
  @Test
  public void testSimpleTFRResultPCU() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check TFR PC,PC
   */
  @Test
  public void testSimpleTFRResultPCPC() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledTFRInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }
}
