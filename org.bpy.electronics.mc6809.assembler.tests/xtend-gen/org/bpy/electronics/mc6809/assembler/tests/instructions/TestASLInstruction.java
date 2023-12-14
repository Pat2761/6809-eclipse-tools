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
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
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
public class TestASLInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check ASL direct mode
   */
  @Test
  public void testASLDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ASL\t\t  \t<124");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL extended mode
   */
  @Test
  public void testASLExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ASL\t\t  \t$1234");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL extended mode
   */
  @Test
  public void testASLExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ASL\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL extended indirect mode
   */
  @Test
  public void testASLExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ASL\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Constant-Offset Indexed
   */
  @Test
  public void testASLConstantOffsetIndexed() {
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
      _builder.append("ASL\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Constant-Offset Indexed indirect
   */
  @Test
  public void testASLConstantOffsetIndexedIndirect() {
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
      _builder.append("ASL\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Accumulator Indexed
   */
  @Test
  public void testASLAccumulatorIndexed() {
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
      _builder.append("ASL\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Accumulator Indexed Indirect
   */
  @Test
  public void testASLAccumulatorIndexedIndirect() {
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
      _builder.append("ASL\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASL\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Auto-Increment Indexed
   */
  @Test
  public void testASLAutoIncrementIndexed() {
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
      _builder.append("ASL\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,U++");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Auto-Increment Indexed Indirect
   */
  @Test
  public void testASLAutoIncrementIndexedIndirect() {
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
      _builder.append("ASL\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Relative to PC Indexed
   */
  @Test
  public void testASLRelativePCIndexed() {
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
      _builder.append("ASL\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL Relative to PC Indexed Indirect
   */
  @Test
  public void testASLRelativePCIndexedIndirect() {
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
      _builder.append("ASL\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ASL\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an ASL directive line", (_instruction instanceof AslInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AslInstruction aslInstruction = ((AslInstruction) _instruction_1);
      Assert.assertEquals("Must be an ASL instruction", aslInstruction.getInstruction(), "ASL");
      EObject _operand = aslInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = aslInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ASL instruction with duplicate label
   */
  @Test
  public void testASLWithDuplicateLabel() {
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
      _builder.append("Start      \tASL\t\t  \t\t<Const+2");
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
  public void testASLWithImmediateMode() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL direct mode instruction
   */
  @Test
  public void testASLDirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL direct with limit negative operand
   */
  @Test
  public void testASLDirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL direct with limit negative operand
   */
  @Test
  public void testASLDirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL direct with positive limit operand
   */
  @Test
  public void testASLDirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL direct with positive limit operand
   */
  @Test
  public void testASLDirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended mode instruction
   */
  @Test
  public void testASLExtendedInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL extended with limit negative operand
   */
  @Test
  public void testASLExtendedInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended with limit negative operand
   */
  @Test
  public void testASLExtendedInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended with positive limit operand
   */
  @Test
  public void testASLExtendedInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended with positive limit operand
   */
  @Test
  public void testASLExtendedInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended indirect mode instruction
   */
  @Test
  public void testASLExtendedIndirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL extended indirect with limit negative operand
   */
  @Test
  public void testASLExtendedIndirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended indirect with limit negative operand
   */
  @Test
  public void testASLExtendedIndirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended indirect with positive limit operand
   */
  @Test
  public void testASLExtendedIndirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL extended indirect with positive limit operand
   */
  @Test
  public void testASLExtendedIndirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndorectAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testASLIndexedIndirectAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,X+]  ; 8000   \t68 80        START:    ASL   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,Y+]  ; 8000   \t68 A0        START:    ASL   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,S+]  ; 8000   \t68 E0        START:    ASL   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,U+]  ; 8000   \t68 C0        START:    ASL   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementindirectMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,-X]  ; 8000   \t68 82        START:    ASL   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,-Y]  ; 8000   \t68 A2        START:    ASL   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,-S]  ; 8000   \t68 E2        START:    ASL   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tASL\t\t  \t[,-U]  ; 8000   \t68 C2        START:    ASL   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getAslInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ASL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testASLIndexedAutoIncrementDecrementIndirectMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove25() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove26() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove27() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove28() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove29() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove30() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove18() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove22() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testASLIndexedConstantIndirectMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
   * Check Assembled ASL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testASLIndexedRelatifIndirectToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledASLInstruction cannot be resolved to a type."
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
