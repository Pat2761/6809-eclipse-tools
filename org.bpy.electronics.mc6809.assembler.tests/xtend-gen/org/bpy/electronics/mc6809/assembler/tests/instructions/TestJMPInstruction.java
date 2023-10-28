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
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
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
public class TestJMPInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check JMP with extra space
   */
  @Test
  public void testSimpleJMPWithExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("Origin\t       \tORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       \t\t");
      _builder.append("JMP\t\t\tOrigin ");
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
      Assert.assertTrue("Must be an JMP instruction line", (_instruction instanceof JmpInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP with extra space
   */
  @Test
  public void testSimpleJMPWithExtraSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("Origin\t       \tORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       \t\t");
      _builder.append("JMP\t\t\t$8000 ");
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
      Assert.assertTrue("Must be an JMP instruction line", (_instruction instanceof JmpInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP direct mode
   */
  @Test
  public void testJMPDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("JMP\t\t  \t<124");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP extended mode
   */
  @Test
  public void testJMPExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("JMP\t\t  \t$1234");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP extended mode
   */
  @Test
  public void testJMPExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("JMP\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP extended indirect mode
   */
  @Test
  public void testJMPExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("JMP\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Constant-Offset Indexed
   */
  @Test
  public void testJMPConstantOffsetIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t$9,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Constant-Offset Indexed indirect
   */
  @Test
  public void testJMPConstantOffsetIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[$9,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Accumulator Indexed
   */
  @Test
  public void testJMPAccumulatorIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \tD,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Accumulator Indexed Indirect
   */
  @Test
  public void testJMPAccumulatorIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("JMP\t\t  \t[D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Auto-Jmprement Indexed
   */
  @Test
  public void testJMPAutoJmprementIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Jmprement Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Auto-Jmprement Indexed Indirect
   */
  @Test
  public void testJMPAutoJmprementIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Jmprement Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Relative to PC Indexed
   */
  @Test
  public void testJMPRelativePCIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \tConst,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check JMP Relative to PC Indexed Indirect
   */
  @Test
  public void testJMPRelativePCIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("JMP\t\t  \t[Const,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(3);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof JmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final JmpInstruction jmpInstruction = ((JmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
      EObject _operand = jmpInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = jmpInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
