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
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
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
public class TestCOMInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check COM direct mode
   */
  @Test
  public void testCOMDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("COM\t\t  \t<124");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM extended mode
   */
  @Test
  public void testCOMExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("COM\t\t  \t$1234");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM extended mode
   */
  @Test
  public void testCOMExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("COM\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM extended indirect mode
   */
  @Test
  public void testCOMExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("COM\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Constant-Offset Indexed
   */
  @Test
  public void testCOMConstantOffsetIndexed() {
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
      _builder.append("COM\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Constant-Offset Indexed indirect
   */
  @Test
  public void testCOMConstantOffsetIndexedIndirect() {
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
      _builder.append("COM\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Accumulator Indexed
   */
  @Test
  public void testCOMAccumulatorIndexed() {
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
      _builder.append("COM\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Accumulator Indexed Indirect
   */
  @Test
  public void testCOMAccumulatorIndexedIndirect() {
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
      _builder.append("COM\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("COM\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Auto-Increment Indexed
   */
  @Test
  public void testCOMAutoIncrementIndexed() {
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
      _builder.append("COM\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,U++");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Auto-Increment Indexed Indirect
   */
  @Test
  public void testCOMAutoIncrementIndexedIndirect() {
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
      _builder.append("COM\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Relative to PC Indexed
   */
  @Test
  public void testCOMRelativePCIndexed() {
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
      _builder.append("COM\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM Relative to PC Indexed Indirect
   */
  @Test
  public void testCOMRelativePCIndexedIndirect() {
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
      _builder.append("COM\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("COM\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an COM directive line", (_instruction instanceof ComInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final ComInstruction comInstruction = ((ComInstruction) _instruction_1);
      Assert.assertEquals("Must be an COM instruction", comInstruction.getInstruction(), "COM");
      EObject _operand = comInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = comInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check COM instruction with duplicate label
   */
  @Test
  public void testCOMWithDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start\t\tNOP");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("NOP    ");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t\t<Const+2");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), 
        AssemblerEngine.DUPLICATE_LABEL, 
        "Label Start is already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testCOMWithImmediateMode() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM direct mode instruction
   */
  @Test
  public void testCOMDirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM direct with limit negative operand
   */
  @Test
  public void testCOMDirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM direct with limit negative operand
   */
  @Test
  public void testCOMDirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM direct with positive limit operand
   */
  @Test
  public void testCOMDirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM direct with positive limit operand
   */
  @Test
  public void testCOMDirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended mode instruction
   */
  @Test
  public void testCOMExtendedInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM extended with limit negative operand
   */
  @Test
  public void testCOMExtendedInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended with limit negative operand
   */
  @Test
  public void testCOMExtendedInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended with positive limit operand
   */
  @Test
  public void testCOMExtendedInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended with positive limit operand
   */
  @Test
  public void testCOMExtendedInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended indirect mode instruction
   */
  @Test
  public void testCOMExtendedIndirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM extended indirect with limit negative operand
   */
  @Test
  public void testCOMExtendedIndirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended indirect with limit negative operand
   */
  @Test
  public void testCOMExtendedIndirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended indirect with positive limit operand
   */
  @Test
  public void testCOMExtendedIndirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM extended indirect with positive limit operand
   */
  @Test
  public void testCOMExtendedIndirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndorectAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCOMIndexedIndirectAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,X+]  ; 8000   \t63 80        START:    COM   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,Y+]  ; 8000   \t63 A0        START:    COM   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,S+]  ; 8000   \t63 E0        START:    COM   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,U+]  ; 8000   \t63 C0        START:    COM   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementindirectMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,-X]  ; 8000   \t63 82        START:    COM   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,-Y]  ; 8000   \t63 A2        START:    COM   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,-S]  ; 8000   \t63 E2        START:    COM   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCOM\t\t  \t[,-U]  ; 8000   \t63 C2        START:    COM   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getComInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled COM Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCOMIndexedAutoIncrementDecrementIndirectMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove25() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove26() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove27() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove28() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove29() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove30() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
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
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove18() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove22() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCOMIndexedConstantIndirectMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }

  /**
   * Check Assembled COM Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCOMIndexedRelatifIndirectToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCOMInstruction cannot be resolved to a type."
      + "\nopcode cannot be resolved"
      + "\nlength cannot be resolved"
      + "\nopcode cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nlength cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlabel cannot be resolved"
      + "\ncomment cannot be resolved");
  }
}
