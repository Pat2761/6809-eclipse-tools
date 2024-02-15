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
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEXGInstruction;
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
public class TestEXGInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check EXG 8 bits with extra space
   */
  @Test
  public void testSimpleEXGWithExtraSpace1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("EXG\t\tA,B  ");
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
      Assert.assertTrue("Must be an EXG directive line", (_instruction instanceof ExgInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG 8 bits with extra space
   */
  @Test
  public void testSimpleEXGWithExtraSpace2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("EXG\t\tCC,DP  ");
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
      Assert.assertTrue("Must be an EXG directive line", (_instruction instanceof ExgInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG 16 bits with extra space
   */
  @Test
  public void testSimpleEXGWithExtraSpace3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("EXG\t\tU,S  ");
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
      Assert.assertTrue("Must be an EXG directive line", (_instruction instanceof ExgInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG 16 bits with extra space
   */
  @Test
  public void testSimpleEXGWithExtraSpace4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("EXG\t\tX,Y  ");
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
      Assert.assertTrue("Must be an EXG directive line", (_instruction instanceof ExgInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG 16 bits with extra space
   */
  @Test
  public void testSimpleEXGWithExtraSpace5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("EXG\t\tX,PC  ");
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
      Assert.assertTrue("Must be an EXG directive line", (_instruction instanceof ExgInstruction));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,A
   */
  @Test
  public void testSimpleEXGResultAA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x88, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,B
   */
  @Test
  public void testSimpleEXGResultAB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,B  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x89, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,D
   */
  @Test
  public void testSimpleEXGResultAD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,D  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x80, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,CC
   */
  @Test
  public void testSimpleEXGResultACC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,CC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x8A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,DP
   */
  @Test
  public void testSimpleEXGResultADP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,DP  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x8B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,X
   */
  @Test
  public void testSimpleEXGResultAX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,X  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x81, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,Y
   */
  @Test
  public void testSimpleEXGResultAY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,Y  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x82, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,S
   */
  @Test
  public void testSimpleEXGResultAS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,S  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x84, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,U
   */
  @Test
  public void testSimpleEXGResultAU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,U  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x83, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,PC
   */
  @Test
  public void testSimpleEXGResultAPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tA,PC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register A with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x85, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,A
   */
  @Test
  public void testSimpleEXGResultBA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,A  ; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x98, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,B
   */
  @Test
  public void testSimpleEXGResultBB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x99, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,D
   */
  @Test
  public void testSimpleEXGResultBD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,D  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x90, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,CC
   */
  @Test
  public void testSimpleEXGResultBCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,CC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x9A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG A,DP
   */
  @Test
  public void testSimpleEXGResultBDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,DP  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x9B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,X
   */
  @Test
  public void testSimpleEXGResultBX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,X  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x91, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,Y
   */
  @Test
  public void testSimpleEXGResultBY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,Y  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x92, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,S
   */
  @Test
  public void testSimpleEXGResultBS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,S  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x94, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,U
   */
  @Test
  public void testSimpleEXGResultBU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,U  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x93, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG B,PC
   */
  @Test
  public void testSimpleEXGResultBPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tB,PC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register B with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x95, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,A
   */
  @Test
  public void testSimpleEXGResultCCA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,A  ; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA8, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,B
   */
  @Test
  public void testSimpleEXGResultCCB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,B  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA9, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,D
   */
  @Test
  public void testSimpleEXGResultCCD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,D  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA0, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,CC
   */
  @Test
  public void testSimpleEXGResultCCCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xAA, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,DP
   */
  @Test
  public void testSimpleEXGResultCCDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,DP  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xAB, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,X
   */
  @Test
  public void testSimpleEXGResultCCX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,X  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA1, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,Y
   */
  @Test
  public void testSimpleEXGResultCCY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,Y  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA2, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,S
   */
  @Test
  public void testSimpleEXGResultCCS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,S  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA4, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,U
   */
  @Test
  public void testSimpleEXGResultCCU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,U  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA3, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG CC,PC
   */
  @Test
  public void testSimpleEXGResultCCPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tCC,PC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register CC with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xA5, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,A
   */
  @Test
  public void testSimpleEXGResultDPA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,A  ; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB8, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,B
   */
  @Test
  public void testSimpleEXGResultDPB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,B  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB9, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,D
   */
  @Test
  public void testSimpleEXGResultDPD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,D  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB0, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,CC
   */
  @Test
  public void testSimpleEXGResultDPCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,CC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xBA, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,DP
   */
  @Test
  public void testSimpleEXGResultDPDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xBB, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,X
   */
  @Test
  public void testSimpleEXGResultDPX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,X  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB1, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,Y
   */
  @Test
  public void testSimpleEXGResultDPY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,Y  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB2, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,S
   */
  @Test
  public void testSimpleEXGResultDPS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,S  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB4, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,U
   */
  @Test
  public void testSimpleEXGResultDPU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,U  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB3, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG DP,PC
   */
  @Test
  public void testSimpleEXGResultDPPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tDP,PC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register DP with a 16 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0xB5, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,A
   */
  @Test
  public void testSimpleEXGResultDA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x08, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,B
   */
  @Test
  public void testSimpleEXGResultDB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a part of itself is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x09, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,D
   */
  @Test
  public void testSimpleEXGResultDD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,D  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x00, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,CC
   */
  @Test
  public void testSimpleEXGResultDCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x0A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,DP
   */
  @Test
  public void testSimpleEXGResultDDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register D with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x0B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,X
   */
  @Test
  public void testSimpleEXGResultDX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,X  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x01, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,Y
   */
  @Test
  public void testSimpleEXGResultDY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,Y  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x02, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,S
   */
  @Test
  public void testSimpleEXGResultDS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,S  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x04, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,U
   */
  @Test
  public void testSimpleEXGResultDU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,U  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x03, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG D,PC
   */
  @Test
  public void testSimpleEXGResultDPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tD,PC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x05, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,A
   */
  @Test
  public void testSimpleEXGResultXA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x18, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,B
   */
  @Test
  public void testSimpleEXGResultXB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x19, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,D
   */
  @Test
  public void testSimpleEXGResultXD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,D  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x10, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,CC
   */
  @Test
  public void testSimpleEXGResultXCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x1A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,DP
   */
  @Test
  public void testSimpleEXGResultXDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x1B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,X
   */
  @Test
  public void testSimpleEXGResultXX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,X  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register X with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x11, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,Y
   */
  @Test
  public void testSimpleEXGResultXY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,Y  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x12, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,S
   */
  @Test
  public void testSimpleEXGResultXS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,S  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x14, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,U
   */
  @Test
  public void testSimpleEXGResultXU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,U  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x13, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,PC
   */
  @Test
  public void testSimpleEXGResultXPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tX,PC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x15, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,A
   */
  @Test
  public void testSimpleEXGResultYA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x28, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,B
   */
  @Test
  public void testSimpleEXGResultYB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x29, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,D
   */
  @Test
  public void testSimpleEXGResultYD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,D  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x20, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,CC
   */
  @Test
  public void testSimpleEXGResultYCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x2A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,DP
   */
  @Test
  public void testSimpleEXGResultYDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x2B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,X
   */
  @Test
  public void testSimpleEXGResultYX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,X  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x21, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,Y
   */
  @Test
  public void testSimpleEXGResultYY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,Y  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register Y with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x22, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,S
   */
  @Test
  public void testSimpleEXGResultYS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,S  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x24, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG X,U
   */
  @Test
  public void testSimpleEXGResultYU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,U  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x23, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG Y,PC
   */
  @Test
  public void testSimpleEXGResultYPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tY,PC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x25, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,A
   */
  @Test
  public void testSimpleEXGResultUA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x38, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,B
   */
  @Test
  public void testSimpleEXGResultUB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x39, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,D
   */
  @Test
  public void testSimpleEXGResultUD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,D  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x30, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,CC
   */
  @Test
  public void testSimpleEXGResultUCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x3A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,DP
   */
  @Test
  public void testSimpleEXGResultUDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x3B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,X
   */
  @Test
  public void testSimpleEXGResultUX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,X  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x31, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,Y
   */
  @Test
  public void testSimpleEXGResultUY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,Y  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x32, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,S
   */
  @Test
  public void testSimpleEXGResultUS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,S  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x34, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,U
   */
  @Test
  public void testSimpleEXGResultUU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,U  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register U with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x33, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG U,PC
   */
  @Test
  public void testSimpleEXGResultUPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tU,PC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x35, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,A
   */
  @Test
  public void testSimpleEXGResultSA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x48, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,B
   */
  @Test
  public void testSimpleEXGResultSB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x49, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,D
   */
  @Test
  public void testSimpleEXGResultSD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,D  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x40, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,CC
   */
  @Test
  public void testSimpleEXGResultSCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x4A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,DP
   */
  @Test
  public void testSimpleEXGResultSDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x4B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,X
   */
  @Test
  public void testSimpleEXGResultSX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,X  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x41, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,Y
   */
  @Test
  public void testSimpleEXGResultSY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,Y  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x42, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,S
   */
  @Test
  public void testSimpleEXGResultSS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,S  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register S with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x44, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,U
   */
  @Test
  public void testSimpleEXGResultSU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,U  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x43, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG S,PC
   */
  @Test
  public void testSimpleEXGResultSPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tS,PC  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x45, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,A
   */
  @Test
  public void testSimpleEXGResultPCA() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,A  ; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x58, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,B
   */
  @Test
  public void testSimpleEXGResultPCB() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,B  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x59, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,D
   */
  @Test
  public void testSimpleEXGResultPCD() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,D  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x50, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,CC
   */
  @Test
  public void testSimpleEXGResultPCCC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,CC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x5A, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,DP
   */
  @Test
  public void testSimpleEXGResultPCDP() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,DP  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with a 8 bits register is suspicious");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x5B, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,X
   */
  @Test
  public void testSimpleEXGResultPCX() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,X  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x51, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,Y
   */
  @Test
  public void testSimpleEXGResultPCY() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,Y  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x52, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,S
   */
  @Test
  public void testSimpleEXGResultPCS() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,S  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x54, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,U
   */
  @Test
  public void testSimpleEXGResultPCU() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,U  \t\t\t; test EXG");
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
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x53, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check EXG PC,PC
   */
  @Test
  public void testSimpleEXGResultPCPC() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t$8000");
      _builder.newLine();
      _builder.append("ExgText\t   EXG\t\tPC,PC  \t\t\t; test EXG");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      this._validationTestHelper.assertWarning(result, 
        AssemblerPackage.eINSTANCE.getExgInstruction(), 
        InstructionValidator.ILLEGAL_EXCHANGE, 
        "Exchanging the register PC with itself has no effect");
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      AbstractAssemblyLine _assembledLine = engine.getAssembledLine(2);
      final AssembledEXGInstruction line = ((AssembledEXGInstruction) _assembledLine);
      Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
      Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
      Assert.assertEquals("Operand length", 1, line.getOperand().length);
      Assert.assertEquals("Check opcode", 0x55, line.getOperand()[0]);
      Assert.assertEquals("Check label", "ExgText", line.getLabel());
      Assert.assertEquals("Check comment", "; test EXG", line.getComment());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
