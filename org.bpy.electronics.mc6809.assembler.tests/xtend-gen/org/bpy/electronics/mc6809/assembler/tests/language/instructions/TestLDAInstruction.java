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
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDAInstruction;
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
public class TestLDAInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check LDA immediat
   */
  @Test
  public void testLDAImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDA\t\t  \t#124");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA direct mode
   */
  @Test
  public void testLDADirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDA\t\t  \t<124");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA extended mode
   */
  @Test
  public void testLDAExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDA\t\t  \t$1234");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA extended mode
   */
  @Test
  public void testLDAExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDA\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA extended indirect mode
   */
  @Test
  public void testLDAExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("LDA\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Constant-Offset Indexed
   */
  @Test
  public void testLDAConstantOffsetIndexed() {
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
      _builder.append("LDA\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Constant-Offset Indexed indirect
   */
  @Test
  public void testLDAConstantOffsetIndexedIndirect() {
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
      _builder.append("LDA\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Accumulator Indexed
   */
  @Test
  public void testLDAAccumulatorIndexed() {
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
      _builder.append("LDA\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Accumulator Indexed Indirect
   */
  @Test
  public void testLDAAccumulatorIndexedIndirect() {
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
      _builder.append("LDA\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LDA\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Auto-Increment Indexed
   */
  @Test
  public void testLDAAutoIncrementIndexed() {
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
      _builder.append("LDA\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,U++");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Auto-Increment Indexed Indirect
   */
  @Test
  public void testLDAAutoIncrementIndexedIndirect() {
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
      _builder.append("LDA\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Relative to PC Indexed
   */
  @Test
  public void testLDARelativePCIndexed() {
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
      _builder.append("LDA\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an LDA directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA Relative to PC Indexed Indirect
   */
  @Test
  public void testLDARelativePCIndexedIndirect() {
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
      _builder.append("LDA\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("LDA\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an A\tDC directive line", (_instruction instanceof LdInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final LdInstruction ldInstruction = ((LdInstruction) _instruction_1);
      Assert.assertEquals("Must be an LDA instruction", ldInstruction.getInstruction(), "LDA");
      EObject _operand = ldInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = ldInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LDA instruction with duplicate label
   */
  @Test
  public void testLDAWithDuplicateLabel() {
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
      _builder.append("Start      \tLDA\t\t  \t#Const+2");
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
   * Check Assembled LDA immediate instruction
   */
  @Test
  public void testLDAImmediatInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t#Const+2  ; 8000   86 07        START:    LDA");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x86, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   86 07        START:    LDA", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA immediate with limit negative operand
   */
  @Test
  public void testLDAImmediatInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t#-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA immediate with limit negative operand
   */
  @Test
  public void testLDAImmediatInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t#-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA immediate with positive limit operand
   */
  @Test
  public void testLDAImmediatInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t#127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA immediate with positive limit operand
   */
  @Test
  public void testLDAImmediatInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t#128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA direct mode instruction
   */
  @Test
  public void testLDADirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t<Const*2  ; 8000   96 0A        START:    LDA   <Const*2 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x96, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   96 0A        START:    LDA   <Const*2 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA direct with limit negative operand
   */
  @Test
  public void testLDADirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t<-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA direct with limit negative operand
   */
  @Test
  public void testLDADirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t<-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA direct with positive limit operand
   */
  @Test
  public void testLDADirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t<127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA direct with positive limit operand
   */
  @Test
  public void testLDADirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t<128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended mode instruction
   */
  @Test
  public void testLDAExtendedInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t>Const*1000  ; 8000   B6 13 88     START:    LDA   >Const*1000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xB6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   B6 13 88     START:    LDA   >Const*1000 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended with limit negative operand
   */
  @Test
  public void testLDAExtendedInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t>-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended with limit negative operand
   */
  @Test
  public void testLDAExtendedInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t>-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended with positive limit operand
   */
  @Test
  public void testLDAExtendedInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t>65535");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended with positive limit operand
   */
  @Test
  public void testLDAExtendedInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t>65536");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended indirect mode instruction
   */
  @Test
  public void testLDAExtendedIndirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[Const*1000]  ; 8000   AB 9F 13 88  START:    LDA   [Const*1000]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    LDA   [Const*1000]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended indirect with limit negative operand
   */
  @Test
  public void testLDAExtendedIndirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended indirect with limit negative operand
   */
  @Test
  public void testLDAExtendedIndirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended indirect with positive limit operand
   */
  @Test
  public void testLDAExtendedIndirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[65535]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA extended indirect with positive limit operand
   */
  @Test
  public void testLDAExtendedIndirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[65536]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tA,X  ; 8000   AB 86        START:    LDA   A,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 86        START:    LDA   A,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tA,Y  ; 8000   \tA6 A6        START:    LDA   A,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A6        START:    LDA   A,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tA,U  ; 8000   \tA6 C6        START:    LDA   A,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C6        START:    LDA   A,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tA,S  ; 8000   \tA6 E6        START:    LDA   A,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E6        START:    LDA   A,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tB,X  ; 8000   AB 85        START:    LDA   B,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 85        START:    LDA   B,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tB,Y  ; 8000   \tA6 A5        START:    LDA   B,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A5        START:    LDA   B,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tB,U  ; 8000   \tA6 C5        START:    LDA   B,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C5        START:    LDA   B,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tB,S  ; 8000   \tA6 E5        START:    LDA   B,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E5        START:    LDA   B,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tD,X  ; 8000   AB 8B        START:    LDA   D,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    LDA   D,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tD,Y  ; 8000   \tA6 AB        START:    LDA   D,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 AB        START:    LDA   D,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tD,U  ; 8000   \tA6 CB        START:    LDA   D,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 CB        START:    LDA   D,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \tD,S  ; 8000   \tA6 EB        START:    LDA   D,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 EB        START:    LDA   D,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndorectAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[A,X]  ; 8000   AB 96        START:    LDA   [A,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 96        START:    LDA   [A,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[A,Y]  ; 8000   \tA6 B6        START:    LDA   [A,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B6        START:    LDA   [A,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[A,U]  ; 8000   \tA6 D6        START:    LDA   [A,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D6        START:    LDA   [A,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[A,S]  ; 8000   \tA6 F6        START:    LDA   [A,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F6        START:    LDA   [A,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[B,X]  ; 8000   AB 95        START:    LDA   [B,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 95        START:    LDA   [B,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[B,Y]  ; 8000   \tA6 B5        START:    LDA   [B,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B5        START:    LDA   [B,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[B,U]  ; 8000   \tA6 D5        START:    LDA   [B,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D5        START:    LDA   [B,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[B,S]  ; 8000   \tA6 F5        START:    LDA   [B,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F5        START:    LDA   [B,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[D,X]  ; 8000   AB 9B        START:    LDA   [D,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    LDA   [D,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[D,Y]  ; 8000   \tA6 BB        START:    LDA   [D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 BB        START:    LDA   [D,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[D,U]  ; 8000   \tA6 DB        START:    LDA   [D,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 DB        START:    LDA   [D,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testLDAIndexedIndirectAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[D,S]  ; 8000   \tA6 FB        START:    LDA   [D,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 FB        START:    LDA   [D,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,X+  ; 8000   \tA6 80        START:    LDA   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 80        START:    LDA   ,X+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,X++  ; 8000   \tA6 81        START:    LDA   ,X++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 81        START:    LDA   ,X++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,Y+  ; 8000   \tA6 A0        START:    LDA   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A0        START:    LDA   ,Y+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,Y++  ; 8000   \tA6 A1        START:    LDA   ,Y++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A1        START:    LDA   ,Y++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,S+  ; 8000   \tA6 E0        START:    LDA   ,S+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E0        START:    LDA   ,S+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,S++  ; 8000   \tA6 E1        START:    LDA   ,S++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E1        START:    LDA   ,S++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,U+  ; 8000   \tA6 C0        START:    LDA   ,U+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C0        START:    LDA   ,U+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,U++  ; 8000   \tA6 C1        START:    LDA   ,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C1        START:    LDA   ,U++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,-X  ; 8000   \tA6 82        START:    LDA   ,-X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 82        START:    LDA   ,-X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,--X  ; 8000   \tA6 83        START:    LDA   ,--X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 83        START:    LDA   ,--X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,-Y  ; 8000   \tA6 A2        START:    LDA   ,-Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A2        START:    LDA   ,-Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,--Y  ; 8000   \tA6 A3        START:    LDA   ,--Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A3        START:    LDA   ,--Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,-S  ; 8000   \tA6 E2        START:    LDA   ,-S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E2        START:    LDA   ,-S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,--S  ; 8000   \tA6 E3        START:    LDA   ,--S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E3        START:    LDA   ,--S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,-U  ; 8000   \tA6 C2        START:    LDA   ,-U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C2        START:    LDA   ,-U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,--U  ; 8000   \tA6 C3        START:    LDA   ,--U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C3        START:    LDA   ,--U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,X+]  ; 8000   \tA6 80        START:    LDA   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,X++]  ; 8000   \tA6 91        START:    LDA   [,X++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 91        START:    LDA   [,X++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,Y+]  ; 8000   \tA6 A0        START:    LDA   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,Y++]  ; 8000   \tA6 B1        START:    LDA   [,Y++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B1        START:    LDA   [,Y++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,S+]  ; 8000   \tA6 E0        START:    LDA   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,S++]  ; 8000   \tA6 F1        START:    LDA   [,S++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F1        START:    LDA   [,S++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,U+]  ; 8000   \tA6 C0        START:    LDA   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementindirectMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,U++]  ; 8000   \tA6 D1        START:    LDA   [,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D1        START:    LDA   [,U++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,-X]  ; 8000   \tA6 82        START:    LDA   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,--X]  ; 8000   \tA6 93        START:    LDA   [,--X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 93        START:    LDA   [,--X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,-Y]  ; 8000   \tA6 A2        START:    LDA   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,--Y]  ; 8000   \tA6 B3        START:    LDA   [,--Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B3        START:    LDA   [,--Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,-S]  ; 8000   \tA6 E2        START:    LDA   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,--S]  ; 8000   \tA6 F3        START:    LDA   [,--S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F3        START:    LDA   [,--S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,-U]  ; 8000   \tA6 C2        START:    LDA   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testLDAIndexedAutoIncrementDecrementIndirectMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,--U]  ; 8000   \tA6 D3        START:    LDA   [,--U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D3        START:    LDA   [,--U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1234,X  ; 8000   \tA6 89 04 D2            LDA   1234,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 89 04 D2            LDA   1234,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1234,Y  ; 8000   \tA6 A9 04 D2            LDA   1234,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A9 04 D2            LDA   1234,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1234,U  ; 8000   \tA6 C9 04 D2            LDA   1234,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C9 04 D2            LDA   1234,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1234,S  ; 8000   \tA6 E9 04 D2            LDA   1234,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E9 04 D2            LDA   1234,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t34,X  ; 8000   \tA6 88 22            LDA   34,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 88 22            LDA   34,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t34,Y  ; 8000   \tA6 A8 22            LDA   34,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A8 22            LDA   34,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t34,U  ; 8000   \tA6 C8 22            LDA   34,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C8 22            LDA   34,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t34,S  ; 8000   \tA6 E8 22            LDA   34,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E8 22            LDA   34,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,X  ; 8000   \tA6 84            LDA   ,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 84            LDA   ,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,Y  ; 8000   \tA6 A4            LDA   ,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A4            LDA   ,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,U  ; 8000   \tA6 C4            LDA   ,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C4            LDA   ,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t,S  ; 8000   \tA6 E4            LDA   ,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E4            LDA   ,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t0,X  ; 8000   \tA6 84            LDA   0,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 84            LDA   0,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t0,Y  ; 8000   \tA6 A4            LDA   0,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A4            LDA   0,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t0,U  ; 8000   \tA6 C4            LDA   0,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C4            LDA   0,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t0,S  ; 8000   \tA6 E4            LDA   0,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E4            LDA   0,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-16,X  ; 8000   \tA6 10            LDA   -16,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 10            LDA   -16,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1,X  ; 8000   \tA6 01            LDA   1,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 01            LDA   1,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t15,X  ; 8000   \tA6 0F            LDA   15,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 0F            LDA   15,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-16,Y  ; 8000   \tA6 30            LDA   -16,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 30            LDA   -16,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1,Y  ; 8000   \tA6 21            LDA   1,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 21            LDA   1,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t15,Y  ; 8000   \tA6 2F            LDA   15,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 2F            LDA   15,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove25() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-16,U  ; 8000   \tA6 50            LDA   -16,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 50            LDA   -16,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove26() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1,U  ; 8000   \tA6 41            LDA   1,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 41            LDA   1,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove27() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t15,U  ; 8000   \tA6 4F            LDA   15,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 4F            LDA   15,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove28() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-16,S  ; 8000   \tA6 70            LDA   -16,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 70            LDA   -16,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove29() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t1,S  ; 8000   \tA6 61            LDA   1,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 61            LDA   1,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove30() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t15,S  ; 8000   \tA6 6F            LDA   15,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 6F            LDA   15,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-128,X  ; 8000   \tA6 88 80            LDA   -128,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 88 80            LDA   -128,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t127,X  ; 8000   \tA6 88 7F            LDA   127,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 88 7F            LDA   127,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-128,Y  ; 8000   \tA6 A8 80            LDA   -128,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A8 80            LDA   -128,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t127,Y  ; 8000   \tA6 A8 7F            LDA   127,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A8 7F            LDA   127,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-128,U  ; 8000   \tA6 C8 80            LDA   -128,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C8 80            LDA   -128,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t127,U  ; 8000   \tA6 C8 7F            LDA   127,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C8 7F            LDA   127,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-128,S  ; 8000   \tA6 E8 80            LDA   -128,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E8 80            LDA   -128,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t127,S  ; 8000   \tA6 E8 7F            LDA   127,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E8 7F            LDA   127,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32768,X  ; 8000   \tA6 89 80 00             LDA   -32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 89 80 00             LDA   -32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32767,X  ; 8000   \tA6 89 7F FF             LDA   32767,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 89 7F FF             LDA   32767,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32768,Y  ; 8000   \tA6 A9 80 00             LDA   -32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A9 80 00             LDA   -32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32767,Y  ; 8000   \tA6 A9 7F FF             LDA   32767,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A9 7F FF             LDA   32767,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32768,U  ; 8000   \tA6 C9 80 00             LDA   -32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C9 80 00             LDA   -32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32767,U  ; 8000   \tA6 C9 7F FF             LDA   32767,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C9 7F FF             LDA   32767,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32768,S  ; 8000   \tA6 E9 80 00             LDA   -32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E9 80 00             LDA   -32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32767,S  ; 8000   \tA6 E9 7F FF             LDA   32767,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E9 7F FF             LDA   32767,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32769,X  ; 8000   \tA6 89 80 00             LDA   -32769,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 89 80 00             LDA   -32769,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32768,X  ; 8000   \tA6 89 7F FF             LDA   32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 89 7F FF             LDA   32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32769,Y  ; 8000   \tA6 A9 80 00             LDA   -32769,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A9 80 00             LDA   -32769,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32768,Y  ; 8000   \tA6 A9 7F FF             LDA   32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 A9 7F FF             LDA   32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32769,U  ; 8000   \tA6 C9 80 00             LDA   -32769,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C9 80 00             LDA   -32769,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32768,U  ; 8000   \tA6 C9 7F FF             LDA   32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 C9 7F FF             LDA   32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32769,S  ; 8000   \tA6 E9 80 00             LDA   -32769,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E9 80 00             LDA   -32769,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  32768,S  ; 8000   \tA6 E9 7F FF             LDA   32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 E9 7F FF             LDA   32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[1234,X]  ; 8000   \tA6 99 04 D2            LDA   [1234,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 99 04 D2            LDA   [1234,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[1234,Y]  ; 8000   \tA6 B9 04 D2            LDA   [1234,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B9 04 D2            LDA   [1234,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[1234,U]  ; 8000   \tA6 D9 04 D2            LDA   [1234,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D9 04 D2            LDA   [1234,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[1234,S]  ; 8000   \tA6 F9 04 D2            LDA   [1234,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F9 04 D2            LDA   [1234,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[34,X]  ; 8000   \tA6 98 22            LDA   [34,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 98 22            LDA   [34,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[34,Y]  ; 8000   \tA6 B8 22            LDA   [34,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B8 22            LDA   [34,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[34,U]  ; 8000   \tA6 D8 22            LDA   [34,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D8 22            LDA   [34,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[34,S]  ; 8000   \tA6 F8 22            LDA   [34,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F8 22            LDA   [34,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,X]  ; 8000   \tA6 94            LDA   [,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 94            LDA   [,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,Y]  ; 8000   \tA6 B4            LDA   [,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B4            LDA   [,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,U]  ; 8000   \tA6 D4            LDA   [,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D4            LDA   [,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[,S]  ; 8000   \tA6 F4            LDA   [,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F4            LDA   [,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[0,X]  ; 8000   \tA6 94            LDA   [0,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 94            LDA   [0,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[0,Y]  ; 8000   \tA6 B4            LDA   [0,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B4            LDA   [0,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[0,U]  ; 8000   \tA6 D4            LDA   [0,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D4            LDA   [0,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[0,S]  ; 8000   \tA6 F4            LDA   [0,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F4            LDA   [0,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-16,X]  ; 8000   \tA6 98 F0            LDA   [-16,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 98 F0            LDA   [-16,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[15,X]  ; 8000   \tA6 98 0F            LDA   [15,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 98 0F            LDA   [15,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-16,Y]  ; 8000   \tA6 B8 F0            LDA   [-16,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B8 F0            LDA   [-16,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[15,Y]  ; 8000   \tA6 B8 0F            LDA   [15,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B8 0F            LDA   [15,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-16,U]  ; 8000   \tA6 D8 F0            LDA   [-16,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D8 F0            LDA   [-16,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove22() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[15,U]  ; 8000   \tA6 D8 0F            LDA   [15,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D8 0F            LDA   [15,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-16,S]  ; 8000   \tA6 F8 F0            LDA   [-16,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F8 F0            LDA   [-16,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[15,S]  ; 8000   \tA6 F8 0F            LDA   [15,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F8 0F            LDA   [15,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-128,X]  ; 8000   \tA6 98 80            LDA   [-128,X}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 98 80            LDA   [-128,X}", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[127,X]  ; 8000   \tA6 98 7F            LDA   [127,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 98 7F            LDA   [127,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-128,Y]  ; 8000   \tA6 B8 80            LDA   [-128,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B8 80            LDA   [-128,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[127,Y]  ; 8000   \tA6 B8 7F            LDA   [127,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B8 7F            LDA   [127,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-128,U]  ; 8000   \tA6 D8 80            LDA   [-128,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D8 80            LDA   [-128,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[127,U]  ; 8000   \tA6 D8 7F            LDA   [127,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D8 7F            LDA   [127,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-128,S]  ; 8000   \tA6 F8 80            LDA   [-128,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F8 80            LDA   [-128,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[127,S]  ; 8000   \tA6 F8 7F            LDA   [127,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F8 7F            LDA   [127,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768,X]  ; 8000   \tA6 99 80 00             LDA   [-32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 99 80 00             LDA   [-32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32767,X]  ; 8000   \tA6 99 7F FF             LDA   [32767,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 99 7F FF             LDA   [32767,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768,Y]  ; 8000   \tA6 B9 80 00             LDA   [-32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B9 80 00             LDA   [-32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32767,Y]  ; 8000   \tA6 B9 7F FF             LDA   [32767,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B9 7F FF             LDA   [32767,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768,U]  ; 8000   \tA6 D9 80 00             LDA   [-32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D9 80 00             LDA   [-32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32767,U]  ; 8000   \tA6 D9 7F FF             LDA   [32767,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D9 7F FF             LDA   [32767,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768,S]  ; 8000   \tA6 F9 80 00             LDA   [-32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F9 80 00             LDA   [-32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32767,S]  ; 8000   \tA6 F9 7F FF             LDA   [32767,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F9 7F FF             LDA   [32767,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769,X]  ; 8000   \tA6 99 80 00             LDA   [-32769,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 99 80 00             LDA   [-32769,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32768,X]  ; 8000   \tA6 99 7F FF             LDA   [32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 99 7F FF             LDA   [32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769,Y]  ; 8000   \tA6 B9 80 00             LDA   [-32769,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B9 80 00             LDA   [-32769,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32768,Y]  ; 8000   \tA6 B9 7F FF             LDA   [32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 B9 7F FF             LDA   [32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769,U]  ; 8000   \tA6 D9 80 00             LDA   [-32769,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D9 80 00             LDA   [-32769,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32768,U]  ; 8000   \tA6 D9 7F FF             LDA   [32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 D9 7F FF             LDA   [32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769,S]  ; 8000   \tA6 F9 80 00             LDA   [-32769,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F9 80 00             LDA   [-32769,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testLDAIndexedConstantIndirectMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  [32768,S]  ; 8000   \tA6 F9 7F FF             LDA   [32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 F9 7F FF             LDA   [32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t0,PCR  ; 8000   \tA6 8C 00            LDA   0,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8C 00            LDA   0,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-128,PCR  ; 8000   \tA6 8C 80            LDA   -128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8C 80            LDA   -128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t127,PCR  ; 8000   \tA6 8C 7F            LDA   127,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8C 7F            LDA   127,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-129,PCR  ; 8000   \tA6 8D FF 7F            LDA   -129,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D FF 7F            LDA   -129,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t128,PCR  ; 8000   \tA6 8D 00 80            LDA   128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D 00 80            LDA   128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32768,PCR  ; 8000   \tA6 8D 80 00            LDA   -32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D 80 00            LDA   -32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t32767,PCR  ; 8000   \tA6 8D 7F FF            LDA   32767,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D 7F FF            LDA   32767,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t-32769,PCR  ; 8000   \tA6 8D 80 00            LDA   -32769,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D 80 00            LDA   -32769,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t32768,PCR  ; 8000   \tA6 8D 7F FF            LDA   32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 8D 7F FF            LDA   32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[0,PCR]  ; 8000   \tA6 9C 00            LDA   [0,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9C 00            LDA   [0,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-128,PCR]  ; 8000   \tA6 9C 80            LDA   [-128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9C 80            LDA   [-128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[127,PCR]  ; 8000   \tA6 9C 7F            LDA   [127,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9C 7F            LDA   [127,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-129,PCR]  ; 8000   \tA6 9D FF 7F            LDA   [-129,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D FF 7F            LDA   [-129,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[128,PCR]  ; 8000   \tA6 9D 00 80            LDA   [128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D 00 80            LDA   [128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32768,PCR]  ; 8000   \tA6 9D 80 00            LDA   [-32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D 80 00            LDA   [-32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[32767,PCR]  ; 8000   \tA6 9D 7F FF            LDA   [32767,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D 7F FF            LDA   [32767,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[-32769,PCR]  ; 8000   \tA6 9D 80 00            LDA   [-32769,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D 80 00            LDA   [-32769,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled LDA Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testLDAIndexedRelatifIndirectToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tLDA\t\t  \t[32768,PCR]  ; 8000   \tA6 9D 7F FF            LDA   [32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getLdInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLDAInstruction line = ((AssembledLDAInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0xA6, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \tA6 9D 7F FF            LDA   [32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
