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
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
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
public class TestINCInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check INC direct mode
   */
  @Test
  public void testINCDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INC\t\t  \t<124");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC extended mode
   */
  @Test
  public void testINCExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INC\t\t  \t$1234");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC extended mode
   */
  @Test
  public void testINCExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INC\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC extended indirect mode
   */
  @Test
  public void testINCExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INC\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Constant-Offset Indexed
   */
  @Test
  public void testINCConstantOffsetIndexed() {
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
      _builder.append("INC\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Constant-Offset Indexed indirect
   */
  @Test
  public void testINCConstantOffsetIndexedIndirect() {
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
      _builder.append("INC\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Accumulator Indexed
   */
  @Test
  public void testINCAccumulatorIndexed() {
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
      _builder.append("INC\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Accumulator Indexed Indirect
   */
  @Test
  public void testINCAccumulatorIndexedIndirect() {
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
      _builder.append("INC\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("INC\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Auto-Increment Indexed
   */
  @Test
  public void testINCAutoIncrementIndexed() {
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
      _builder.append("INC\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,U++");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Auto-Increment Indexed Indirect
   */
  @Test
  public void testINCAutoIncrementIndexedIndirect() {
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
      _builder.append("INC\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Relative to PC Indexed
   */
  @Test
  public void testINCRelativePCIndexed() {
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
      _builder.append("INC\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC Relative to PC Indexed Indirect
   */
  @Test
  public void testINCRelativePCIndexedIndirect() {
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
      _builder.append("INC\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an INC directive line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INC instruction", incInstruction.getInstruction(), "INC");
      EObject _operand = incInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = incInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INC instruction with duplicate label
   */
  @Test
  public void testINCWithDuplicateLabel() {
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
      _builder.append("Start      \tINC\t\t  \t\t<Const+2");
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
  public void testINCWithImmediateMode() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC direct mode instruction
   */
  @Test
  public void testINCDirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC direct with limit negative operand
   */
  @Test
  public void testINCDirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC direct with limit negative operand
   */
  @Test
  public void testINCDirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC direct with positive limit operand
   */
  @Test
  public void testINCDirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC direct with positive limit operand
   */
  @Test
  public void testINCDirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended mode instruction
   */
  @Test
  public void testINCExtendedInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC extended with limit negative operand
   */
  @Test
  public void testINCExtendedInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended with limit negative operand
   */
  @Test
  public void testINCExtendedInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended with positive limit operand
   */
  @Test
  public void testINCExtendedInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended with positive limit operand
   */
  @Test
  public void testINCExtendedInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended indirect mode instruction
   */
  @Test
  public void testINCExtendedIndirectInstruction1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC extended indirect with limit negative operand
   */
  @Test
  public void testINCExtendedIndirectInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended indirect with limit negative operand
   */
  @Test
  public void testINCExtendedIndirectInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended indirect with positive limit operand
   */
  @Test
  public void testINCExtendedIndirectInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC extended indirect with positive limit operand
   */
  @Test
  public void testINCExtendedIndirectInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved"
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndorectAccumulatorMovingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testINCIndexedIndirectAccumulatorMovingMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,X+]  ; 8000   \t6C 80        START:    INC   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,Y+]  ; 8000   \t6C A0        START:    INC   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,S+]  ; 8000   \t6C E0        START:    INC   [,S+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,U+]  ; 8000   \t6C C0        START:    INC   [,U+]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, 
        "Cannot use post increment with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementindirectMode8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,-X]  ; 8000   \t6C 82        START:    INC   [,-X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,-Y]  ; 8000   \t6C A2        START:    INC   [,-Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,-S]  ; 8000   \t6C E2        START:    INC   [,-S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tINC\t\t  \t[,-U]  ; 8000   \t6C C2        START:    INC   [,-U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getIncInstruction(), 
        AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, 
        "Cannot use pre decrement with 1 for indirect mode");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testINCIndexedAutoIncrementDecrementIndirectMode16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove25() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove26() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove27() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove28() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove29() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove30() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove10() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove11() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove12() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove13() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove14() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove15() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove16() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove17() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove18() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove19() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove20() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove21() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove22() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove23() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove24() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove31() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove32() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove33() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove34() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove35() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove36() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove37() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove38() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove39() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove40() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove41() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove42() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove43() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove44() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove45() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove46() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove47() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove48() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove49() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove50() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove51() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove52() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove53() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testINCIndexedConstantIndirectMove54() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove6() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove7() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove8() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
   * Check Assembled INC Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testINCIndexedRelatifIndirectToPCMove9() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledINCInstruction cannot be resolved to a type."
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
