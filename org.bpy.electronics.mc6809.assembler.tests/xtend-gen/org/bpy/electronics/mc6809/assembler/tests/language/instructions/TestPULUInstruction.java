/**
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIOR
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
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledPULUInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
public class TestPULUInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check PHSH immediate
   */
  @Test
  public void testPULUImemdiatAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Registers  REG          A,B \t       ");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("PULU\t\t  \t#Registers");
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
      Assert.assertTrue("Must be an PULU instruction line", (_instruction instanceof PuluInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PHSH A
   */
  @Test
  public void testPULUImemdiate1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("PULU\t\t  \tPC,S,Y,X,DP,B,A,CC");
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
      Assert.assertTrue("Must be an PULU instruction line", (_instruction instanceof PuluInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final PuluInstruction phshInstruction = ((PuluInstruction) _instruction_1);
      Assert.assertEquals("Must be an PULU instruction", phshInstruction.getInstruction(), "PULU");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PHSH from REG instruction
   */
  @Test
  public void testPULUImemdiatAddressingMode3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       \t\t");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("RegDir     \t\tREG\t\t\tA,B,X,Y\t       ");
      _builder.newLine();
      _builder.append("PushPull        PULU\t\t#RegDir       ; push register");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(3);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x8002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x36, line.getOperand()[0]);
      Assert.assertEquals("Check label", "PushPull", line.getLabel());
      Assert.assertEquals("Check comment", "; push register", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PHSH missing REG instruction
   */
  @Test
  public void testPULUMissingReg() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("Pshs       PULU\t\t  \t#RegDir       ; push register");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getPuluInstruction(), 
        InstructionValidator.MISSING_DIRECTIVE, 
        "REG RegDir directive is not defined");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC COunter", 0x8001, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x3F, line.getOpcode()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with D and A register
   */
  @Test
  public void testInstructionWithAAndDRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test PULU without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU    A,D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getPuluInstruction(), InstructionValidator.DUPLICATE_OPTION, "D register overwrite the A register in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with D and B register
   */
  @Test
  public void testInstructionWithBAndDRegister() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU    B,D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getPuluInstruction(), InstructionValidator.DUPLICATE_OPTION, "D register overwrite the B register in the REG Directive");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with duplicate label
   */
  @Test
  public void testInstructionWithDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("Lab1\t\tNOP\t\t \t");
      _builder.newLine();
      _builder.append("Lab1\t \tPULU    \tB,A \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), AssemblerEngine.DUPLICATE_LABEL, "Label Lab1 is already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with CC register
   */
  @Test
  public void testInstructionOperandCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   CC \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with A register
   */
  @Test
  public void testInstructionOperandA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   A \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x02, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with B register
   */
  @Test
  public void testInstructionOperandB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   B \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x04, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with D register
   */
  @Test
  public void testInstructionOperandD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   D \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x06, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with DP register
   */
  @Test
  public void testInstructionOperandDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   DP \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x08, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with X register
   */
  @Test
  public void testInstructionOperandX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   X \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with Y register
   */
  @Test
  public void testInstructionOperandY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   Y \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x20, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with U register
   */
  @Test
  public void testInstructionOperandU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   U \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getPuluInstruction(), 
        InstructionValidator.ILLEGAL_REGISTER, 
        "U register can\'t be pull for a PULU instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with S register
   */
  @Test
  public void testInstructionOperandS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   S \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with S register
   */
  @Test
  public void testInstructionOperandRegS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("REG_U\t\tREG\t\tU");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   \t#REG_U \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, 
        AssemblerPackage.eINSTANCE.getPuluInstruction(), 
        InstructionValidator.ILLEGAL_REGISTER, 
        "U register can\'t be pull for a PULU instruction");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check PULU instruction with PC register
   */
  @Test
  public void testInstructionOperandPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; test REG without label");
      _builder.newLine();
      _builder.append("\t \t    ");
      _builder.append("PULU   PC \t\t ; Oups");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(1);
      final AssembledPULUInstruction line = ((AssembledPULUInstruction) _assembledLine);
      Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
      Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x37, line.getOpcode()[0]);
      Assert.assertEquals("Check operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
