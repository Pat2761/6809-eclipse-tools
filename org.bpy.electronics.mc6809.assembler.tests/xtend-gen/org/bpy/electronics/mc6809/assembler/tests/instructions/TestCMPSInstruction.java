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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPSInstruction;
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
public class TestCMPSInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check CMPS immediat
   */
  @Test
  public void testCMPSImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPS\t\t  \t#124");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPS direct mode
   */
  @Test
  public void testCMPSDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPS\t\t  \t<124");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPS extended mode
   */
  @Test
  public void testCMPSExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPS\t\t  \t$1234");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPS extended mode
   */
  @Test
  public void testCMPSExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPS\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPS extended indirect mode
   */
  @Test
  public void testCMPSExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CMPS\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
      EObject _operand = addInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CMPS Constant-Offset Indexed
   */
  @Test
  public void testCMPSConstantOffsetIndexed() {
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
      _builder.append("CMPS\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Constant-Offset Indexed indirect
   */
  @Test
  public void testCMPSConstantOffsetIndexedIndirect() {
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
      _builder.append("CMPS\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Accumulator Indexed
   */
  @Test
  public void testCMPSAccumulatorIndexed() {
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
      _builder.append("CMPS\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Accumulator Indexed Indirect
   */
  @Test
  public void testCMPSAccumulatorIndexedIndirect() {
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
      _builder.append("CMPS\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("CMPS\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Auto-Increment Indexed
   */
  @Test
  public void testCMPSAutoIncrementIndexed() {
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
      _builder.append("CMPS\t\t  \t,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,U++");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Auto-Increment Indexed Indirect
   */
  @Test
  public void testCMPSAutoIncrementIndexedIndirect() {
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
      _builder.append("CMPS\t\t  \t[,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t[,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t[,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t[,U++]");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Relative to PC Indexed
   */
  @Test
  public void testCMPSRelativePCIndexed() {
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
      _builder.append("CMPS\t\t  \t0,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t,PC");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \tConst,PC");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS Relative to PC Indexed Indirect
   */
  @Test
  public void testCMPSRelativePCIndexedIndirect() {
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
      _builder.append("CMPS\t\t  \t[0,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t[,PC]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("CMPS\t\t  \t[Const,PC]");
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
      Assert.assertTrue("Must be an CMPS directive line", (_instruction instanceof CmpInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CmpInstruction addInstruction = ((CmpInstruction) _instruction_1);
      Assert.assertEquals("Must be an CMPS instruction", addInstruction.getInstruction(), "CMPS");
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
   * Check CMPS instruction with duplicate label
   */
  @Test
  public void testCMPSWithDuplicateLabel() {
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
      _builder.append("Start      \tCMPS\t\t  \t#Const+2");
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
   * Check Assembled CMPS immediate instruction
   */
  @Test
  public void testCMPSImmediatInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t#Const+2  ; 8000   11 8C 07        START:    CMPS");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x8C, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 8C 07        START:    CMPS", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS immediate with limit negative operand
   */
  @Test
  public void testCMPSImmediatInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t#-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS immediate with limit negative operand
   */
  @Test
  public void testCMPSImmediatInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t#-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x8000, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS immediate with positive limit operand
   */
  @Test
  public void testCMPSImmediatInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t#32767");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS immediate with positive limit operand
   */
  @Test
  public void testCMPSImmediatInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t#32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 32768 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7FFF, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS direct mode instruction
   */
  @Test
  public void testCMPSDirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t<Const*2  ; 8000   11 9C 0A        START:    CMPS   <Const*2 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0x9C, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 9C 0A        START:    CMPS   <Const*2 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS direct with limit negative operand
   */
  @Test
  public void testCMPSDirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t<-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS direct with limit negative operand
   */
  @Test
  public void testCMPSDirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t<-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS direct with positive limit operand
   */
  @Test
  public void testCMPSDirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t<127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS direct with positive limit operand
   */
  @Test
  public void testCMPSDirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t<128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended mode instruction
   */
  @Test
  public void testCMPSExtendedInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t>Const*1000  ; 8000   11 BC 13 88     START:    CMPS   >Const*1000 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xBC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   11 BC 13 88     START:    CMPS   >Const*1000 ", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended with limit negative operand
   */
  @Test
  public void testCMPSExtendedInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t>-32769");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended with limit negative operand
   */
  @Test
  public void testCMPSExtendedInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t>-32768");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended with positive limit operand
   */
  @Test
  public void testCMPSExtendedInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t>65535");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended with positive limit operand
   */
  @Test
  public void testCMPSExtendedInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t>65536");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended indirect mode instruction
   */
  @Test
  public void testCMPSExtendedIndirectInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[Const*1000]  ; 8000   AB 9F 13 88  START:    CMPS   [Const*1000]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 3, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[2]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    CMPS   [Const*1000]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended indirect with limit negative operand
   */
  @Test
  public void testCMPSExtendedIndirectInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -32769 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended indirect with limit negative operand
   */
  @Test
  public void testCMPSExtendedIndirectInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended indirect with positive limit operand
   */
  @Test
  public void testCMPSExtendedIndirectInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[65535]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS extended indirect with positive limit operand
   */
  @Test
  public void testCMPSExtendedIndirectInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[65536]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 65536 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tA,X  ; 8000   10 A3 86        START:    CMPS   A,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    CMPS   A,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tA,Y  ; 8000   \t10 A3 A6        START:    CMPS   A,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A6        START:    CMPS   A,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tA,U  ; 8000   \t10 A3 C6        START:    CMPS   A,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C6        START:    CMPS   A,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tA,S  ; 8000   \t10 A3 E6        START:    CMPS   A,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E6        START:    CMPS   A,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tB,X  ; 8000   AB 85        START:    CMPS   B,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPS   B,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tB,Y  ; 8000   \t10 A3 A5        START:    CMPS   B,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A5        START:    CMPS   B,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tB,U  ; 8000   \t10 A3 C5        START:    CMPS   B,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C5        START:    CMPS   B,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tB,S  ; 8000   \t10 A3 E5        START:    CMPS   B,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E5        START:    CMPS   B,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tD,X  ; 8000   AB 8B        START:    CMPS   D,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPS   D,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tD,Y  ; 8000   \t10 A3 AB        START:    CMPS   D,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 AB        START:    CMPS   D,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tD,U  ; 8000   \t10 A3 CB        START:    CMPS   D,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 CB        START:    CMPS   D,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \tD,S  ; 8000   \t10 A3 EB        START:    CMPS   D,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 EB        START:    CMPS   D,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndorectAccumulatorMovingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[A,X]  ; 8000   AB 96        START:    CMPS   [A,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPS   [A,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[A,Y]  ; 8000   \t10 A3 B6        START:    CMPS   [A,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B6        START:    CMPS   [A,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[A,U]  ; 8000   \t10 A3 D6        START:    CMPS   [A,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D6        START:    CMPS   [A,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[A,S]  ; 8000   \t10 A3 F6        START:    CMPS   [A,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F6        START:    CMPS   [A,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[B,X]  ; 8000   AB 95        START:    CMPS   [B,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPS   [B,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[B,Y]  ; 8000   \t10 A3 B5        START:    CMPS   [B,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B5        START:    CMPS   [B,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[B,U]  ; 8000   \t10 A3 D5        START:    CMPS   [B,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D5        START:    CMPS   [B,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[B,S]  ; 8000   \t10 A3 F5        START:    CMPS   [B,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F5        START:    CMPS   [B,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[D,X]  ; 8000   AB 9B        START:    CMPS   [D,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPS   [D,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[D,Y]  ; 8000   \t10 A3 BB        START:    CMPS   [D,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 BB        START:    CMPS   [D,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[D,U]  ; 8000   \t10 A3 DB        START:    CMPS   [D,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 DB        START:    CMPS   [D,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
   */
  @Test
  public void testCMPSIndexedIndirectAccumulatorMovingMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[D,S]  ; 8000   \t10 A3 FB        START:    CMPS   [D,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 FB        START:    CMPS   [D,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,X+  ; 8000   \t10 A3 80        START:    CMPS   ,X+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 80        START:    CMPS   ,X+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,X++  ; 8000   \t10 A3 81        START:    CMPS   ,X++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 81        START:    CMPS   ,X++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,Y+  ; 8000   \t10 A3 A0        START:    CMPS   ,Y+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A0        START:    CMPS   ,Y+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,Y++  ; 8000   \t10 A3 A1        START:    CMPS   ,Y++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A1        START:    CMPS   ,Y++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,S+  ; 8000   \t10 A3 E0        START:    CMPS   ,S+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E0        START:    CMPS   ,S+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,S++  ; 8000   \t10 A3 E1        START:    CMPS   ,S++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E1        START:    CMPS   ,S++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,U+  ; 8000   \t10 A3 C0        START:    CMPS   ,U+");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C0        START:    CMPS   ,U+", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,U++  ; 8000   \t10 A3 C1        START:    CMPS   ,U++");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C1        START:    CMPS   ,U++", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,-X  ; 8000   \t10 A3 82        START:    CMPS   ,-X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 82        START:    CMPS   ,-X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,--X  ; 8000   \t10 A3 83        START:    CMPS   ,--X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 83        START:    CMPS   ,--X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,-Y  ; 8000   \t10 A3 A2        START:    CMPS   ,-Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A2        START:    CMPS   ,-Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,--Y  ; 8000   \t10 A3 A3        START:    CMPS   ,--Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A3        START:    CMPS   ,--Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,-S  ; 8000   \t10 A3 E2        START:    CMPS   ,-S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E2        START:    CMPS   ,-S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,--S  ; 8000   \t10 A3 E3        START:    CMPS   ,--S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E3        START:    CMPS   ,--S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,-U  ; 8000   \t10 A3 C2        START:    CMPS   ,-U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C2        START:    CMPS   ,-U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,--U  ; 8000   \t10 A3 C3        START:    CMPS   ,--U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C3        START:    CMPS   ,--U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,X+]  ; 8000   \t10 A3 80        START:    CMPS   ,X+");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode indorect instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,X++]  ; 8000   \t10 A3 91        START:    CMPS   [,X++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 91        START:    CMPS   [,X++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Mode indirect instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,Y+]  ; 8000   \t10 A3 A0        START:    CMPS   ,Y+");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,Y++]  ; 8000   \t10 A3 B1        START:    CMPS   [,Y++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B1        START:    CMPS   [,Y++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,S+]  ; 8000   \t10 A3 E0        START:    CMPS   [,S+]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,S++]  ; 8000   \t10 A3 F1        START:    CMPS   [,S++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F1        START:    CMPS   [,S++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,U+]  ; 8000   \t10 A3 C0        START:    CMPS   [,U+]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementindirectMode8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,U++]  ; 8000   \t10 A3 D1        START:    CMPS   [,U++]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D1        START:    CMPS   [,U++]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,-X]  ; 8000   \t10 A3 82        START:    CMPS   [,-X]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,--X]  ; 8000   \t10 A3 93        START:    CMPS   [,--X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 93        START:    CMPS   [,--X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement INdirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,-Y]  ; 8000   \t10 A3 A2        START:    CMPS   [,-Y]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,--Y]  ; 8000   \t10 A3 B3        START:    CMPS   [,--Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B3        START:    CMPS   [,--Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,-S]  ; 8000   \t10 A3 E2        START:    CMPS   [,-S]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,--S]  ; 8000   \t10 A3 F3        START:    CMPS   [,--S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F3        START:    CMPS   [,--S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Auto Increment Decrement indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,-U]  ; 8000   \t10 A3 C2        START:    CMPS   [,-U]");
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
   * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode instruction
   */
  @Test
  public void testCMPSIndexedAutoIncrementDecrementIndirectMode16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,--U]  ; 8000   \t10 A3 D3        START:    CMPS   [,--U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D3        START:    CMPS   [,--U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1234,X  ; 8000   \t10 A3 89 04 D2            CMPS   1234,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 04 D2            CMPS   1234,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1234,Y  ; 8000   \t10 A3 A9 04 D2            CMPS   1234,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 04 D2            CMPS   1234,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1234,U  ; 8000   \t10 A3 C9 04 D2            CMPS   1234,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 04 D2            CMPS   1234,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1234,S  ; 8000   \t10 A3 E9 04 D2            CMPS   1234,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 04 D2            CMPS   1234,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t34,X  ; 8000   \t10 A3 88 22            CMPS   34,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 22            CMPS   34,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t34,Y  ; 8000   \t10 A3 A8 22            CMPS   34,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 22            CMPS   34,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t34,U  ; 8000   \t10 A3 C8 22            CMPS   34,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 22            CMPS   34,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t34,S  ; 8000   \t10 A3 E8 22            CMPS   34,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 22            CMPS   34,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,X  ; 8000   \t10 A3 84            CMPS   ,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPS   ,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,Y  ; 8000   \t10 A3 A4            CMPS   ,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPS   ,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,U  ; 8000   \t10 A3 C4            CMPS   ,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPS   ,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t,S  ; 8000   \t10 A3 E4            CMPS   ,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPS   ,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t0,X  ; 8000   \t10 A3 84            CMPS   0,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 84            CMPS   0,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t0,Y  ; 8000   \t10 A3 A4            CMPS   0,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A4            CMPS   0,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t0,U  ; 8000   \t10 A3 C4            CMPS   0,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C4            CMPS   0,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t0,S  ; 8000   \t10 A3 E4            CMPS   0,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E4            CMPS   0,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-16,X  ; 8000   \t10 A3 10            CMPS   -16,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 10            CMPS   -16,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1,X  ; 8000   \t10 A3 01            CMPS   1,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 01            CMPS   1,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t15,X  ; 8000   \t10 A3 0F            CMPS   15,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 0F            CMPS   15,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-16,Y  ; 8000   \t10 A3 30            CMPS   -16,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 30            CMPS   -16,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1,Y  ; 8000   \t10 A3 21            CMPS   1,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 21            CMPS   1,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t15,Y  ; 8000   \t10 A3 2F            CMPS   15,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 2F            CMPS   15,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove25() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-16,U  ; 8000   \t10 A3 50            CMPS   -16,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 50            CMPS   -16,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove26() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1,U  ; 8000   \t10 A3 41            CMPS   1,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 41            CMPS   1,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove27() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t15,U  ; 8000   \t10 A3 4F            CMPS   15,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 4F            CMPS   15,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove28() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-16,S  ; 8000   \t10 A3 70            CMPS   -16,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 70            CMPS   -16,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove29() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t1,S  ; 8000   \t10 A3 61            CMPS   1,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 61            CMPS   1,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove30() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t15,S  ; 8000   \t10 A3 6F            CMPS   15,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 6F            CMPS   15,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-128,X  ; 8000   \t10 A3 88 80            CMPS   -128,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 80            CMPS   -128,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t127,X  ; 8000   \t10 A3 88 7F            CMPS   127,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 88 7F            CMPS   127,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-128,Y  ; 8000   \t10 A3 A8 80            CMPS   -128,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 80            CMPS   -128,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t127,Y  ; 8000   \t10 A3 A8 7F            CMPS   127,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A8 7F            CMPS   127,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-128,U  ; 8000   \t10 A3 C8 80            CMPS   -128,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 80            CMPS   -128,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t127,U  ; 8000   \t10 A3 C8 7F            CMPS   127,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C8 7F            CMPS   127,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-128,S  ; 8000   \t10 A3 E8 80            CMPS   -128,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 80            CMPS   -128,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t127,S  ; 8000   \t10 A3 E8 7F            CMPS   127,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E8 7F            CMPS   127,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32768,X  ; 8000   \t10 A3 89 80 00             CMPS   -32768,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPS   -32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32767,X  ; 8000   \t10 A3 89 7F FF             CMPS   32767,X");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPS   32767,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32768,Y  ; 8000   \t10 A3 A9 80 00             CMPS   -32768,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPS   -32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32767,Y  ; 8000   \t10 A3 A9 7F FF             CMPS   32767,Y");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPS   32767,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32768,U  ; 8000   \t10 A3 C9 80 00             CMPS   -32768,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPS   -32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32767,U  ; 8000   \t10 A3 C9 7F FF             CMPS   32767,U");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPS   32767,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32768,S  ; 8000   \t10 A3 E9 80 00             CMPS   -32768,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPS   -32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32767,S  ; 8000   \t10 A3 E9 7F FF             CMPS   32767,S");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPS   32767,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32769,X  ; 8000   \t10 A3 89 80 00             CMPS   -32769,X");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 80 00             CMPS   -32769,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32768,X  ; 8000   \t10 A3 89 7F FF             CMPS   32768,X");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 89 7F FF             CMPS   32768,X", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32769,Y  ; 8000   \t10 A3 A9 80 00             CMPS   -32769,Y");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 80 00             CMPS   -32769,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32768,Y  ; 8000   \t10 A3 A9 7F FF             CMPS   32768,Y");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 A9 7F FF             CMPS   32768,Y", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32769,U  ; 8000   \t10 A3 C9 80 00             CMPS   -32769,U");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 80 00             CMPS   -32769,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32768,U  ; 8000   \t10 A3 C9 7F FF             CMPS   32768,U");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 C9 7F FF             CMPS   32768,U", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32769,S  ; 8000   \t10 A3 E9 80 00             CMPS   -32769,S");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 80 00             CMPS   -32769,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  32768,S  ; 8000   \t10 A3 E9 7F FF             CMPS   32768,S");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 E9 7F FF             CMPS   32768,S", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[1234,X]  ; 8000   \t10 A3 99 04 D2            CMPS   [1234,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 04 D2            CMPS   [1234,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[1234,Y]  ; 8000   \t10 A3 B9 04 D2            CMPS   [1234,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 04 D2            CMPS   [1234,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[1234,U]  ; 8000   \t10 A3 D9 04 D2            CMPS   [1234,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 04 D2            CMPS   [1234,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[1234,S]  ; 8000   \t10 A3 F9 04 D2            CMPS   [1234,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 04 D2            CMPS   [1234,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[34,X]  ; 8000   \t10 A3 98 22            CMPS   [34,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 22            CMPS   [34,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[34,Y]  ; 8000   \t10 A3 B8 22            CMPS   [34,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 22            CMPS   [34,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[34,U]  ; 8000   \t10 A3 D8 22            CMPS   [34,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 22            CMPS   [34,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[34,S]  ; 8000   \t10 A3 F8 22            CMPS   [34,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 22            CMPS   [34,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,X]  ; 8000   \t10 A3 94            CMPS   [,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPS   [,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove10() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,Y]  ; 8000   \t10 A3 B4            CMPS   [,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPS   [,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove11() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,U]  ; 8000   \t10 A3 D4            CMPS   [,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPS   [,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove12() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[,S]  ; 8000   \t10 A3 F4            CMPS   [,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPS   [,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove13() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[0,X]  ; 8000   \t10 A3 94            CMPS   [0,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 94            CMPS   [0,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove14() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[0,Y]  ; 8000   \t10 A3 B4            CMPS   [0,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B4            CMPS   [0,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove15() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[0,U]  ; 8000   \t10 A3 D4            CMPS   [0,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D4            CMPS   [0,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove16() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[0,S]  ; 8000   \t10 A3 F4            CMPS   [0,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F4            CMPS   [0,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove17() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-16,X]  ; 8000   \t10 A3 98 F0            CMPS   [-16,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 F0            CMPS   [-16,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove18() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[15,X]  ; 8000   \t10 A3 98 0F            CMPS   [15,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 0F            CMPS   [15,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove19() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-16,Y]  ; 8000   \t10 A3 B8 F0            CMPS   [-16,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 F0            CMPS   [-16,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove20() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[15,Y]  ; 8000   \t10 A3 B8 0F            CMPS   [15,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 0F            CMPS   [15,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove21() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-16,U]  ; 8000   \t10 A3 D8 F0            CMPS   [-16,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 F0            CMPS   [-16,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove22() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[15,U]  ; 8000   \t10 A3 D8 0F            CMPS   [15,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 0F            CMPS   [15,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove23() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-16,S]  ; 8000   \t10 A3 F8 F0            CMPS   [-16,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 F0            CMPS   [-16,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove24() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[15,S]  ; 8000   \t10 A3 F8 0F            CMPS   [15,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 0F            CMPS   [15,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove31() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-128,X]  ; 8000   \t10 A3 98 80            CMPS   [-128,X}");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 80            CMPS   [-128,X}", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove32() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[127,X]  ; 8000   \t10 A3 98 7F            CMPS   [127,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 98 7F            CMPS   [127,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove33() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-128,Y]  ; 8000   \t10 A3 B8 80            CMPS   [-128,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 80            CMPS   [-128,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove34() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[127,Y]  ; 8000   \t10 A3 B8 7F            CMPS   [127,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B8 7F            CMPS   [127,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove35() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-128,U]  ; 8000   \t10 A3 D8 80            CMPS   [-128,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 80            CMPS   [-128,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant INdirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove36() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[127,U]  ; 8000   \t10 A3 D8 7F            CMPS   [127,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D8 7F            CMPS   [127,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove37() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-128,S]  ; 8000   \t10 A3 F8 80            CMPS   [-128,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 80            CMPS   [-128,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove38() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[127,S]  ; 8000   \t10 A3 F8 7F            CMPS   [127,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F8 7F            CMPS   [127,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove39() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768,X]  ; 8000   \t10 A3 99 80 00             CMPS   [-32768,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPS   [-32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove40() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32767,X]  ; 8000   \t10 A3 99 7F FF             CMPS   [32767,X]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPS   [32767,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove41() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768,Y]  ; 8000   \t10 A3 B9 80 00             CMPS   [-32768,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPS   [-32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove42() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32767,Y]  ; 8000   \t10 A3 B9 7F FF             CMPS   [32767,Y]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPS   [32767,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove43() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768,U]  ; 8000   \t10 A3 D9 80 00             CMPS   [-32768,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPS   [-32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove44() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32767,U]  ; 8000   \t10 A3 D9 7F FF             CMPS   [32767,U]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPS   [32767,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove45() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768,S]  ; 8000   \t10 A3 F9 80 00             CMPS   [-32768,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPS   [-32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove46() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32767,S]  ; 8000   \t10 A3 F9 7F FF             CMPS   [32767,S]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPS   [32767,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove47() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769,X]  ; 8000   \t10 A3 99 80 00             CMPS   [-32769,X]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 80 00             CMPS   [-32769,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove48() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32768,X]  ; 8000   \t10 A3 99 7F FF             CMPS   [32768,X]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 99 7F FF             CMPS   [32768,X]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove49() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769,Y]  ; 8000   \t10 A3 B9 80 00             CMPS   [-32769,Y]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 80 00             CMPS   [-32769,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove50() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32768,Y]  ; 8000   \t10 A3 B9 7F FF             CMPS   [32768,Y]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 B9 7F FF             CMPS   [32768,Y]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove51() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769,U]  ; 8000   \t10 A3 D9 80 00             CMPS   [-32769,U]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 80 00             CMPS   [-32769,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove52() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32768,U]  ; 8000   \t10 A3 D9 7F FF             CMPS   [32768,U]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 D9 7F FF             CMPS   [32768,U]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove53() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769,S]  ; 8000   \t10 A3 F9 80 00             CMPS   [-32769,S]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 80 00             CMPS   [-32769,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
   */
  @Test
  public void testCMPSIndexedConstantIndirectMove54() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  [32768,S]  ; 8000   \t10 A3 F9 7F FF             CMPS   [32768,S]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 F9 7F FF             CMPS   [32768,S]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t0,PCR  ; 8000   \t10 A3 8C 00            CMPS   0,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 00            CMPS   0,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-128,PCR  ; 8000   \t10 A3 8C 80            CMPS   -128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 80            CMPS   -128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t127,PCR  ; 8000   \t10 A3 8C 7F            CMPS   127,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8C 7F            CMPS   127,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-129,PCR  ; 8000   \t10 A3 8D FF 7F            CMPS   -129,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D FF 7F            CMPS   -129,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t128,PCR  ; 8000   \t10 A3 8D 00 80            CMPS   128,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 00 80            CMPS   128,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32768,PCR  ; 8000   \t10 A3 8D 80 00            CMPS   -32768,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPS   -32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t32767,PCR  ; 8000   \t10 A3 8D 7F FF            CMPS   32767,PCR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPS   32767,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t-32769,PCR  ; 8000   \t10 A3 8D 80 00            CMPS   -32769,PCR");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 80 00            CMPS   -32769,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t32768,PCR  ; 8000   \t10 A3 8D 7F FF            CMPS   32768,PCR");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 8D 7F FF            CMPS   32768,PCR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[0,PCR]  ; 8000   \t10 A3 9C 00            CMPS   [0,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 00            CMPS   [0,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-128,PCR]  ; 8000   \t10 A3 9C 80            CMPS   [-128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 80            CMPS   [-128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[127,PCR]  ; 8000   \t10 A3 9C 7F            CMPS   [127,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9C 7F            CMPS   [127,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-129,PCR]  ; 8000   \t10 A3 9D FF 7F            CMPS   [-129,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D FF 7F            CMPS   [-129,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[128,PCR]  ; 8000   \t10 A3 9D 00 80            CMPS   [128,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 00 80            CMPS   [128,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32768,PCR]  ; 8000   \t10 A3 9D 80 00            CMPS   [-32768,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPS   [-32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[32767,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPS   [32767,PCR]");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPS   [32767,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[-32769,PCR]  ; 8000   \t10 A3 9D 80 00            CMPS   [-32769,PCR]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 80 00            CMPS   [-32769,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
   */
  @Test
  public void testCMPSIndexedRelatifIndirectToPCMove9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCMPS\t\t  \t[32768,PCR]  ; 8000   \t10 A3 9D 7F FF            CMPS   [32768,PCR]");
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
      final AssembledCMPSInstruction line = ((AssembledCMPSInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode", 0xAC, line.getOpcode()[1]);
      Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
      Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   \t10 A3 9D 7F FF            CMPS   [32768,PCR]", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
