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
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
public class TestCMPUInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check CMPU immediat
   */
  @Test
  public void testCMPUImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPU\t\t  \t#124");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU direct mode
   */
  @Test
  public void testCMPUDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPU\t\t  \t<124");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU extended mode
   */
  @Test
  public void testCMPUExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPU\t\t  \t$1234");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU extended mode
   */
  @Test
  public void testCMPUExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPU\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU extended indirect mode
   */
  @Test
  public void testCMPUExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPU\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Constant-Offset Indexed
   */
  @Test
  public void testCMPUConstantOffsetIndexed() {
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
      _builder.append("CMPU\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Constant-Offset Indexed indirect
   */
  @Test
  public void testCMPUConstantOffsetIndexedIndirect() {
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
      _builder.append("CMPU\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Accumulator Indexed
   */
  @Test
  public void testCMPUAccumulatorIndexed() {
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
      _builder.append("CMPU\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Accumulator Indexed Indirect
   */
  @Test
  public void testCMPUAccumulatorIndexedIndirect() {
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
      _builder.append("CMPU\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPU\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Auto-Increment Indexed
   */
  @Test
  public void testCMPUAutoIncrementIndexed() {
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
      _builder.append("CMPU\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,U++");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Auto-Increment Indexed Indirect
   */
  @Test
  public void testCMPUAutoIncrementIndexedIndirect() {
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
      _builder.append("CMPU\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Relative to PC Indexed
   */
  @Test
  public void testCMPURelativePCIndexed() {
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
      _builder.append("CMPU\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU Relative to PC Indexed Indirect
   */
  @Test
  public void testCMPURelativePCIndexedIndirect() {
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
      _builder.append("CMPU\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPU\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an CMPU directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPU instruction", addInstruction.getInstruction(), "CMPU");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = addInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPU instruction with duplicate label
   */
  @Test
  public void testCMPUWithDuplicateLabel() {
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
      _builder.append("Start      \tCMPU\t\t  \t#Const+2");
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

  /**
   * Check Assembled CMPU immediate instruction
   */
  @Test
  public void testCMPUImmediatInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t#Const+2  ; 8000   11 83 07        START:    CMPU");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x83, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 83 07        START:    CMPU", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU immediate with limit negative operand
   */
  @Test
  public void testCMPUImmediatInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t#-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU immediate with limit negative operand
   */
  @Test
  public void testCMPUImmediatInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t#-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU immediate with positive limit operand
   */
  @Test
  public void testCMPUImmediatInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t#32767");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU immediate with positive limit operand
   */
  @Test
  public void testCMPUImmediatInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t#32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 32768 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU direct mode instruction
   */
  @Test
  public void testCMPUDirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t<Const*2  ; 8000   11 93 0A        START:    CMPU   <Const*2 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x93, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 93 0A        START:    CMPU   <Const*2 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU direct with limit negative operand
   */
  @Test
  public void testCMPUDirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t<-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU direct with limit negative operand
   */
  @Test
  public void testCMPUDirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t<-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU direct with positive limit operand
   */
  @Test
  public void testCMPUDirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t<127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU direct with positive limit operand
   */
  @Test
  public void testCMPUDirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t<128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended mode instruction
   */
  @Test
  public void testCMPUExtendedInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t>Const*1000  ; 8000   11 B3 13 88     START:    CMPU   >Const*1000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xB3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 B3 13 88     START:    CMPU   >Const*1000 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended with limit negative operand
   */
  @Test
  public void testCMPUExtendedInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t>-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended with limit negative operand
   */
  @Test
  public void testCMPUExtendedInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t>-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended with positive limit operand
   */
  @Test
  public void testCMPUExtendedInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t>65535");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended with positive limit operand
   */
  @Test
  public void testCMPUExtendedInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t>65536");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended indirect mode instruction
   */
  @Test
  public void testCMPUExtendedIndirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[Const*1000]  ; 8000   AB 9F 13 88  START:    CMPU   [Const*1000]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 3, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[2]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    CMPU   [Const*1000]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended indirect with limit negative operand
   */
  @Test
  public void testCMPUExtendedIndirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended indirect with limit negative operand
   */
  @Test
  public void testCMPUExtendedIndirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended indirect with positive limit operand
   */
  @Test
  public void testCMPUExtendedIndirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[65535]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU extended indirect with positive limit operand
   */
  @Test
  public void testCMPUExtendedIndirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[65536]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tA,X  ; 8000   10 A3 86        START:    CMPU   A,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    CMPU   A,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tA,Y  ; 8000   \t10 A3 A6        START:    CMPU   A,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A6        START:    CMPU   A,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tA,U  ; 8000   \t10 A3 C6        START:    CMPU   A,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C6        START:    CMPU   A,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tA,S  ; 8000   \t10 A3 E6        START:    CMPU   A,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E6        START:    CMPU   A,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tB,X  ; 8000   AB 85        START:    CMPU   B,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPU   B,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tB,Y  ; 8000   \t10 A3 A5        START:    CMPU   B,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A5        START:    CMPU   B,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tB,U  ; 8000   \t10 A3 C5        START:    CMPU   B,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C5        START:    CMPU   B,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tB,S  ; 8000   \t10 A3 E5        START:    CMPU   B,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E5        START:    CMPU   B,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tD,X  ; 8000   AB 8B        START:    CMPU   D,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPU   D,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tD,Y  ; 8000   \t10 A3 AB        START:    CMPU   D,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 AB        START:    CMPU   D,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tD,U  ; 8000   \t10 A3 CB        START:    CMPU   D,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 CB        START:    CMPU   D,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \tD,S  ; 8000   \t10 A3 EB        START:    CMPU   D,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 EB        START:    CMPU   D,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndorectAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[A,X]  ; 8000   AB 96        START:    CMPU   [A,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPU   [A,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[A,Y]  ; 8000   \t10 A3 B6        START:    CMPU   [A,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B6        START:    CMPU   [A,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[A,U]  ; 8000   \t10 A3 D6        START:    CMPU   [A,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D6        START:    CMPU   [A,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[A,S]  ; 8000   \t10 A3 F6        START:    CMPU   [A,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F6        START:    CMPU   [A,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[B,X]  ; 8000   AB 95        START:    CMPU   [B,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPU   [B,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[B,Y]  ; 8000   \t10 A3 B5        START:    CMPU   [B,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B5        START:    CMPU   [B,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[B,U]  ; 8000   \t10 A3 D5        START:    CMPU   [B,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D5        START:    CMPU   [B,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[B,S]  ; 8000   \t10 A3 F5        START:    CMPU   [B,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F5        START:    CMPU   [B,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[D,X]  ; 8000   AB 9B        START:    CMPU   [D,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPU   [D,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[D,Y]  ; 8000   \t10 A3 BB        START:    CMPU   [D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 BB        START:    CMPU   [D,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[D,U]  ; 8000   \t10 A3 DB        START:    CMPU   [D,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 DB        START:    CMPU   [D,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPUIndexedIndirectAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[D,S]  ; 8000   \t10 A3 FB        START:    CMPU   [D,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 FB        START:    CMPU   [D,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,X+  ; 8000   \t10 A3 80        START:    CMPU   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 80        START:    CMPU   ,X+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,X++  ; 8000   \t10 A3 81        START:    CMPU   ,X++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 81        START:    CMPU   ,X++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,Y+  ; 8000   \t10 A3 A0        START:    CMPU   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A0        START:    CMPU   ,Y+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,Y++  ; 8000   \t10 A3 A1        START:    CMPU   ,Y++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A1        START:    CMPU   ,Y++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,S+  ; 8000   \t10 A3 E0        START:    CMPU   ,S+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E0        START:    CMPU   ,S+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,S++  ; 8000   \t10 A3 E1        START:    CMPU   ,S++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E1        START:    CMPU   ,S++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,U+  ; 8000   \t10 A3 C0        START:    CMPU   ,U+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C0        START:    CMPU   ,U+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,U++  ; 8000   \t10 A3 C1        START:    CMPU   ,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C1        START:    CMPU   ,U++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,-X  ; 8000   \t10 A3 82        START:    CMPU   ,-X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 82        START:    CMPU   ,-X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,--X  ; 8000   \t10 A3 83        START:    CMPU   ,--X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 83        START:    CMPU   ,--X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,-Y  ; 8000   \t10 A3 A2        START:    CMPU   ,-Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A2        START:    CMPU   ,-Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,--Y  ; 8000   \t10 A3 A3        START:    CMPU   ,--Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A3        START:    CMPU   ,--Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,-S  ; 8000   \t10 A3 E2        START:    CMPU   ,-S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E2        START:    CMPU   ,-S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,--S  ; 8000   \t10 A3 E3        START:    CMPU   ,--S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E3        START:    CMPU   ,--S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,-U  ; 8000   \t10 A3 C2        START:    CMPU   ,-U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C2        START:    CMPU   ,-U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,--U  ; 8000   \t10 A3 C3        START:    CMPU   ,--U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C3        START:    CMPU   ,--U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,X+]  ; 8000   \t10 A3 80        START:    CMPU   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,X++]  ; 8000   \t10 A3 91        START:    CMPU   [,X++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 91        START:    CMPU   [,X++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,Y+]  ; 8000   \t10 A3 A0        START:    CMPU   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,Y++]  ; 8000   \t10 A3 B1        START:    CMPU   [,Y++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B1        START:    CMPU   [,Y++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,S+]  ; 8000   \t10 A3 E0        START:    CMPU   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,S++]  ; 8000   \t10 A3 F1        START:    CMPU   [,S++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F1        START:    CMPU   [,S++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,U+]  ; 8000   \t10 A3 C0        START:    CMPU   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementindirectMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,U++]  ; 8000   \t10 A3 D1        START:    CMPU   [,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D1        START:    CMPU   [,U++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,-X]  ; 8000   \t10 A3 82        START:    CMPU   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,--X]  ; 8000   \t10 A3 93        START:    CMPU   [,--X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 93        START:    CMPU   [,--X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,-Y]  ; 8000   \t10 A3 A2        START:    CMPU   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,--Y]  ; 8000   \t10 A3 B3        START:    CMPU   [,--Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B3        START:    CMPU   [,--Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,-S]  ; 8000   \t10 A3 E2        START:    CMPU   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,--S]  ; 8000   \t10 A3 F3        START:    CMPU   [,--S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F3        START:    CMPU   [,--S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,-U]  ; 8000   \t10 A3 C2        START:    CMPU   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPUIndexedAutoIncrementDecrementIndirectMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,--U]  ; 8000   \t10 A3 D3        START:    CMPU   [,--U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D3        START:    CMPU   [,--U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1234,X  ; 8000   \t10 A3 89 04 D2            CMPU   1234,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 04 D2            CMPU   1234,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1234,Y  ; 8000   \t10 A3 A9 04 D2            CMPU   1234,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 04 D2            CMPU   1234,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1234,U  ; 8000   \t10 A3 C9 04 D2            CMPU   1234,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 04 D2            CMPU   1234,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1234,S  ; 8000   \t10 A3 E9 04 D2            CMPU   1234,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 04 D2            CMPU   1234,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t34,X  ; 8000   \t10 A3 88 22            CMPU   34,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 22            CMPU   34,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t34,Y  ; 8000   \t10 A3 A8 22            CMPU   34,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 22            CMPU   34,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t34,U  ; 8000   \t10 A3 C8 22            CMPU   34,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 22            CMPU   34,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t34,S  ; 8000   \t10 A3 E8 22            CMPU   34,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 22            CMPU   34,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,X  ; 8000   \t10 A3 84            CMPU   ,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPU   ,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,Y  ; 8000   \t10 A3 A4            CMPU   ,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPU   ,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,U  ; 8000   \t10 A3 C4            CMPU   ,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPU   ,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t,S  ; 8000   \t10 A3 E4            CMPU   ,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPU   ,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t0,X  ; 8000   \t10 A3 84            CMPU   0,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPU   0,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t0,Y  ; 8000   \t10 A3 A4            CMPU   0,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPU   0,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t0,U  ; 8000   \t10 A3 C4            CMPU   0,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPU   0,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t0,S  ; 8000   \t10 A3 E4            CMPU   0,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPU   0,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-16,X  ; 8000   \t10 A3 10            CMPU   -16,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 10            CMPU   -16,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1,X  ; 8000   \t10 A3 01            CMPU   1,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 01            CMPU   1,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t15,X  ; 8000   \t10 A3 0F            CMPU   15,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 0F            CMPU   15,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-16,Y  ; 8000   \t10 A3 30            CMPU   -16,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 30            CMPU   -16,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1,Y  ; 8000   \t10 A3 21            CMPU   1,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 21            CMPU   1,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t15,Y  ; 8000   \t10 A3 2F            CMPU   15,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 2F            CMPU   15,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove25() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-16,U  ; 8000   \t10 A3 50            CMPU   -16,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 50            CMPU   -16,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove26() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1,U  ; 8000   \t10 A3 41            CMPU   1,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 41            CMPU   1,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove27() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t15,U  ; 8000   \t10 A3 4F            CMPU   15,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 4F            CMPU   15,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove28() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-16,S  ; 8000   \t10 A3 70            CMPU   -16,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 70            CMPU   -16,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove29() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t1,S  ; 8000   \t10 A3 61            CMPU   1,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 61            CMPU   1,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove30() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t15,S  ; 8000   \t10 A3 6F            CMPU   15,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 6F            CMPU   15,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-128,X  ; 8000   \t10 A3 88 80            CMPU   -128,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 80            CMPU   -128,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t127,X  ; 8000   \t10 A3 88 7F            CMPU   127,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 7F            CMPU   127,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-128,Y  ; 8000   \t10 A3 A8 80            CMPU   -128,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 80            CMPU   -128,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t127,Y  ; 8000   \t10 A3 A8 7F            CMPU   127,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 7F            CMPU   127,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-128,U  ; 8000   \t10 A3 C8 80            CMPU   -128,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 80            CMPU   -128,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t127,U  ; 8000   \t10 A3 C8 7F            CMPU   127,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 7F            CMPU   127,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-128,S  ; 8000   \t10 A3 E8 80            CMPU   -128,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 80            CMPU   -128,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t127,S  ; 8000   \t10 A3 E8 7F            CMPU   127,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 7F            CMPU   127,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32768,X  ; 8000   \t10 A3 89 80 00             CMPU   -32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPU   -32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32767,X  ; 8000   \t10 A3 89 7F FF             CMPU   32767,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPU   32767,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32768,Y  ; 8000   \t10 A3 A9 80 00             CMPU   -32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPU   -32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32767,Y  ; 8000   \t10 A3 A9 7F FF             CMPU   32767,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPU   32767,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32768,U  ; 8000   \t10 A3 C9 80 00             CMPU   -32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPU   -32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32767,U  ; 8000   \t10 A3 C9 7F FF             CMPU   32767,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPU   32767,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32768,S  ; 8000   \t10 A3 E9 80 00             CMPU   -32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPU   -32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32767,S  ; 8000   \t10 A3 E9 7F FF             CMPU   32767,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPU   32767,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32769,X  ; 8000   \t10 A3 89 80 00             CMPU   -32769,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPU   -32769,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32768,X  ; 8000   \t10 A3 89 7F FF             CMPU   32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPU   32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32769,Y  ; 8000   \t10 A3 A9 80 00             CMPU   -32769,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPU   -32769,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32768,Y  ; 8000   \t10 A3 A9 7F FF             CMPU   32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPU   32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32769,U  ; 8000   \t10 A3 C9 80 00             CMPU   -32769,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPU   -32769,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32768,U  ; 8000   \t10 A3 C9 7F FF             CMPU   32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPU   32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32769,S  ; 8000   \t10 A3 E9 80 00             CMPU   -32769,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPU   -32769,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  32768,S  ; 8000   \t10 A3 E9 7F FF             CMPU   32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPU   32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[1234,X]  ; 8000   \t10 A3 99 04 D2            CMPU   [1234,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 04 D2            CMPU   [1234,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[1234,Y]  ; 8000   \t10 A3 B9 04 D2            CMPU   [1234,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 04 D2            CMPU   [1234,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[1234,U]  ; 8000   \t10 A3 D9 04 D2            CMPU   [1234,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 04 D2            CMPU   [1234,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[1234,S]  ; 8000   \t10 A3 F9 04 D2            CMPU   [1234,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 04 D2            CMPU   [1234,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[34,X]  ; 8000   \t10 A3 98 22            CMPU   [34,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 22            CMPU   [34,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[34,Y]  ; 8000   \t10 A3 B8 22            CMPU   [34,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 22            CMPU   [34,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[34,U]  ; 8000   \t10 A3 D8 22            CMPU   [34,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 22            CMPU   [34,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[34,S]  ; 8000   \t10 A3 F8 22            CMPU   [34,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 22            CMPU   [34,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,X]  ; 8000   \t10 A3 94            CMPU   [,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPU   [,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,Y]  ; 8000   \t10 A3 B4            CMPU   [,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPU   [,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,U]  ; 8000   \t10 A3 D4            CMPU   [,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPU   [,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[,S]  ; 8000   \t10 A3 F4            CMPU   [,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPU   [,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[0,X]  ; 8000   \t10 A3 94            CMPU   [0,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPU   [0,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[0,Y]  ; 8000   \t10 A3 B4            CMPU   [0,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPU   [0,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[0,U]  ; 8000   \t10 A3 D4            CMPU   [0,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPU   [0,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[0,S]  ; 8000   \t10 A3 F4            CMPU   [0,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPU   [0,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-16,X]  ; 8000   \t10 A3 98 F0            CMPU   [-16,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 F0            CMPU   [-16,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[15,X]  ; 8000   \t10 A3 98 0F            CMPU   [15,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 0F            CMPU   [15,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-16,Y]  ; 8000   \t10 A3 B8 F0            CMPU   [-16,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 F0            CMPU   [-16,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[15,Y]  ; 8000   \t10 A3 B8 0F            CMPU   [15,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 0F            CMPU   [15,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-16,U]  ; 8000   \t10 A3 D8 F0            CMPU   [-16,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 F0            CMPU   [-16,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove22() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[15,U]  ; 8000   \t10 A3 D8 0F            CMPU   [15,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 0F            CMPU   [15,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-16,S]  ; 8000   \t10 A3 F8 F0            CMPU   [-16,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 F0            CMPU   [-16,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[15,S]  ; 8000   \t10 A3 F8 0F            CMPU   [15,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 0F            CMPU   [15,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-128,X]  ; 8000   \t10 A3 98 80            CMPU   [-128,X}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 80            CMPU   [-128,X}", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[127,X]  ; 8000   \t10 A3 98 7F            CMPU   [127,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 7F            CMPU   [127,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-128,Y]  ; 8000   \t10 A3 B8 80            CMPU   [-128,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 80            CMPU   [-128,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[127,Y]  ; 8000   \t10 A3 B8 7F            CMPU   [127,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 7F            CMPU   [127,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-128,U]  ; 8000   \t10 A3 D8 80            CMPU   [-128,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 80            CMPU   [-128,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[127,U]  ; 8000   \t10 A3 D8 7F            CMPU   [127,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 7F            CMPU   [127,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-128,S]  ; 8000   \t10 A3 F8 80            CMPU   [-128,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 80            CMPU   [-128,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[127,S]  ; 8000   \t10 A3 F8 7F            CMPU   [127,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 7F            CMPU   [127,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768,X]  ; 8000   \t10 A3 99 80 00             CMPU   [-32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPU   [-32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32767,X]  ; 8000   \t10 A3 99 7F FF             CMPU   [32767,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPU   [32767,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768,Y]  ; 8000   \t10 A3 B9 80 00             CMPU   [-32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPU   [-32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32767,Y]  ; 8000   \t10 A3 B9 7F FF             CMPU   [32767,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPU   [32767,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768,U]  ; 8000   \t10 A3 D9 80 00             CMPU   [-32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPU   [-32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32767,U]  ; 8000   \t10 A3 D9 7F FF             CMPU   [32767,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPU   [32767,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768,S]  ; 8000   \t10 A3 F9 80 00             CMPU   [-32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPU   [-32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32767,S]  ; 8000   \t10 A3 F9 7F FF             CMPU   [32767,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPU   [32767,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769,X]  ; 8000   \t10 A3 99 80 00             CMPU   [-32769,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPU   [-32769,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32768,X]  ; 8000   \t10 A3 99 7F FF             CMPU   [32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPU   [32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769,Y]  ; 8000   \t10 A3 B9 80 00             CMPU   [-32769,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPU   [-32769,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32768,Y]  ; 8000   \t10 A3 B9 7F FF             CMPU   [32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPU   [32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769,U]  ; 8000   \t10 A3 D9 80 00             CMPU   [-32769,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPU   [-32769,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32768,U]  ; 8000   \t10 A3 D9 7F FF             CMPU   [32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPU   [32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769,S]  ; 8000   \t10 A3 F9 80 00             CMPU   [-32769,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPU   [-32769,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPUIndexedConstantIndirectMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  [32768,S]  ; 8000   \t10 A3 F9 7F FF             CMPU   [32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPU   [32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t0,PCR  ; 8000   \t10 A3 8C 00            CMPU   0,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 00            CMPU   0,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-128,PCR  ; 8000   \t10 A3 8C 80            CMPU   -128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 80            CMPU   -128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t127,PCR  ; 8000   \t10 A3 8C 7F            CMPU   127,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 7F            CMPU   127,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-129,PCR  ; 8000   \t10 A3 8D FF 7F            CMPU   -129,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D FF 7F            CMPU   -129,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t128,PCR  ; 8000   \t10 A3 8D 00 80            CMPU   128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 00 80            CMPU   128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32768,PCR  ; 8000   \t10 A3 8D 80 00            CMPU   -32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPU   -32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t32767,PCR  ; 8000   \t10 A3 8D 7F FF            CMPU   32767,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPU   32767,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t-32769,PCR  ; 8000   \t10 A3 8D 80 00            CMPU   -32769,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPU   -32769,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t32768,PCR  ; 8000   \t10 A3 8D 7F FF            CMPU   32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPU   32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[0,PCR]  ; 8000   \t10 A3 9C 00            CMPU   [0,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 00            CMPU   [0,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-128,PCR]  ; 8000   \t10 A3 9C 80            CMPU   [-128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 80            CMPU   [-128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[127,PCR]  ; 8000   \t10 A3 9C 7F            CMPU   [127,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 7F            CMPU   [127,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-129,PCR]  ; 8000   \t10 A3 9D FF 7F            CMPU   [-129,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D FF 7F            CMPU   [-129,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[128,PCR]  ; 8000   \t10 A3 9D 00 80            CMPU   [128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 00 80            CMPU   [128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32768,PCR]  ; 8000   \t10 A3 9D 80 00            CMPU   [-32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPU   [-32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[32767,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPU   [32767,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPU   [32767,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[-32769,PCR]  ; 8000   \t10 A3 9D 80 00            CMPU   [-32769,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPU   [-32769,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPUIndexedRelatifIndirectToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPU\t\t  \t[32768,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPU   [32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPUInstruction line = ((AssembledCMPUInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPU   [32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
