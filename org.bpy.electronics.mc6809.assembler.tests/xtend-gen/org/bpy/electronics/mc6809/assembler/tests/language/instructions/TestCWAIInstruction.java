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
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCWAIInstruction;
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
public class TestCWAIInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check CWAI immediat
   */
  @Test
  public void testCWAIImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("CWAI\t\t  \t#124");
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
      Assert.assertTrue("Must be an AND directive line", (_instruction instanceof CwaiInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final CwaiInstruction cmpInstruction = ((CwaiInstruction) _instruction_1);
      Assert.assertEquals("Must be an CWAI instruction", cmpInstruction.getInstruction(), "CWAI");
      EObject _operand = cmpInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI direct mode
   */
  @Test
  public void testCWAIDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Label\t   CWAI\t\t  \t<124       ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Direct mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI extended mode
   */
  @Test
  public void testCWAIExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Label      CWAI\t\t  \t$1234         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Extended mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI extended mode
   */
  @Test
  public void testCWAIExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Label      CWAI\t\t  \t>$1234         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Extended mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI extended indirect mode
   */
  @Test
  public void testCWAIExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Label      CWAI\t\t  \t[$1234]         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Constant-Offset Indexed
   */
  @Test
  public void testCWAIConstantOffsetIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \tConst,X         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Constant-Offset Indexed indirect
   */
  @Test
  public void testCWAIConstantOffsetIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t[Const,X]         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Accumulator Indexed
   */
  @Test
  public void testCWAIAccumulatorIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \tA,X         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Accumulator Indexed Indirect
   */
  @Test
  public void testCWAIAccumulatorIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t[A,X]         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Auto-Increment Indexed
   */
  @Test
  public void testCWAIAutoIncrementIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t,--X         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Auto-Increment Indexed Indirect
   */
  @Test
  public void testCWAIAutoIncrementIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t[,--X]         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Relative to PC Indexed
   */
  @Test
  public void testCWAIRelativePCIndexed() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t0,PC         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI Relative to PC Indexed Indirect
   */
  @Test
  public void testCWAIRelativePCIndexedIndirect() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5    ");
      _builder.newLine();
      _builder.append("Label      \tCWAI\t\t  \t[0,PC]         ; Illegal CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        InstructionValidator.ILLEGAL_MODE, 
        "Indexed mode is not valid for the CWAI instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 0, line.getOperand().length);
      Assert.assertEquals("Check label", "Label", line.getLabel());
      Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check CWAI instruction with duplicate label
   */
  @Test
  public void testCWAIWithDuplicateLabel() {
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
      _builder.append("Start      \tCWAI\t\t  \t#Const+2");
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
   * Check Assembled CWAI immediate instruction
   */
  @Test
  public void testCWAIImmediatInstruction1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Const\t   \tEQU          \t5");
      _builder.newLine();
      _builder.append("Start      \tCWAI\t\t  \t#Const+2  ; 8000   3C 07        START:    CWAI");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x3C, line.getOpcode()[0]);
      Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
      Assert.assertEquals("Check Label", "Start", line.getLabel());
      Assert.assertEquals("Check comment", "; 8000   3C 07        START:    CWAI", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CWAI immediate with limit negative operand
   */
  @Test
  public void testCWAIImmediatInstruction2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCWAI\t\t  \t#-129");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value -129 is below the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CWAI immediate with limit negative operand
   */
  @Test
  public void testCWAIImmediatInstruction3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCWAI\t\t  \t#-128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CWAI immediate with positive limit operand
   */
  @Test
  public void testCWAIImmediatInstruction4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCWAI\t\t  \t#127");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check Assembled CWAI immediate with positive limit operand
   */
  @Test
  public void testCWAIImmediatInstruction5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t   \t");
      _builder.append("ORG    \t\t\t$8000");
      _builder.newLine();
      _builder.append("Start      \tCWAI\t\t  \t#128");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCwaiInstruction(), 
        ExpressionParser.OVERFLOW_ERROR, 
        "The value 128 is greater than the possible limit, data may be lost");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledCWAIInstruction line = ((AssembledCWAIInstruction) _assembledLine);
      Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
