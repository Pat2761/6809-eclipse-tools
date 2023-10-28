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
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
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
public class TestINCInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check INCA with extra space
   */
  @Test
  public void testSimpleINCAWithExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCA  ");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCA with extra space
   */
  @Test
  public void testSimpleINCAWithoutExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCA");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCA with extra space
   */
  @Test
  public void testSimpleINCAWithExtraSpaceWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCA  \t\t\t; It is a comment ");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCA with extra space
   */
  @Test
  public void testSimpleINCAWithoutExtraSpaceWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCA\t\t\t\t\t; It is a comment");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCB with extra space
   */
  @Test
  public void testSimpleINCBWithExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCB  ");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCB with extra space
   */
  @Test
  public void testSimpleINCBWithoutExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCB");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCB with extra space
   */
  @Test
  public void testSimpleINCBWithExtraSpaceWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCB  \t\t\t; It is a comment ");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check INCB with extra space
   */
  @Test
  public void testSimpleINCBWithoutExtraSpaceWithComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("INCB\t\t\t\t\t; It is a comment");
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
      Assert.assertTrue("Must be an INC Accumulateur line", (_instruction instanceof IncInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final IncInstruction incInstruction = ((IncInstruction) _instruction_1);
      Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.getInstruction());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      _builder.append("INC\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      _builder.append("INC\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      _builder.append("INC\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
      _builder.append("INC\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("INC\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an ADD directive line", (_instruction instanceof IncInstruction));
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
}
