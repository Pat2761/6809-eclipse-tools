package org.bpy.electronics.mc6809.assembler.tests.instructions;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
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
public class TestADCInstruction {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check ADCA immediat
   */
  @Test
  public void testADCAImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCA\t\t  \t#124");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA direct mode
   */
  @Test
  public void testADCADirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCA\t\t  \t<124");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA extended mode
   */
  @Test
  public void testADCAExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCA\t\t  \t$1234");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA extended mode
   */
  @Test
  public void testADCAExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCA\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA extended indirect mode
   */
  @Test
  public void testADCAExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCA\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Constant-Offset Indexed
   */
  @Test
  public void testADCAConstantOffsetIndexed() {
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
      _builder.append("ADCA\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Constant-Offset Indexed indirect
   */
  @Test
  public void testADCAConstantOffsetIndexedIndirect() {
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
      _builder.append("ADCA\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Accumulator Indexed
   */
  @Test
  public void testADCAAccumulatorIndexed() {
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
      _builder.append("ADCA\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Accumulator Indexed Indirect
   */
  @Test
  public void testADCAAccumulatorIndexedIndirect() {
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
      _builder.append("ADCA\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCA\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Auto-Increment Indexed
   */
  @Test
  public void testADCAAutoIncrementIndexed() {
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
      _builder.append("ADCA\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Auto-Increment Indexed Indirect
   */
  @Test
  public void testADCAAutoIncrementIndexedIndirect() {
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
      _builder.append("ADCA\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Relative to PC Indexed
   */
  @Test
  public void testADCARelativePCIndexed() {
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
      _builder.append("ADCA\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCA Relative to PC Indexed Indirect
   */
  @Test
  public void testADCARelativePCIndexedIndirect() {
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
      _builder.append("ADCA\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCA\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(), "ADCA");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB immediat
   */
  @Test
  public void testADCBImemdiatAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCB\t\t  \t#124");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be an immediate addressing mode", (_operand instanceof ImmediatOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB direct mode
   */
  @Test
  public void testADCBDirectAddressingMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCB\t\t  \t<124");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a direct addressing mode", (_operand instanceof DirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB extended mode
   */
  @Test
  public void testADCBExtendedAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCB\t\t  \t$1234");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB extended mode
   */
  @Test
  public void testADCBExtendedAddressingMode2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCB\t\t  \t>$1234");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended addressing mode", (_operand instanceof ExtendedOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB extended indirect mode
   */
  @Test
  public void testADCBExtendedIndirectAddressingMode1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    \t\t$8000");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ADCB\t\t  \t[$1234]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a extended indirect addressing mode", (_operand instanceof ExtendedIndirectOperand));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Constant-Offset Indexed
   */
  @Test
  public void testADCBConstantOffsetIndexed() {
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
      _builder.append("ADCB\t\t  \tConst,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t$9,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t$9,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t$9,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t$9,Y");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_mode instanceof ConstantIndexedMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Constant-Offset Indexed indirect
   */
  @Test
  public void testADCBConstantOffsetIndexedIndirect() {
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
      _builder.append("ADCB\t\t  \t[Const,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[$9,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[$9,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[$9,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[$9,Y]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Constant-Offset Indexed indirect mode", (_mode instanceof ConstantIndexedMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Accumulator Indexed
   */
  @Test
  public void testADCBAccumulatorIndexed() {
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
      _builder.append("ADCB\t\t  \tA,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \tD,U");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \tA,S");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \tB,X");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \tD,Y");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed mode", (_mode instanceof AccumulatorMovingMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Accumulator Indexed Indirect
   */
  @Test
  public void testADCBAccumulatorIndexedIndirect() {
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
      _builder.append("ADCB\t\t  \t[A,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[D,U]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[A,S]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[B,X]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ADCB\t\t  \t[D,Y]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Accumulator Indexed indirect mode", (_mode instanceof AccumulatorMovingIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Auto-Increment Indexed
   */
  @Test
  public void testADCBAutoIncrementIndexed() {
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
      _builder.append("ADCB\t\t  \t0,--X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t0,-X");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \tConst,X+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \tConst,X++");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t0,--S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t0,-S");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \tConst,U+");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \tConst,U++");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed mode", (_mode instanceof AutoIncDecMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Auto-Increment Indexed Indirect
   */
  @Test
  public void testADCBAutoIncrementIndexedIndirect() {
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
      _builder.append("ADCB\t\t  \t[0,--X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[0,-X]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[Const,X+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[Const,X++]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[0,--S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[0,-S]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[Const,U+]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[Const,U++]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Auto-Increment Indexed indirect mode", (_mode instanceof AutoIncDecIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Relative to PC Indexed
   */
  @Test
  public void testADCBRelativePCIndexed() {
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
      _builder.append("ADCB\t\t  \t0,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t,PCR");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \tConst,PCR");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed mode", (_mode instanceof RelatifToPCMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check ADCB Relative to PC Indexed Indirect
   */
  @Test
  public void testADCBRelativePCIndexedIndirect() {
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
      _builder.append("ADCB\t\t  \t[0,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[,PCR]");
      _builder.newLine();
      _builder.append("\t       \t");
      _builder.append("ADCB\t\t  \t[Const,PCR]");
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
      Assert.assertTrue("Must be an ADC directive line", (_instruction instanceof AdcInstruction));
      EObject _instruction_1 = instructionLine.getInstruction();
      final AdcInstruction adcInstruction = ((AdcInstruction) _instruction_1);
      Assert.assertEquals("Must be an ADCB instruction", adcInstruction.getInstruction(), "ADCB");
      EObject _operand = adcInstruction.getOperand();
      Assert.assertTrue("Must be a Constant-Offset Indexed mode", (_operand instanceof IndexedOperand));
      EObject _operand_1 = adcInstruction.getOperand();
      final IndexedOperand indexedOperand = ((IndexedOperand) _operand_1);
      EObject _mode = indexedOperand.getMode();
      Assert.assertTrue("Must be a Relative to Indexed Indirect mode", (_mode instanceof RelatifToPCIndirectMode));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
