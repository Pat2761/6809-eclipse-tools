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
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
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
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI extended mode
   */
  @Test
  public void testCWAIExtendedAddressingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI extended mode
   */
  @Test
  public void testCWAIExtendedAddressingMode2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI extended indirect mode
   */
  @Test
  public void testCWAIExtendedIndirectAddressingMode1() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Constant-Offset Indexed
   */
  @Test
  public void testCWAIConstantOffsetIndexed() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Constant-Offset Indexed indirect
   */
  @Test
  public void testCWAIConstantOffsetIndexedIndirect() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Accumulator Indexed
   */
  @Test
  public void testCWAIAccumulatorIndexed() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Accumulator Indexed Indirect
   */
  @Test
  public void testCWAIAccumulatorIndexedIndirect() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Auto-Increment Indexed
   */
  @Test
  public void testCWAIAutoIncrementIndexed() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Auto-Increment Indexed Indirect
   */
  @Test
  public void testCWAIAutoIncrementIndexedIndirect() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Relative to PC Indexed
   */
  @Test
  public void testCWAIRelativePCIndexed() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check CWAI Relative to PC Indexed Indirect
   */
  @Test
  public void testCWAIRelativePCIndexedIndirect() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
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
   * Check Assembled CWAI immediate with limit negative operand
   */
  @Test
  public void testCWAIImmediatInstruction2() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled CWAI immediate with limit negative operand
   */
  @Test
  public void testCWAIImmediatInstruction3() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled CWAI immediate with positive limit operand
   */
  @Test
  public void testCWAIImmediatInstruction4() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }

  /**
   * Check Assembled CWAI immediate with positive limit operand
   */
  @Test
  public void testCWAIImmediatInstruction5() {
    throw new Error("Unresolved compilation problems:"
      + "\nAssembledCWAIInstruction cannot be resolved to a type."
      + "\noperand cannot be resolved"
      + "\nget cannot be resolved");
  }
}
