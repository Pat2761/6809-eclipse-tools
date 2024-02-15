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
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledTFRInstruction;
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
public class TestTFRInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check TFR 8 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tA,B  ");
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
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 8 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tCC,DP  ");
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
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tU,S  ");
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
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tX,Y  ");
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
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR 16 bits with extra space
   */
  @Test
  public void testSimpleTFRWithExtraSpace5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("TFR\t\tX,PC  ");
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
      Assert.assertTrue("Must be an TFR directive line", (_instruction instanceof TfrInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,A
   */
  @Test
  public void testSimpleTFRResultAA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,B
   */
  @Test
  public void testSimpleTFRResultAB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,D
   */
  @Test
  public void testSimpleTFRResultAD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,CC
   */
  @Test
  public void testSimpleTFRResultACC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x8A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,DP
   */
  @Test
  public void testSimpleTFRResultADP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,X
   */
  @Test
  public void testSimpleTFRResultAX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,Y
   */
  @Test
  public void testSimpleTFRResultAY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,S
   */
  @Test
  public void testSimpleTFRResultAS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,U
   */
  @Test
  public void testSimpleTFRResultAU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,PC
   */
  @Test
  public void testSimpleTFRResultAPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tA,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,A
   */
  @Test
  public void testSimpleTFRResultBA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,B
   */
  @Test
  public void testSimpleTFRResultBB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,D
   */
  @Test
  public void testSimpleTFRResultBD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x90, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,CC
   */
  @Test
  public void testSimpleTFRResultBCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x9A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR A,DP
   */
  @Test
  public void testSimpleTFRResultBDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,X
   */
  @Test
  public void testSimpleTFRResultBX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,Y
   */
  @Test
  public void testSimpleTFRResultBY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x92, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,S
   */
  @Test
  public void testSimpleTFRResultBS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,U
   */
  @Test
  public void testSimpleTFRResultBU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR B,PC
   */
  @Test
  public void testSimpleTFRResultBPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tB,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,A
   */
  @Test
  public void testSimpleTFRResultCCA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,B
   */
  @Test
  public void testSimpleTFRResultCCB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,D
   */
  @Test
  public void testSimpleTFRResultCCD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,CC
   */
  @Test
  public void testSimpleTFRResultCCCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xAA, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,DP
   */
  @Test
  public void testSimpleTFRResultCCDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,X
   */
  @Test
  public void testSimpleTFRResultCCX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,Y
   */
  @Test
  public void testSimpleTFRResultCCY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,S
   */
  @Test
  public void testSimpleTFRResultCCS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,U
   */
  @Test
  public void testSimpleTFRResultCCU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR CC,PC
   */
  @Test
  public void testSimpleTFRResultCCPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tCC,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,A
   */
  @Test
  public void testSimpleTFRResultDPA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,B
   */
  @Test
  public void testSimpleTFRResultDPB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,D
   */
  @Test
  public void testSimpleTFRResultDPD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB0, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,CC
   */
  @Test
  public void testSimpleTFRResultDPCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xBA, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,DP
   */
  @Test
  public void testSimpleTFRResultDPDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,X
   */
  @Test
  public void testSimpleTFRResultDPX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,Y
   */
  @Test
  public void testSimpleTFRResultDPY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB2, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,S
   */
  @Test
  public void testSimpleTFRResultDPS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,U
   */
  @Test
  public void testSimpleTFRResultDPU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR DP,PC
   */
  @Test
  public void testSimpleTFRResultDPPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tDP,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,A
   */
  @Test
  public void testSimpleTFRResultDA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x08, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,B
   */
  @Test
  public void testSimpleTFRResultDB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x09, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,D
   */
  @Test
  public void testSimpleTFRResultDD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x00, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,CC
   */
  @Test
  public void testSimpleTFRResultDCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,DP
   */
  @Test
  public void testSimpleTFRResultDDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x0B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,X
   */
  @Test
  public void testSimpleTFRResultDX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,Y
   */
  @Test
  public void testSimpleTFRResultDY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x02, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,S
   */
  @Test
  public void testSimpleTFRResultDS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x04, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,U
   */
  @Test
  public void testSimpleTFRResultDU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x03, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR D,PC
   */
  @Test
  public void testSimpleTFRResultDPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tD,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x05, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,A
   */
  @Test
  public void testSimpleTFRResultXA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x18, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,B
   */
  @Test
  public void testSimpleTFRResultXB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x19, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,D
   */
  @Test
  public void testSimpleTFRResultXD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,CC
   */
  @Test
  public void testSimpleTFRResultXCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x1A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,DP
   */
  @Test
  public void testSimpleTFRResultXDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x1B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,X
   */
  @Test
  public void testSimpleTFRResultXX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,Y
   */
  @Test
  public void testSimpleTFRResultXY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x12, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,S
   */
  @Test
  public void testSimpleTFRResultXS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x14, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,U
   */
  @Test
  public void testSimpleTFRResultXU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,PC
   */
  @Test
  public void testSimpleTFRResultXPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tX,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x15, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,A
   */
  @Test
  public void testSimpleTFRResultYA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x28, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,B
   */
  @Test
  public void testSimpleTFRResultYB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x29, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,D
   */
  @Test
  public void testSimpleTFRResultYD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x20, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,CC
   */
  @Test
  public void testSimpleTFRResultYCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x2A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,DP
   */
  @Test
  public void testSimpleTFRResultYDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x2B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,X
   */
  @Test
  public void testSimpleTFRResultYX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,Y
   */
  @Test
  public void testSimpleTFRResultYY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x22, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,S
   */
  @Test
  public void testSimpleTFRResultYS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x24, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR X,U
   */
  @Test
  public void testSimpleTFRResultYU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x23, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR Y,PC
   */
  @Test
  public void testSimpleTFRResultYPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tY,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x25, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,A
   */
  @Test
  public void testSimpleTFRResultUA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x38, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,B
   */
  @Test
  public void testSimpleTFRResultUB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x39, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,D
   */
  @Test
  public void testSimpleTFRResultUD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,CC
   */
  @Test
  public void testSimpleTFRResultUCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x3A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,DP
   */
  @Test
  public void testSimpleTFRResultUDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x3B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,X
   */
  @Test
  public void testSimpleTFRResultUX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x31, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,Y
   */
  @Test
  public void testSimpleTFRResultUY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x32, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,S
   */
  @Test
  public void testSimpleTFRResultUS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x34, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,U
   */
  @Test
  public void testSimpleTFRResultUU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x33, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR U,PC
   */
  @Test
  public void testSimpleTFRResultUPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tU,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x35, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,A
   */
  @Test
  public void testSimpleTFRResultSA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x48, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,B
   */
  @Test
  public void testSimpleTFRResultSB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x49, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,D
   */
  @Test
  public void testSimpleTFRResultSD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x40, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,CC
   */
  @Test
  public void testSimpleTFRResultSCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x4A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,DP
   */
  @Test
  public void testSimpleTFRResultSDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x4B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,X
   */
  @Test
  public void testSimpleTFRResultSX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,Y
   */
  @Test
  public void testSimpleTFRResultSY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x42, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,S
   */
  @Test
  public void testSimpleTFRResultSS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x44, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,U
   */
  @Test
  public void testSimpleTFRResultSU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x43, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR S,PC
   */
  @Test
  public void testSimpleTFRResultSPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tS,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x45, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,A
   */
  @Test
  public void testSimpleTFRResultPCA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,A  ; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x58, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,B
   */
  @Test
  public void testSimpleTFRResultPCB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,B  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x59, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,D
   */
  @Test
  public void testSimpleTFRResultPCD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,D  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,CC
   */
  @Test
  public void testSimpleTFRResultPCCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,CC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x5A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,DP
   */
  @Test
  public void testSimpleTFRResultPCDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,DP  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x5B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,X
   */
  @Test
  public void testSimpleTFRResultPCX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,X  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x51, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,Y
   */
  @Test
  public void testSimpleTFRResultPCY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,Y  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x52, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,S
   */
  @Test
  public void testSimpleTFRResultPCS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,S  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x54, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,U
   */
  @Test
  public void testSimpleTFRResultPCU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,U  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertNoIssues(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x53, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check TFR PC,PC
   */
  @Test
  public void testSimpleTFRResultPCPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   TFR\t\tPC,PC  \t\t\t; test TFR");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getTfrInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledTFRInstruction line = ((AssembledTFRInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x55, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test TFR", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
