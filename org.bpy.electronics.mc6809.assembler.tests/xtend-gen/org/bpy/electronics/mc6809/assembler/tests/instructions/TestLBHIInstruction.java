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
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BhiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLBHIInstruction;
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
public class TestLBHIInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check LBHI
   */
  @Test
  public void testSimpleLBHIWithExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("Jump\t    ASLA");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASLB");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LBHI\t\tJump ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(4);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an LBHI directive line", (_instruction instanceof BhiInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI
   */
  @Test
  public void testSimpleLBHIWithoutExtraSpace() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("Jump\t    ASLA");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASLB");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("LBHI\t\tJump");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(4);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an LBHI directive line", (_instruction instanceof BhiInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI with duplicate label
   */
  @Test
  public void testSimpleLBHIWithDuplicateLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("Jump\t    LDA\t\t#25");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("NOP");
      _builder.newLine();
      _builder.append("Jump\t\tLBHI\t\tJump\t\t; Jump=3FFF");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), 
        AssemblerEngine.DUPLICATE_LABEL, 
        "Label Jump is already defined");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI with bad label
   */
  @Test
  public void testSimpleLBHIWithBadLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("Jump1\t    LDA\t\t#25");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("NOP");
      _builder.newLine();
      _builder.append("Jump\t\tLBHI\t\tJump2\t\t; Jump=3FFF");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getBhiInstruction(), 
        InstructionValidator.MISSING_LABEL, 
        "Label Jump2 isn\'t defined");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI
   */
  @Test
  public void testSimpleLBHIWithWithLabel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("Jump\t    ASLA");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ASLB");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\t\tJump");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(4);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be an Instruction line", (_lineContent instanceof InstructionLine));
      EObject _lineContent_1 = line.getLineContent();
      final InstructionLine instructionLine = ((InstructionLine) _lineContent_1);
      EObject _instruction = instructionLine.getInstruction();
      Assert.assertTrue("Must be an LBHI directive line", (_instruction instanceof BhiInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI negative jump
   */
  @Test
  public void testSimpleLBHIWithNegativeJump1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8004");
      _builder.newLine();
      _builder.append("Jump\t    LDA\t\t#25");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8080");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\tJump\t\t; Jump=1024FF80");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getBhiInstruction(), 
        AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH, 
        "You can use a short branch");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(4);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI negative jump
   */
  @Test
  public void testSimpleLBHIWithNegativeJump2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8003");
      _builder.newLine();
      _builder.append("Jump\t    LDA\t\t#25");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8080");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\tJump\t\t; Jump=1024FF7F");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoIssues(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(4);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI positive jump
   */
  @Test
  public void testSimpleLBHIWithPositiveJump1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\t\tJump\t\t; Jump=1024007F");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$8083");
      _builder.newLine();
      _builder.append("Jump\t\tRTS\t\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getBhiInstruction(), 
        AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH, 
        "You can use a short branch");
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI positive jump
   */
  @Test
  public void testSimpleLBHIWithPositiveJump2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $8000");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\t\tJump\t\t; Jump=10240080");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$8084");
      _builder.newLine();
      _builder.append("Jump\t\tRTS\t\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoIssues(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8085, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI positive limit jump
   */
  @Test
  public void testSimpleLBHIWithPositiveLimitJump1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $0000");
      _builder.newLine();
      _builder.append("MyBranch\tLBHI\t\tJump\t\t; Jump=10257FFF");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG     $8003");
      _builder.newLine();
      _builder.append("Jump\t\tRTS\t\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
      Assert.assertEquals("Check label", "MyBranch", line.getLabel());
      Assert.assertEquals("Check comment", "; Jump=10257FFF", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI positive limit jump
   */
  @Test
  public void testSimpleLBHIWithPositiveLimitJump2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("ORG     $0000");
      _builder.newLine();
      _builder.append("MyBanch\t\tLBHI\tJump\t\t; Jump=10248000");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG     $8004");
      _builder.newLine();
      _builder.append("Jump\t\tRTS\t\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI negative limit jump
   */
  @Test
  public void testSimpleLBHIWithNegativeLimitJump1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$0004");
      _builder.newLine();
      _builder.append("JUMP\t\tRTS\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$8000\t\t;");
      _builder.newLine();
      _builder.append("VVV\t\t\tLBHI\t\tJUMP\t\t;\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(4);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check LBHI negative limit jump
   */
  @Test
  public void testSimpleLBHIWithNegativeLimitJump2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$0003");
      _builder.newLine();
      _builder.append("JUMP\t\tRTS\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ORG\t\t$8000\t\t;");
      _builder.newLine();
      _builder.append("VVV\t\t\tLBHI\t\tJUMP\t\t;\t\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(4);
      final AssembledLBHIInstruction line = ((AssembledLBHIInstruction) _assembledLine);
      Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
      Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
      Assert.assertEquals("Check opcode value", 0x22, line.getOpcode()[1]);
      Assert.assertEquals("Check operand length", 2, line.getOperand().length);
      Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
      Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
