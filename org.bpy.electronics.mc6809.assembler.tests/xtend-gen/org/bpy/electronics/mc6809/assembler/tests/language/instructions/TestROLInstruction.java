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
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledROLInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
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
public class TestROLInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check ROL direct mode
   */
  @Test
  public void testROLDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ROL\t\t  \t<124");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL extended mode
   */
  @Test
  public void testROLExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ROL\t\t  \t$1234");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL extended mode
   */
  @Test
  public void testROLExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ROL\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL extended indirect mode
   */
  @Test
  public void testROLExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ROL\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Constant-Offset Indexed
   */
  @Test
  public void testROLConstantOffsetIndexed() {
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
      _builder.append("ROL\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Constant-Offset Indexed indirect
   */
  @Test
  public void testROLConstantOffsetIndexedIndirect() {
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
      _builder.append("ROL\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Accumulator Indexed
   */
  @Test
  public void testROLAccumulatorIndexed() {
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
      _builder.append("ROL\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Accumulator Indexed Indirect
   */
  @Test
  public void testROLAccumulatorIndexedIndirect() {
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
      _builder.append("ROL\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ROL\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Auto-Increment Indexed
   */
  @Test
  public void testROLAutoIncrementIndexed() {
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
      _builder.append("ROL\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,U++");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Auto-Increment Indexed Indirect
   */
  @Test
  public void testROLAutoIncrementIndexedIndirect() {
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
      _builder.append("ROL\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Relative to PC Indexed
   */
  @Test
  public void testROLRelativePCIndexed() {
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
      _builder.append("ROL\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL Relative to PC Indexed Indirect
   */
  @Test
  public void testROLRelativePCIndexedIndirect() {
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
      _builder.append("ROL\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ROL\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an ROL directive line", (_instruction instanceof RolInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final RolInstruction rolInstruction = ((RolInstruction) _instruction_1);
      Assert.assertEquals("Must be an ROL instruction", rolInstruction.getInstruction(), "ROL");
      EObject _operand = rolInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = rolInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ROL instruction with duplicate label
   */
  @Test
  public void testROLWithDuplicateLabel() {
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
      _builder.append("Start      \tROL\t\t  \t\t<Const+2");
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
  public void testROLWithImmediateMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t\t#25           ; Check illegal mode");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Immediate mode is not valid for the ROL instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check State", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check Opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check Operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; Check illegal mode", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL direct mode instruction
   */
  @Test
  public void testROLDirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t<Const*2  ; 8000   09 0A        START:    ROL   <Const*2 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x09, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   09 0A        START:    ROL   <Const*2 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL direct with limit negative operand
   */
  @Test
  public void testROLDirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t<-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL direct with limit negative operand
   */
  @Test
  public void testROLDirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t<-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL direct with positive limit operand
   */
  @Test
  public void testROLDirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t<127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL direct with positive limit operand
   */
  @Test
  public void testROLDirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t<128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended mode instruction
   */
  @Test
  public void testROLExtendedInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t>Const*1000  ; 8000   79 13 88     START:    ROL   >Const*1000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x79, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   79 13 88     START:    ROL   >Const*1000 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended with limit negative operand
   */
  @Test
  public void testROLExtendedInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t>-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended with limit negative operand
   */
  @Test
  public void testROLExtendedInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t>-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended with positive limit operand
   */
  @Test
  public void testROLExtendedInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t>65535");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended with positive limit operand
   */
  @Test
  public void testROLExtendedInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t>65536");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended indirect mode instruction
   */
  @Test
  public void testROLExtendedIndirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[Const*1000]  ; 8000   AB 9F 13 88  START:    ROL   [Const*1000]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    ROL   [Const*1000]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended indirect with limit negative operand
   */
  @Test
  public void testROLExtendedIndirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended indirect with limit negative operand
   */
  @Test
  public void testROLExtendedIndirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended indirect with positive limit operand
   */
  @Test
  public void testROLExtendedIndirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[65535]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL extended indirect with positive limit operand
   */
  @Test
  public void testROLExtendedIndirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[65536]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tA,X  ; 8000   AB 86        START:    ROL   A,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 86        START:    ROL   A,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tA,Y  ; 8000   \t69 A6        START:    ROL   A,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A6        START:    ROL   A,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tA,U  ; 8000   \t69 C6        START:    ROL   A,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C6        START:    ROL   A,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tA,S  ; 8000   \t69 E6        START:    ROL   A,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E6        START:    ROL   A,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tB,X  ; 8000   AB 85        START:    ROL   B,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 85        START:    ROL   B,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tB,Y  ; 8000   \t69 A5        START:    ROL   B,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A5        START:    ROL   B,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tB,U  ; 8000   \t69 C5        START:    ROL   B,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C5        START:    ROL   B,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tB,S  ; 8000   \t69 E5        START:    ROL   B,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E5        START:    ROL   B,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tD,X  ; 8000   AB 8B        START:    ROL   D,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    ROL   D,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tD,Y  ; 8000   \t69 AB        START:    ROL   D,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 AB        START:    ROL   D,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tD,U  ; 8000   \t69 CB        START:    ROL   D,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 CB        START:    ROL   D,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \tD,S  ; 8000   \t69 EB        START:    ROL   D,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 EB        START:    ROL   D,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndorectAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[A,X]  ; 8000   AB 96        START:    ROL   [A,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 96        START:    ROL   [A,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[A,Y]  ; 8000   \t69 B6        START:    ROL   [A,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B6        START:    ROL   [A,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[A,U]  ; 8000   \t69 D6        START:    ROL   [A,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D6        START:    ROL   [A,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[A,S]  ; 8000   \t69 F6        START:    ROL   [A,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F6        START:    ROL   [A,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[B,X]  ; 8000   AB 95        START:    ROL   [B,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 95        START:    ROL   [B,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[B,Y]  ; 8000   \t69 B5        START:    ROL   [B,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B5        START:    ROL   [B,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[B,U]  ; 8000   \t69 D5        START:    ROL   [B,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D5        START:    ROL   [B,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[B,S]  ; 8000   \t69 F5        START:    ROL   [B,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F5        START:    ROL   [B,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[D,X]  ; 8000   AB 9B        START:    ROL   [D,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    ROL   [D,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[D,Y]  ; 8000   \t69 BB        START:    ROL   [D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 BB        START:    ROL   [D,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[D,U]  ; 8000   \t69 DB        START:    ROL   [D,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 DB        START:    ROL   [D,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testROLIndexedIndirectAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[D,S]  ; 8000   \t69 FB        START:    ROL   [D,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 FB        START:    ROL   [D,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,X+  ; 8000   \t69 80        START:    ROL   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 80        START:    ROL   ,X+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,X++  ; 8000   \t69 81        START:    ROL   ,X++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 81        START:    ROL   ,X++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,Y+  ; 8000   \t69 A0        START:    ROL   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A0        START:    ROL   ,Y+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,Y++  ; 8000   \t69 A1        START:    ROL   ,Y++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A1        START:    ROL   ,Y++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,S+  ; 8000   \t69 E0        START:    ROL   ,S+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E0        START:    ROL   ,S+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,S++  ; 8000   \t69 E1        START:    ROL   ,S++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E1        START:    ROL   ,S++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,U+  ; 8000   \t69 C0        START:    ROL   ,U+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C0        START:    ROL   ,U+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,U++  ; 8000   \t69 C1        START:    ROL   ,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C1        START:    ROL   ,U++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,-X  ; 8000   \t69 82        START:    ROL   ,-X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 82        START:    ROL   ,-X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,--X  ; 8000   \t69 83        START:    ROL   ,--X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 83        START:    ROL   ,--X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,-Y  ; 8000   \t69 A2        START:    ROL   ,-Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A2        START:    ROL   ,-Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,--Y  ; 8000   \t69 A3        START:    ROL   ,--Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A3        START:    ROL   ,--Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,-S  ; 8000   \t69 E2        START:    ROL   ,-S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E2        START:    ROL   ,-S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,--S  ; 8000   \t69 E3        START:    ROL   ,--S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E3        START:    ROL   ,--S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,-U  ; 8000   \t69 C2        START:    ROL   ,-U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C2        START:    ROL   ,-U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,--U  ; 8000   \t69 C3        START:    ROL   ,--U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C3        START:    ROL   ,--U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,X+]  ; 8000   \t69 80        START:    ROL   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,X++]  ; 8000   \t69 91        START:    ROL   [,X++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 91        START:    ROL   [,X++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,Y+]  ; 8000   \t69 A0        START:    ROL   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,Y++]  ; 8000   \t69 B1        START:    ROL   [,Y++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B1        START:    ROL   [,Y++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,S+]  ; 8000   \t69 E0        START:    ROL   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,S++]  ; 8000   \t69 F1        START:    ROL   [,S++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F1        START:    ROL   [,S++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,U+]  ; 8000   \t69 C0        START:    ROL   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementindirectMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,U++]  ; 8000   \t69 D1        START:    ROL   [,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D1        START:    ROL   [,U++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,-X]  ; 8000   \t69 82        START:    ROL   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,--X]  ; 8000   \t69 93        START:    ROL   [,--X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 93        START:    ROL   [,--X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,-Y]  ; 8000   \t69 A2        START:    ROL   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,--Y]  ; 8000   \t69 B3        START:    ROL   [,--Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B3        START:    ROL   [,--Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,-S]  ; 8000   \t69 E2        START:    ROL   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,--S]  ; 8000   \t69 F3        START:    ROL   [,--S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F3        START:    ROL   [,--S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,-U]  ; 8000   \t69 C2        START:    ROL   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testROLIndexedAutoIncrementDecrementIndirectMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,--U]  ; 8000   \t69 D3        START:    ROL   [,--U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D3        START:    ROL   [,--U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1234,X  ; 8000   \t69 89 04 D2            ROL   1234,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 89 04 D2            ROL   1234,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1234,Y  ; 8000   \t69 A9 04 D2            ROL   1234,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A9 04 D2            ROL   1234,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1234,U  ; 8000   \t69 C9 04 D2            ROL   1234,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C9 04 D2            ROL   1234,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1234,S  ; 8000   \t69 E9 04 D2            ROL   1234,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E9 04 D2            ROL   1234,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t34,X  ; 8000   \t69 88 22            ROL   34,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 88 22            ROL   34,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t34,Y  ; 8000   \t69 A8 22            ROL   34,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A8 22            ROL   34,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t34,U  ; 8000   \t69 C8 22            ROL   34,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C8 22            ROL   34,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t34,S  ; 8000   \t69 E8 22            ROL   34,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E8 22            ROL   34,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,X  ; 8000   \t69 84            ROL   ,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 84            ROL   ,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,Y  ; 8000   \t69 A4            ROL   ,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A4            ROL   ,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,U  ; 8000   \t69 C4            ROL   ,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C4            ROL   ,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t,S  ; 8000   \t69 E4            ROL   ,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E4            ROL   ,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t0,X  ; 8000   \t69 84            ROL   0,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 84            ROL   0,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t0,Y  ; 8000   \t69 A4            ROL   0,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A4            ROL   0,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t0,U  ; 8000   \t69 C4            ROL   0,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C4            ROL   0,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t0,S  ; 8000   \t69 E4            ROL   0,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E4            ROL   0,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-16,X  ; 8000   \t69 10            ROL   -16,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 10            ROL   -16,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1,X  ; 8000   \t69 01            ROL   1,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 01            ROL   1,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t15,X  ; 8000   \t69 0F            ROL   15,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 0F            ROL   15,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-16,Y  ; 8000   \t69 30            ROL   -16,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 30            ROL   -16,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1,Y  ; 8000   \t69 21            ROL   1,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 21            ROL   1,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t15,Y  ; 8000   \t69 2F            ROL   15,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 2F            ROL   15,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove25() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-16,U  ; 8000   \t69 50            ROL   -16,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 50            ROL   -16,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove26() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1,U  ; 8000   \t69 41            ROL   1,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 41            ROL   1,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove27() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t15,U  ; 8000   \t69 4F            ROL   15,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 4F            ROL   15,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove28() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-16,S  ; 8000   \t69 70            ROL   -16,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 70            ROL   -16,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove29() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t1,S  ; 8000   \t69 61            ROL   1,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 61            ROL   1,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove30() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t15,S  ; 8000   \t69 6F            ROL   15,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 6F            ROL   15,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-128,X  ; 8000   \t69 88 80            ROL   -128,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 88 80            ROL   -128,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t127,X  ; 8000   \t69 88 7F            ROL   127,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 88 7F            ROL   127,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-128,Y  ; 8000   \t69 A8 80            ROL   -128,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A8 80            ROL   -128,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t127,Y  ; 8000   \t69 A8 7F            ROL   127,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A8 7F            ROL   127,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-128,U  ; 8000   \t69 C8 80            ROL   -128,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C8 80            ROL   -128,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t127,U  ; 8000   \t69 C8 7F            ROL   127,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C8 7F            ROL   127,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-128,S  ; 8000   \t69 E8 80            ROL   -128,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E8 80            ROL   -128,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t127,S  ; 8000   \t69 E8 7F            ROL   127,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E8 7F            ROL   127,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32768,X  ; 8000   \t69 89 80 00             ROL   -32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 89 80 00             ROL   -32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32767,X  ; 8000   \t69 89 7F FF             ROL   32767,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 89 7F FF             ROL   32767,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32768,Y  ; 8000   \t69 A9 80 00             ROL   -32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A9 80 00             ROL   -32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32767,Y  ; 8000   \t69 A9 7F FF             ROL   32767,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A9 7F FF             ROL   32767,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32768,U  ; 8000   \t69 C9 80 00             ROL   -32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C9 80 00             ROL   -32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32767,U  ; 8000   \t69 C9 7F FF             ROL   32767,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C9 7F FF             ROL   32767,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32768,S  ; 8000   \t69 E9 80 00             ROL   -32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E9 80 00             ROL   -32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32767,S  ; 8000   \t69 E9 7F FF             ROL   32767,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E9 7F FF             ROL   32767,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32769,X  ; 8000   \t69 89 80 00             ROL   -32769,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 89 80 00             ROL   -32769,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32768,X  ; 8000   \t69 89 7F FF             ROL   32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 89 7F FF             ROL   32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32769,Y  ; 8000   \t69 A9 80 00             ROL   -32769,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A9 80 00             ROL   -32769,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32768,Y  ; 8000   \t69 A9 7F FF             ROL   32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 A9 7F FF             ROL   32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32769,U  ; 8000   \t69 C9 80 00             ROL   -32769,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C9 80 00             ROL   -32769,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32768,U  ; 8000   \t69 C9 7F FF             ROL   32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 C9 7F FF             ROL   32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32769,S  ; 8000   \t69 E9 80 00             ROL   -32769,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E9 80 00             ROL   -32769,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  32768,S  ; 8000   \t69 E9 7F FF             ROL   32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 E9 7F FF             ROL   32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[1234,X]  ; 8000   \t69 99 04 D2            ROL   [1234,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 99 04 D2            ROL   [1234,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[1234,Y]  ; 8000   \t69 B9 04 D2            ROL   [1234,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B9 04 D2            ROL   [1234,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[1234,U]  ; 8000   \t69 D9 04 D2            ROL   [1234,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D9 04 D2            ROL   [1234,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[1234,S]  ; 8000   \t69 F9 04 D2            ROL   [1234,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F9 04 D2            ROL   [1234,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[34,X]  ; 8000   \t69 98 22            ROL   [34,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 98 22            ROL   [34,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[34,Y]  ; 8000   \t69 B8 22            ROL   [34,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B8 22            ROL   [34,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[34,U]  ; 8000   \t69 D8 22            ROL   [34,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D8 22            ROL   [34,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[34,S]  ; 8000   \t69 F8 22            ROL   [34,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F8 22            ROL   [34,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,X]  ; 8000   \t69 94            ROL   [,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 94            ROL   [,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,Y]  ; 8000   \t69 B4            ROL   [,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B4            ROL   [,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,U]  ; 8000   \t69 D4            ROL   [,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D4            ROL   [,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[,S]  ; 8000   \t69 F4            ROL   [,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F4            ROL   [,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[0,X]  ; 8000   \t69 94            ROL   [0,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 94            ROL   [0,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[0,Y]  ; 8000   \t69 B4            ROL   [0,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B4            ROL   [0,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[0,U]  ; 8000   \t69 D4            ROL   [0,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D4            ROL   [0,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[0,S]  ; 8000   \t69 F4            ROL   [0,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F4            ROL   [0,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-16,X]  ; 8000   \t69 98 F0            ROL   [-16,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 98 F0            ROL   [-16,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[15,X]  ; 8000   \t69 98 0F            ROL   [15,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 98 0F            ROL   [15,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-16,Y]  ; 8000   \t69 B8 F0            ROL   [-16,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B8 F0            ROL   [-16,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[15,Y]  ; 8000   \t69 B8 0F            ROL   [15,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B8 0F            ROL   [15,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-16,U]  ; 8000   \t69 D8 F0            ROL   [-16,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D8 F0            ROL   [-16,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove22() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[15,U]  ; 8000   \t69 D8 0F            ROL   [15,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D8 0F            ROL   [15,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-16,S]  ; 8000   \t69 F8 F0            ROL   [-16,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F8 F0            ROL   [-16,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[15,S]  ; 8000   \t69 F8 0F            ROL   [15,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F8 0F            ROL   [15,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-128,X]  ; 8000   \t69 98 80            ROL   [-128,X}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 98 80            ROL   [-128,X}", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[127,X]  ; 8000   \t69 98 7F            ROL   [127,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 98 7F            ROL   [127,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-128,Y]  ; 8000   \t69 B8 80            ROL   [-128,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B8 80            ROL   [-128,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[127,Y]  ; 8000   \t69 B8 7F            ROL   [127,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B8 7F            ROL   [127,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-128,U]  ; 8000   \t69 D8 80            ROL   [-128,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D8 80            ROL   [-128,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[127,U]  ; 8000   \t69 D8 7F            ROL   [127,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D8 7F            ROL   [127,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-128,S]  ; 8000   \t69 F8 80            ROL   [-128,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F8 80            ROL   [-128,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[127,S]  ; 8000   \t69 F8 7F            ROL   [127,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F8 7F            ROL   [127,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768,X]  ; 8000   \t69 99 80 00             ROL   [-32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 99 80 00             ROL   [-32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32767,X]  ; 8000   \t69 99 7F FF             ROL   [32767,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 99 7F FF             ROL   [32767,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768,Y]  ; 8000   \t69 B9 80 00             ROL   [-32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B9 80 00             ROL   [-32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32767,Y]  ; 8000   \t69 B9 7F FF             ROL   [32767,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B9 7F FF             ROL   [32767,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768,U]  ; 8000   \t69 D9 80 00             ROL   [-32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D9 80 00             ROL   [-32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32767,U]  ; 8000   \t69 D9 7F FF             ROL   [32767,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D9 7F FF             ROL   [32767,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768,S]  ; 8000   \t69 F9 80 00             ROL   [-32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F9 80 00             ROL   [-32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32767,S]  ; 8000   \t69 F9 7F FF             ROL   [32767,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F9 7F FF             ROL   [32767,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769,X]  ; 8000   \t69 99 80 00             ROL   [-32769,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 99 80 00             ROL   [-32769,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32768,X]  ; 8000   \t69 99 7F FF             ROL   [32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 99 7F FF             ROL   [32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769,Y]  ; 8000   \t69 B9 80 00             ROL   [-32769,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B9 80 00             ROL   [-32769,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32768,Y]  ; 8000   \t69 B9 7F FF             ROL   [32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 B9 7F FF             ROL   [32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769,U]  ; 8000   \t69 D9 80 00             ROL   [-32769,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D9 80 00             ROL   [-32769,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32768,U]  ; 8000   \t69 D9 7F FF             ROL   [32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 D9 7F FF             ROL   [32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769,S]  ; 8000   \t69 F9 80 00             ROL   [-32769,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value -32769 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F9 80 00             ROL   [-32769,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testROLIndexedConstantIndirectMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  [32768,S]  ; 8000   \t69 F9 7F FF             ROL   [32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "Overflow detected for value 32768 , data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 F9 7F FF             ROL   [32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t0,PCR  ; 8000   \t69 8C 00            ROL   0,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8C 00            ROL   0,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-128,PCR  ; 8000   \t69 8C 80            ROL   -128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8C 80            ROL   -128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t127,PCR  ; 8000   \t69 8C 7F            ROL   127,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8C 7F            ROL   127,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-129,PCR  ; 8000   \t69 8D FF 7F            ROL   -129,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D FF 7F            ROL   -129,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t128,PCR  ; 8000   \t69 8D 00 80            ROL   128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D 00 80            ROL   128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32768,PCR  ; 8000   \t69 8D 80 00            ROL   -32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D 80 00            ROL   -32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t32767,PCR  ; 8000   \t69 8D 7F FF            ROL   32767,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D 7F FF            ROL   32767,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t-32769,PCR  ; 8000   \t69 8D 80 00            ROL   -32769,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D 80 00            ROL   -32769,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t32768,PCR  ; 8000   \t69 8D 7F FF            ROL   32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 8D 7F FF            ROL   32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[0,PCR]  ; 8000   \t69 9C 00            ROL   [0,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9C 00            ROL   [0,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-128,PCR]  ; 8000   \t69 9C 80            ROL   [-128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9C 80            ROL   [-128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[127,PCR]  ; 8000   \t69 9C 7F            ROL   [127,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9C 7F            ROL   [127,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-129,PCR]  ; 8000   \t69 9D FF 7F            ROL   [-129,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D FF 7F            ROL   [-129,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[128,PCR]  ; 8000   \t69 9D 00 80            ROL   [128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D 00 80            ROL   [128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32768,PCR]  ; 8000   \t69 9D 80 00            ROL   [-32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D 80 00            ROL   [-32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[32767,PCR]  ; 8000   \t69 9D 7F FF            ROL   [32767,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D 7F FF            ROL   [32767,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[-32769,PCR]  ; 8000   \t69 9D 80 00            ROL   [-32769,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value -32769 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D 80 00            ROL   [-32769,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testROLIndexedRelatifIndirectToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tROL\t\t  \t[32768,PCR]  ; 8000   \t69 9D 7F FF            ROL   [32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getRolInstruction(), 
        AbstractInstructionAssemblyLine.OVERFLOW_ERROR, 
        "The value 32768 is out than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledROLInstruction line = ((AssembledROLInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x69, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t69 9D 7F FF            ROL   [32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
