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
package org.bpy.electronics.mc6809.assembler.tests.language.instructions;

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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPDInstruction;
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
public class TestCMPDInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check CMPD immediat
   */
  @Test
  public void testCMPDImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPD\t\t  \t#124");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPD direct mode
   */
  @Test
  public void testCMPDDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPD\t\t  \t<124");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPD extended mode
   */
  @Test
  public void testCMPDExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPD\t\t  \t$1234");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPD extended mode
   */
  @Test
  public void testCMPDExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPD\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPD extended indirect mode
   */
  @Test
  public void testCMPDExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPD\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPD Constant-Offset Indexed
   */
  @Test
  public void testCMPDConstantOffsetIndexed() {
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
      _builder.append("CMPD\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Constant-Offset Indexed indirect
   */
  @Test
  public void testCMPDConstantOffsetIndexedIndirect() {
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
      _builder.append("CMPD\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Accumulator Indexed
   */
  @Test
  public void testCMPDAccumulatorIndexed() {
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
      _builder.append("CMPD\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Accumulator Indexed Indirect
   */
  @Test
  public void testCMPDAccumulatorIndexedIndirect() {
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
      _builder.append("CMPD\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPD\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Auto-Increment Indexed
   */
  @Test
  public void testCMPDAutoIncrementIndexed() {
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
      _builder.append("CMPD\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,U++");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Auto-Increment Indexed Indirect
   */
  @Test
  public void testCMPDAutoIncrementIndexedIndirect() {
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
      _builder.append("CMPD\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Relative to PC Indexed
   */
  @Test
  public void testCMPDRelativePCIndexed() {
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
      _builder.append("CMPD\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD Relative to PC Indexed Indirect
   */
  @Test
  public void testCMPDRelativePCIndexedIndirect() {
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
      _builder.append("CMPD\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPD\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an CMPD directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPD instruction", addInstruction.getInstruction(), "CMPD");
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
   * Check CMPD instruction with duplicate label
   */
  @Test
  public void testCMPDWithDuplicateLabel() {
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
      _builder.append("Start      \tCMPD\t\t  \t#Const+2");
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
   * Check Assembled CMPD immediate instruction
   */
  @Test
  public void testCMPDImmediatInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t#Const+2  ; 8000   10 83 07        START:    CMPD");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x83, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 83 07        START:    CMPD", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD immediate with limit negative operand
   */
  @Test
  public void testCMPDImmediatInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t#-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD immediate with limit negative operand
   */
  @Test
  public void testCMPDImmediatInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t#-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD immediate with positive limit operand
   */
  @Test
  public void testCMPDImmediatInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t#32767");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD immediate with positive limit operand
   */
  @Test
  public void testCMPDImmediatInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t#32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 32768 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD direct mode instruction
   */
  @Test
  public void testCMPDDirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t<Const*2  ; 8000   10 93 0A        START:    CMPD   <Const*2 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x93, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 93 0A        START:    CMPD   <Const*2 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD direct with limit negative operand
   */
  @Test
  public void testCMPDDirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t<-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD direct with limit negative operand
   */
  @Test
  public void testCMPDDirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t<-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD direct with positive limit operand
   */
  @Test
  public void testCMPDDirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t<127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD direct with positive limit operand
   */
  @Test
  public void testCMPDDirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t<128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended mode instruction
   */
  @Test
  public void testCMPDExtendedInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t>Const*1000  ; 8000   10 B3 13 88     START:    CMPD   >Const*1000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xB3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 B3 13 88     START:    CMPD   >Const*1000 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended with limit negative operand
   */
  @Test
  public void testCMPDExtendedInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t>-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended with limit negative operand
   */
  @Test
  public void testCMPDExtendedInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t>-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended with positive limit operand
   */
  @Test
  public void testCMPDExtendedInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t>65535");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended with positive limit operand
   */
  @Test
  public void testCMPDExtendedInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t>65536");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended indirect mode instruction
   */
  @Test
  public void testCMPDExtendedIndirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[Const*1000]  ; 8000   AB 9F 13 88  START:    CMPD   [Const*1000]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 3, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[2]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    CMPD   [Const*1000]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended indirect with limit negative operand
   */
  @Test
  public void testCMPDExtendedIndirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended indirect with limit negative operand
   */
  @Test
  public void testCMPDExtendedIndirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended indirect with positive limit operand
   */
  @Test
  public void testCMPDExtendedIndirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[65535]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD extended indirect with positive limit operand
   */
  @Test
  public void testCMPDExtendedIndirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[65536]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tA,X  ; 8000   10 A3 86        START:    CMPD   A,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    CMPD   A,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tA,Y  ; 8000   \t10 A3 A6        START:    CMPD   A,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A6        START:    CMPD   A,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tA,U  ; 8000   \t10 A3 C6        START:    CMPD   A,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C6        START:    CMPD   A,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tA,S  ; 8000   \t10 A3 E6        START:    CMPD   A,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E6        START:    CMPD   A,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tB,X  ; 8000   AB 85        START:    CMPD   B,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPD   B,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tB,Y  ; 8000   \t10 A3 A5        START:    CMPD   B,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A5        START:    CMPD   B,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tB,U  ; 8000   \t10 A3 C5        START:    CMPD   B,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C5        START:    CMPD   B,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tB,S  ; 8000   \t10 A3 E5        START:    CMPD   B,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E5        START:    CMPD   B,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tD,X  ; 8000   AB 8B        START:    CMPD   D,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPD   D,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tD,Y  ; 8000   \t10 A3 AB        START:    CMPD   D,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 AB        START:    CMPD   D,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tD,U  ; 8000   \t10 A3 CB        START:    CMPD   D,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 CB        START:    CMPD   D,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \tD,S  ; 8000   \t10 A3 EB        START:    CMPD   D,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 EB        START:    CMPD   D,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndorectAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[A,X]  ; 8000   AB 96        START:    CMPD   [A,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPD   [A,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[A,Y]  ; 8000   \t10 A3 B6        START:    CMPD   [A,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B6        START:    CMPD   [A,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[A,U]  ; 8000   \t10 A3 D6        START:    CMPD   [A,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D6        START:    CMPD   [A,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[A,S]  ; 8000   \t10 A3 F6        START:    CMPD   [A,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F6        START:    CMPD   [A,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[B,X]  ; 8000   AB 95        START:    CMPD   [B,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPD   [B,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[B,Y]  ; 8000   \t10 A3 B5        START:    CMPD   [B,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B5        START:    CMPD   [B,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[B,U]  ; 8000   \t10 A3 D5        START:    CMPD   [B,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D5        START:    CMPD   [B,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[B,S]  ; 8000   \t10 A3 F5        START:    CMPD   [B,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F5        START:    CMPD   [B,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[D,X]  ; 8000   AB 9B        START:    CMPD   [D,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPD   [D,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[D,Y]  ; 8000   \t10 A3 BB        START:    CMPD   [D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 BB        START:    CMPD   [D,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[D,U]  ; 8000   \t10 A3 DB        START:    CMPD   [D,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 DB        START:    CMPD   [D,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPDIndexedIndirectAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[D,S]  ; 8000   \t10 A3 FB        START:    CMPD   [D,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 FB        START:    CMPD   [D,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,X+  ; 8000   \t10 A3 80        START:    CMPD   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 80        START:    CMPD   ,X+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,X++  ; 8000   \t10 A3 81        START:    CMPD   ,X++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 81        START:    CMPD   ,X++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,Y+  ; 8000   \t10 A3 A0        START:    CMPD   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A0        START:    CMPD   ,Y+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,Y++  ; 8000   \t10 A3 A1        START:    CMPD   ,Y++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A1        START:    CMPD   ,Y++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,S+  ; 8000   \t10 A3 E0        START:    CMPD   ,S+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E0        START:    CMPD   ,S+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,S++  ; 8000   \t10 A3 E1        START:    CMPD   ,S++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E1        START:    CMPD   ,S++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,U+  ; 8000   \t10 A3 C0        START:    CMPD   ,U+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C0        START:    CMPD   ,U+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,U++  ; 8000   \t10 A3 C1        START:    CMPD   ,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C1        START:    CMPD   ,U++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,-X  ; 8000   \t10 A3 82        START:    CMPD   ,-X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 82        START:    CMPD   ,-X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,--X  ; 8000   \t10 A3 83        START:    CMPD   ,--X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 83        START:    CMPD   ,--X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,-Y  ; 8000   \t10 A3 A2        START:    CMPD   ,-Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A2        START:    CMPD   ,-Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,--Y  ; 8000   \t10 A3 A3        START:    CMPD   ,--Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A3        START:    CMPD   ,--Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,-S  ; 8000   \t10 A3 E2        START:    CMPD   ,-S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E2        START:    CMPD   ,-S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,--S  ; 8000   \t10 A3 E3        START:    CMPD   ,--S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E3        START:    CMPD   ,--S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,-U  ; 8000   \t10 A3 C2        START:    CMPD   ,-U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C2        START:    CMPD   ,-U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,--U  ; 8000   \t10 A3 C3        START:    CMPD   ,--U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C3        START:    CMPD   ,--U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,X+]  ; 8000   \t10 A3 80        START:    CMPD   ,X+");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,X++]  ; 8000   \t10 A3 91        START:    CMPD   [,X++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 91        START:    CMPD   [,X++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,Y+]  ; 8000   \t10 A3 A0        START:    CMPD   ,Y+");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,Y++]  ; 8000   \t10 A3 B1        START:    CMPD   [,Y++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B1        START:    CMPD   [,Y++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,S+]  ; 8000   \t10 A3 E0        START:    CMPD   [,S+]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,S++]  ; 8000   \t10 A3 F1        START:    CMPD   [,S++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F1        START:    CMPD   [,S++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,U+]  ; 8000   \t10 A3 C0        START:    CMPD   [,U+]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementindirectMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,U++]  ; 8000   \t10 A3 D1        START:    CMPD   [,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D1        START:    CMPD   [,U++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,-X]  ; 8000   \t10 A3 82        START:    CMPD   [,-X]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,--X]  ; 8000   \t10 A3 93        START:    CMPD   [,--X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 93        START:    CMPD   [,--X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,-Y]  ; 8000   \t10 A3 A2        START:    CMPD   [,-Y]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,--Y]  ; 8000   \t10 A3 B3        START:    CMPD   [,--Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B3        START:    CMPD   [,--Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,-S]  ; 8000   \t10 A3 E2        START:    CMPD   [,-S]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,--S]  ; 8000   \t10 A3 F3        START:    CMPD   [,--S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F3        START:    CMPD   [,--S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,-U]  ; 8000   \t10 A3 C2        START:    CMPD   [,-U]");
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
   * Check Assembled CMPD Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPDIndexedAutoIncrementDecrementIndirectMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,--U]  ; 8000   \t10 A3 D3        START:    CMPD   [,--U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D3        START:    CMPD   [,--U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1234,X  ; 8000   \t10 A3 89 04 D2            CMPD   1234,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 04 D2            CMPD   1234,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1234,Y  ; 8000   \t10 A3 A9 04 D2            CMPD   1234,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 04 D2            CMPD   1234,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1234,U  ; 8000   \t10 A3 C9 04 D2            CMPD   1234,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 04 D2            CMPD   1234,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1234,S  ; 8000   \t10 A3 E9 04 D2            CMPD   1234,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 04 D2            CMPD   1234,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t34,X  ; 8000   \t10 A3 88 22            CMPD   34,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 22            CMPD   34,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t34,Y  ; 8000   \t10 A3 A8 22            CMPD   34,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 22            CMPD   34,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t34,U  ; 8000   \t10 A3 C8 22            CMPD   34,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 22            CMPD   34,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t34,S  ; 8000   \t10 A3 E8 22            CMPD   34,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 22            CMPD   34,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,X  ; 8000   \t10 A3 84            CMPD   ,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPD   ,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,Y  ; 8000   \t10 A3 A4            CMPD   ,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPD   ,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,U  ; 8000   \t10 A3 C4            CMPD   ,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPD   ,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t,S  ; 8000   \t10 A3 E4            CMPD   ,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPD   ,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t0,X  ; 8000   \t10 A3 84            CMPD   0,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPD   0,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t0,Y  ; 8000   \t10 A3 A4            CMPD   0,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPD   0,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t0,U  ; 8000   \t10 A3 C4            CMPD   0,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPD   0,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t0,S  ; 8000   \t10 A3 E4            CMPD   0,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPD   0,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-16,X  ; 8000   \t10 A3 10            CMPD   -16,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 10            CMPD   -16,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1,X  ; 8000   \t10 A3 01            CMPD   1,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 01            CMPD   1,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t15,X  ; 8000   \t10 A3 0F            CMPD   15,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 0F            CMPD   15,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-16,Y  ; 8000   \t10 A3 30            CMPD   -16,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 30            CMPD   -16,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1,Y  ; 8000   \t10 A3 21            CMPD   1,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 21            CMPD   1,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t15,Y  ; 8000   \t10 A3 2F            CMPD   15,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 2F            CMPD   15,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove25() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-16,U  ; 8000   \t10 A3 50            CMPD   -16,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 50            CMPD   -16,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove26() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1,U  ; 8000   \t10 A3 41            CMPD   1,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 41            CMPD   1,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove27() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t15,U  ; 8000   \t10 A3 4F            CMPD   15,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 4F            CMPD   15,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove28() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-16,S  ; 8000   \t10 A3 70            CMPD   -16,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 70            CMPD   -16,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove29() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t1,S  ; 8000   \t10 A3 61            CMPD   1,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 61            CMPD   1,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove30() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t15,S  ; 8000   \t10 A3 6F            CMPD   15,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 6F            CMPD   15,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-128,X  ; 8000   \t10 A3 88 80            CMPD   -128,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 80            CMPD   -128,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t127,X  ; 8000   \t10 A3 88 7F            CMPD   127,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 7F            CMPD   127,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-128,Y  ; 8000   \t10 A3 A8 80            CMPD   -128,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 80            CMPD   -128,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t127,Y  ; 8000   \t10 A3 A8 7F            CMPD   127,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 7F            CMPD   127,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-128,U  ; 8000   \t10 A3 C8 80            CMPD   -128,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 80            CMPD   -128,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t127,U  ; 8000   \t10 A3 C8 7F            CMPD   127,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 7F            CMPD   127,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-128,S  ; 8000   \t10 A3 E8 80            CMPD   -128,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 80            CMPD   -128,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t127,S  ; 8000   \t10 A3 E8 7F            CMPD   127,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 7F            CMPD   127,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32768,X  ; 8000   \t10 A3 89 80 00             CMPD   -32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPD   -32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32767,X  ; 8000   \t10 A3 89 7F FF             CMPD   32767,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPD   32767,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32768,Y  ; 8000   \t10 A3 A9 80 00             CMPD   -32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPD   -32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32767,Y  ; 8000   \t10 A3 A9 7F FF             CMPD   32767,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPD   32767,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32768,U  ; 8000   \t10 A3 C9 80 00             CMPD   -32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPD   -32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32767,U  ; 8000   \t10 A3 C9 7F FF             CMPD   32767,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPD   32767,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32768,S  ; 8000   \t10 A3 E9 80 00             CMPD   -32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPD   -32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32767,S  ; 8000   \t10 A3 E9 7F FF             CMPD   32767,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPD   32767,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32769,X  ; 8000   \t10 A3 89 80 00             CMPD   -32769,X");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPD   -32769,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32768,X  ; 8000   \t10 A3 89 7F FF             CMPD   32768,X");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPD   32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32769,Y  ; 8000   \t10 A3 A9 80 00             CMPD   -32769,Y");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPD   -32769,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32768,Y  ; 8000   \t10 A3 A9 7F FF             CMPD   32768,Y");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPD   32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32769,U  ; 8000   \t10 A3 C9 80 00             CMPD   -32769,U");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPD   -32769,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32768,U  ; 8000   \t10 A3 C9 7F FF             CMPD   32768,U");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPD   32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32769,S  ; 8000   \t10 A3 E9 80 00             CMPD   -32769,S");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPD   -32769,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  32768,S  ; 8000   \t10 A3 E9 7F FF             CMPD   32768,S");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPD   32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[1234,X]  ; 8000   \t10 A3 99 04 D2            CMPD   [1234,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 04 D2            CMPD   [1234,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[1234,Y]  ; 8000   \t10 A3 B9 04 D2            CMPD   [1234,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 04 D2            CMPD   [1234,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[1234,U]  ; 8000   \t10 A3 D9 04 D2            CMPD   [1234,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 04 D2            CMPD   [1234,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[1234,S]  ; 8000   \t10 A3 F9 04 D2            CMPD   [1234,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 04 D2            CMPD   [1234,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[34,X]  ; 8000   \t10 A3 98 22            CMPD   [34,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 22            CMPD   [34,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[34,Y]  ; 8000   \t10 A3 B8 22            CMPD   [34,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 22            CMPD   [34,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[34,U]  ; 8000   \t10 A3 D8 22            CMPD   [34,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 22            CMPD   [34,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[34,S]  ; 8000   \t10 A3 F8 22            CMPD   [34,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 22            CMPD   [34,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,X]  ; 8000   \t10 A3 94            CMPD   [,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPD   [,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,Y]  ; 8000   \t10 A3 B4            CMPD   [,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPD   [,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,U]  ; 8000   \t10 A3 D4            CMPD   [,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPD   [,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[,S]  ; 8000   \t10 A3 F4            CMPD   [,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPD   [,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[0,X]  ; 8000   \t10 A3 94            CMPD   [0,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPD   [0,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[0,Y]  ; 8000   \t10 A3 B4            CMPD   [0,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPD   [0,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[0,U]  ; 8000   \t10 A3 D4            CMPD   [0,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPD   [0,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[0,S]  ; 8000   \t10 A3 F4            CMPD   [0,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPD   [0,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-16,X]  ; 8000   \t10 A3 98 F0            CMPD   [-16,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 F0            CMPD   [-16,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[15,X]  ; 8000   \t10 A3 98 0F            CMPD   [15,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 0F            CMPD   [15,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-16,Y]  ; 8000   \t10 A3 B8 F0            CMPD   [-16,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 F0            CMPD   [-16,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[15,Y]  ; 8000   \t10 A3 B8 0F            CMPD   [15,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 0F            CMPD   [15,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-16,U]  ; 8000   \t10 A3 D8 F0            CMPD   [-16,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 F0            CMPD   [-16,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove22() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[15,U]  ; 8000   \t10 A3 D8 0F            CMPD   [15,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 0F            CMPD   [15,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-16,S]  ; 8000   \t10 A3 F8 F0            CMPD   [-16,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 F0            CMPD   [-16,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[15,S]  ; 8000   \t10 A3 F8 0F            CMPD   [15,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 0F            CMPD   [15,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-128,X]  ; 8000   \t10 A3 98 80            CMPD   [-128,X}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 80            CMPD   [-128,X}", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[127,X]  ; 8000   \t10 A3 98 7F            CMPD   [127,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 7F            CMPD   [127,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-128,Y]  ; 8000   \t10 A3 B8 80            CMPD   [-128,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 80            CMPD   [-128,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[127,Y]  ; 8000   \t10 A3 B8 7F            CMPD   [127,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 7F            CMPD   [127,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-128,U]  ; 8000   \t10 A3 D8 80            CMPD   [-128,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 80            CMPD   [-128,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[127,U]  ; 8000   \t10 A3 D8 7F            CMPD   [127,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 7F            CMPD   [127,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-128,S]  ; 8000   \t10 A3 F8 80            CMPD   [-128,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 80            CMPD   [-128,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[127,S]  ; 8000   \t10 A3 F8 7F            CMPD   [127,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 7F            CMPD   [127,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768,X]  ; 8000   \t10 A3 99 80 00             CMPD   [-32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPD   [-32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32767,X]  ; 8000   \t10 A3 99 7F FF             CMPD   [32767,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPD   [32767,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768,Y]  ; 8000   \t10 A3 B9 80 00             CMPD   [-32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPD   [-32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32767,Y]  ; 8000   \t10 A3 B9 7F FF             CMPD   [32767,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPD   [32767,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768,U]  ; 8000   \t10 A3 D9 80 00             CMPD   [-32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPD   [-32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32767,U]  ; 8000   \t10 A3 D9 7F FF             CMPD   [32767,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPD   [32767,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768,S]  ; 8000   \t10 A3 F9 80 00             CMPD   [-32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPD   [-32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32767,S]  ; 8000   \t10 A3 F9 7F FF             CMPD   [32767,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPD   [32767,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769,X]  ; 8000   \t10 A3 99 80 00             CMPD   [-32769,X]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPD   [-32769,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32768,X]  ; 8000   \t10 A3 99 7F FF             CMPD   [32768,X]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPD   [32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769,Y]  ; 8000   \t10 A3 B9 80 00             CMPD   [-32769,Y]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPD   [-32769,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32768,Y]  ; 8000   \t10 A3 B9 7F FF             CMPD   [32768,Y]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPD   [32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769,U]  ; 8000   \t10 A3 D9 80 00             CMPD   [-32769,U]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPD   [-32769,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32768,U]  ; 8000   \t10 A3 D9 7F FF             CMPD   [32768,U]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPD   [32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769,S]  ; 8000   \t10 A3 F9 80 00             CMPD   [-32769,S]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPD   [-32769,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPDIndexedConstantIndirectMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  [32768,S]  ; 8000   \t10 A3 F9 7F FF             CMPD   [32768,S]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPD   [32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t0,PCR  ; 8000   \t10 A3 8C 00            CMPD   0,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 00            CMPD   0,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-128,PCR  ; 8000   \t10 A3 8C 80            CMPD   -128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 80            CMPD   -128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t127,PCR  ; 8000   \t10 A3 8C 7F            CMPD   127,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 7F            CMPD   127,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-129,PCR  ; 8000   \t10 A3 8D FF 7F            CMPD   -129,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D FF 7F            CMPD   -129,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t128,PCR  ; 8000   \t10 A3 8D 00 80            CMPD   128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 00 80            CMPD   128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32768,PCR  ; 8000   \t10 A3 8D 80 00            CMPD   -32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPD   -32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t32767,PCR  ; 8000   \t10 A3 8D 7F FF            CMPD   32767,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPD   32767,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t-32769,PCR  ; 8000   \t10 A3 8D 80 00            CMPD   -32769,PCR");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPD   -32769,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t32768,PCR  ; 8000   \t10 A3 8D 7F FF            CMPD   32768,PCR");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPD   32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[0,PCR]  ; 8000   \t10 A3 9C 00            CMPD   [0,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 00            CMPD   [0,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-128,PCR]  ; 8000   \t10 A3 9C 80            CMPD   [-128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 80            CMPD   [-128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[127,PCR]  ; 8000   \t10 A3 9C 7F            CMPD   [127,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 7F            CMPD   [127,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-129,PCR]  ; 8000   \t10 A3 9D FF 7F            CMPD   [-129,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D FF 7F            CMPD   [-129,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[128,PCR]  ; 8000   \t10 A3 9D 00 80            CMPD   [128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 00 80            CMPD   [128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32768,PCR]  ; 8000   \t10 A3 9D 80 00            CMPD   [-32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPD   [-32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[32767,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPD   [32767,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPD   [32767,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[-32769,PCR]  ; 8000   \t10 A3 9D 80 00            CMPD   [-32769,PCR]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPD   [-32769,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPD Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPDIndexedRelatifIndirectToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPD\t\t  \t[32768,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPD   [32768,PCR]");
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
      final AssembledCMPDInstruction line = ((AssembledCMPDInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xA3, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPD   [32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
