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
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Ld16Instruction;
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
public class TestLD16Instruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check LDD immediat
   */
  @Test
  public void testLDDImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDD\t\t  \t#124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD direct mode
   */
  @Test
  public void testLDDDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDD\t\t  \t<124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD extended mode
   */
  @Test
  public void testLDDExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDD\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD extended mode
   */
  @Test
  public void testLDDExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDD\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD extended indirect mode
   */
  @Test
  public void testLDDExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDD\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Constant-Offset Indexed
   */
  @Test
  public void testLDDConstantOffsetIndexed() {
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
      _builder.append("LDD\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Constant-Offset Indexed indirect
   */
  @Test
  public void testLDDConstantOffsetIndexedIndirect() {
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
      _builder.append("LDD\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Accumulator Indexed
   */
  @Test
  public void testLDDAccumulatorIndexed() {
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
      _builder.append("LDD\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Accumulator Indexed Indirect
   */
  @Test
  public void testLDDAccumulatorIndexedIndirect() {
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
      _builder.append("LDD\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDD\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Auto-Increment Indexed
   */
  @Test
  public void testLDDAutoIncrementIndexed() {
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
      _builder.append("LDD\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDDAutoIncrementIndexedIndirect() {
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
      _builder.append("LDD\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Relative to PC Indexed
   */
  @Test
  public void testLDDRelativePCIndexed() {
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
      _builder.append("LDD\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDD Relative to PC Indexed Indirect
   */
  @Test
  public void testLDDRelativePCIndexedIndirect() {
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
      _builder.append("LDD\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDD\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDD instruction", ld16Instruction.getInstruction(), "LDD");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX immediat
   */
  @Test
  public void testLDXImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDX\t\t  \t#124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX direct mode
   */
  @Test
  public void testLDXDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDX\t\t  \t<124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX extended mode
   */
  @Test
  public void testLDXExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDX\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX extended mode
   */
  @Test
  public void testLDXExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDX\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX extended indirect mode
   */
  @Test
  public void testLDXExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDX\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Constant-Offset Indexed
   */
  @Test
  public void testLDXConstantOffsetIndexed() {
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
      _builder.append("LDX\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Constant-Offset Indexed indirect
   */
  @Test
  public void testLDXConstantOffsetIndexedIndirect() {
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
      _builder.append("LDX\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Accumulator Indexed
   */
  @Test
  public void testLDXAccumulatorIndexed() {
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
      _builder.append("LDX\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Accumulator Indexed Indirect
   */
  @Test
  public void testLDXAccumulatorIndexedIndirect() {
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
      _builder.append("LDX\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDX\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Auto-Increment Indexed
   */
  @Test
  public void testLDXAutoIncrementIndexed() {
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
      _builder.append("LDX\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDXAutoIncrementIndexedIndirect() {
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
      _builder.append("LDX\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Relative to PC Indexed
   */
  @Test
  public void testLDXRelativePCIndexed() {
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
      _builder.append("LDX\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDX Relative to PC Indexed Indirect
   */
  @Test
  public void testLDXRelativePCIndexedIndirect() {
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
      _builder.append("LDX\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDX\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDX instruction", ld16Instruction.getInstruction(), "LDX");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY immediat
   */
  @Test
  public void testLDYImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDY\t\t  \t#124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY direct mode
   */
  @Test
  public void testLDYDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDY\t\t  \t<124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY extended mode
   */
  @Test
  public void testLDYExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDY\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY extended mode
   */
  @Test
  public void testLDYExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDY\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY extended indirect mode
   */
  @Test
  public void testLDYExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDY\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Constant-Offset Indexed
   */
  @Test
  public void testLDYConstantOffsetIndexed() {
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
      _builder.append("LDY\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Constant-Offset Indexed indirect
   */
  @Test
  public void testLDYConstantOffsetIndexedIndirect() {
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
      _builder.append("LDY\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Accumulator Indexed
   */
  @Test
  public void testLDYAccumulatorIndexed() {
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
      _builder.append("LDY\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Accumulator Indexed Indirect
   */
  @Test
  public void testLDYAccumulatorIndexedIndirect() {
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
      _builder.append("LDY\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDY\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Auto-Increment Indexed
   */
  @Test
  public void testLDYAutoIncrementIndexed() {
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
      _builder.append("LDY\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDYAutoIncrementIndexedIndirect() {
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
      _builder.append("LDY\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Relative to PC Indexed
   */
  @Test
  public void testLDYRelativePCIndexed() {
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
      _builder.append("LDY\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDY Relative to PC Indexed Indirect
   */
  @Test
  public void testLDYRelativePCIndexedIndirect() {
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
      _builder.append("LDY\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDY\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDY instruction", ld16Instruction.getInstruction(), "LDY");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS immediat
   */
  @Test
  public void testLDSImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDS\t\t  \t#124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS direct mode
   */
  @Test
  public void testLDSDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDS\t\t  \t<124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS extended mode
   */
  @Test
  public void testLDSExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDS\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS extended mode
   */
  @Test
  public void testLDSExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDS\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS extended indirect mode
   */
  @Test
  public void testLDSExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDS\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Constant-Offset Indexed
   */
  @Test
  public void testLDSConstantOffsetIndexed() {
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
      _builder.append("LDS\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Constant-Offset Indexed indirect
   */
  @Test
  public void testLDSConstantOffsetIndexedIndirect() {
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
      _builder.append("LDS\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Accumulator Indexed
   */
  @Test
  public void testLDSAccumulatorIndexed() {
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
      _builder.append("LDS\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Accumulator Indexed Indirect
   */
  @Test
  public void testLDSAccumulatorIndexedIndirect() {
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
      _builder.append("LDS\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDS\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Auto-Increment Indexed
   */
  @Test
  public void testLDSAutoIncrementIndexed() {
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
      _builder.append("LDS\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDSAutoIncrementIndexedIndirect() {
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
      _builder.append("LDS\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Relative to PC Indexed
   */
  @Test
  public void testLDSRelativePCIndexed() {
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
      _builder.append("LDS\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDS Relative to PC Indexed Indirect
   */
  @Test
  public void testLDSRelativePCIndexedIndirect() {
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
      _builder.append("LDS\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDS\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDS instruction", ld16Instruction.getInstruction(), "LDS");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU immediat
   */
  @Test
  public void testLDUImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDU\t\t  \t#124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU direct mode
   */
  @Test
  public void testLDUDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDU\t\t  \t<124");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU extended mode
   */
  @Test
  public void testLDUExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDU\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU extended mode
   */
  @Test
  public void testLDUExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDU\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU extended indirect mode
   */
  @Test
  public void testLDUExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDU\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Constant-Offset Indexed
   */
  @Test
  public void testLDUConstantOffsetIndexed() {
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
      _builder.append("LDU\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Constant-Offset Indexed indirect
   */
  @Test
  public void testLDUConstantOffsetIndexedIndirect() {
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
      _builder.append("LDU\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Accumulator Indexed
   */
  @Test
  public void testLDUAccumulatorIndexed() {
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
      _builder.append("LDU\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Accumulator Indexed Indirect
   */
  @Test
  public void testLDUAccumulatorIndexedIndirect() {
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
      _builder.append("LDU\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDU\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Auto-Increment Indexed
   */
  @Test
  public void testLDUAutoIncrementIndexed() {
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
      _builder.append("LDU\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDUAutoIncrementIndexedIndirect() {
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
      _builder.append("LDU\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Relative to PC Indexed
   */
  @Test
  public void testLDURelativePCIndexed() {
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
      _builder.append("LDU\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDU Relative to PC Indexed Indirect
   */
  @Test
  public void testLDURelativePCIndexedIndirect() {
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
      _builder.append("LDU\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDU\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an LD16 directive line", (_instruction instanceof Ld16Instruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final Ld16Instruction ld16Instruction = ((Ld16Instruction) _instruction_1);
      Assert.assertEquals("Must be an LDU instruction", ld16Instruction.getInstruction(), "LDU");
      EObject _operand = ld16Instruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ld16Instruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
