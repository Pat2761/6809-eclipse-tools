/*
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
 *
 */
package org.bpy.electronics.mc6809.assembler.tests.language.instructions;

import org.junit.runner.RunWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.junit.Test;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPXInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestCMPXInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	/**
	 * Check CMPX immediat
	 */
	@Test
	public void testCMPXImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			CMPX		#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX direct mode
	 */
	@Test
	public void testCMPXDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPX		  	<124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX extended mode
	 */
	@Test
	public void testCMPXExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPX		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX extended mode
	 */
	@Test
	public void testCMPXExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPX		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX extended indirect mode
	 */
	@Test
	public void testCMPXExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPX		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Constant-Offset Indexed
	 */
	@Test
	public void testCMPXConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPX		  	Const,X\n");
		strBuilder.append("			CMPX		  	,X\n");
		strBuilder.append("			CMPX		  	$9,U\n");
		strBuilder.append("			CMPX		  	$9,S\n");
		strBuilder.append("			CMPX		  	$9,X\n");
		strBuilder.append("			CMPX		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Constant-Offset Indexed indirect
	 */
	@Test
	public void testCMPXConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPX		  	[Const,X]\n");
		strBuilder.append("			CMPX		  	[,X]\n");
		strBuilder.append("			CMPX		  	[$9,U]\n");
		strBuilder.append("			CMPX		  	[$9,S]\n");
		strBuilder.append("			CMPX		  	[$9,X]\n");
		strBuilder.append("			CMPX		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Accumulator Indexed
	 */
	@Test
	public void testCMPXAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPX		  	A,X\n");
		strBuilder.append("			CMPX		  	B,X\n");
		strBuilder.append("			CMPX		  	D,U\n");
		strBuilder.append("			CMPX		  	A,S\n");
		strBuilder.append("			CMPX		  	B,X\n");
		strBuilder.append("			CMPX		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Accumulator Indexed Indirect
	 */
	@Test
	public void testCMPXAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	CMPX		  	[A,X]\n");
		strBuilder.append("			CMPX		  	[B,X]\n");
		strBuilder.append("			CMPX		  	[D,U]\n");
		strBuilder.append("			CMPX		  	[A,S]\n");
		strBuilder.append("			CMPX		  	[B,X]\n");
		strBuilder.append("			CMPX		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Auto-Increment Indexed
	 */
	@Test
	public void testCMPXAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	CMPX		  	,--X\n");
		strBuilder.append("	       	CMPX		  	,-X\n");
		strBuilder.append("	       	CMPX		  	,X+\n");
		strBuilder.append("	       	CMPX		  	,X++\n");
		strBuilder.append("	       	CMPX		  	,--S\n");
		strBuilder.append("	       	CMPX		  	,-S\n");
		strBuilder.append("	       	CMPX		  	,U+\n");
		strBuilder.append("	       	CMPX		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Auto-Increment Indexed Indirect
	 */
	@Test
	public void testCMPXAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	CMPX		  	[,--X]\n");
		strBuilder.append("	       	CMPX		  	[,X++]\n");
		strBuilder.append("	       	CMPX		  	[,--S]\n");
		strBuilder.append("	       	CMPX		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Relative to PC Indexed
	 */
	@Test
	public void testCMPXRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	CMPX		  	0,PC\n");
		strBuilder.append("	       	CMPX		  	,PC\n");
		strBuilder.append("	       	CMPX		  	Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX Relative to PC Indexed Indirect
	 */
	@Test
	public void testCMPXRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	CMPX		  	[0,PC]\n");
		strBuilder.append("	       	CMPX		  	[,PC]\n");
		strBuilder.append("	       	CMPX		  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPX instruction", adcInstruction.getInstruction(), "CMPX");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check CMPX instruction with duplicate label
	 */
	@Test
	public void testCMPXWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	CMPX		  	#Const+2\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), AssemblerEngine.DUPLICATE_LABEL,
					"Label Start is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate instruction
	 */
	@Test
	public void testCMPXImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG   		$8000\n");
		strBuilder.append("Const	   	EQU       	5\n");
		strBuilder.append("Start      	CMPX		  	#Const+2  ; 8000   8C 00 07        START:    CMPX\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x8C, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   8C 00 07        START:    CMPX", line.getComment());
			;
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate with limit negative operand
	 */
	@Test
	public void testCMPXImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPX		  	#-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate with limit negative operand
	 */
	@Test
	public void testCMPXImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	#-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate with positive limit operand
	 */
	@Test
	public void testCMPXImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPX		  	#127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate with positive limit operand
	 */
	@Test
	public void testCMPXImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPX		  	#65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX immediate with positive limit operand
	 */
	@Test
	public void testCMPXImmediatInstruction6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPX		  	#65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX direct mode instruction
	 */
	@Test
	public void testCMPXDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	<Const*2  ; 8000   9C 0A        START:    CMPX   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x9C, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   9C 0A        START:    CMPX   <Const*2 ", line.getComment());
			;

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX direct with limit negative operand
	 */
	@Test
	public void testCMPXDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX direct with limit negative operand
	 */
	@Test
	public void testCMPXDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX direct with positive limit operand
	 */
	@Test
	public void testCMPXDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX direct with positive limit operand
	 */
	@Test
	public void testCMPXDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended mode instruction
	 */
	@Test
	public void testCMPXExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	>Const*1000  ; 8000   BC 13 88     START:    CMPX   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xBC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   BC 13 88     START:    CMPX   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended with limit negative operand
	 */
	@Test
	public void testCMPXExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended with limit negative operand
	 */
	@Test
	public void testCMPXExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended with positive limit operand
	 */
	@Test
	public void testCMPXExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended with positive limit operand
	 */
	@Test
	public void testCMPXExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended indirect mode instruction
	 */
	@Test
	public void testCMPXExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    CMPX   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    CMPX   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended indirect with limit negative operand
	 */
	@Test
	public void testCMPXExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended indirect with limit negative operand
	 */
	@Test
	public void testCMPXExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended indirect with positive limit operand
	 */
	@Test
	public void testCMPXExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX extended indirect with positive limit operand
	 */
	@Test
	public void testCMPXExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start       	CMPX		  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	A,X  ; 8000   AB 86        START:    CMPX   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    CMPX   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	A,Y  ; 8000   	AC A6        START:    CMPX   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A6        START:    CMPX   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	A,U  ; 8000   	AC C6        START:    CMPX   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C6        START:    CMPX   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	A,S  ; 8000   	AC E6        START:    CMPX   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E6        START:    CMPX   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	B,X  ; 8000   AB 85        START:    CMPX   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPX   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	B,Y  ; 8000   	AC A5        START:    CMPX   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A5        START:    CMPX   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	B,U  ; 8000   	AC C5        START:    CMPX   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C5        START:    CMPX   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	B,S  ; 8000   	AC E5        START:    CMPX   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E5        START:    CMPX   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	D,X  ; 8000   AB 8B        START:    CMPX   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPX   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	D,Y  ; 8000   	AC AB        START:    CMPX   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC AB        START:    CMPX   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	D,U  ; 8000   	AC CB        START:    CMPX   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC CB        START:    CMPX   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	D,S  ; 8000   	AC EB        START:    CMPX   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC EB        START:    CMPX   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[A,X]  ; 8000   AB 96        START:    CMPX   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPX   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[A,Y]  ; 8000   	AC B6        START:    CMPX   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B6        START:    CMPX   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[A,U]  ; 8000   	AC D6        START:    CMPX   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D6        START:    CMPX   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[A,S]  ; 8000   	AC F6        START:    CMPX   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F6        START:    CMPX   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[B,X]  ; 8000   AB 95        START:    CMPX   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPX   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[B,Y]  ; 8000   	AC B5        START:    CMPX   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B5        START:    CMPX   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[B,U]  ; 8000   	AC D5        START:    CMPX   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D5        START:    CMPX   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[B,S]  ; 8000   	AC F5        START:    CMPX   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F5        START:    CMPX   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[D,X]  ; 8000   AB 9B        START:    CMPX   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPX   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[D,Y]  ; 8000   	AC BB        START:    CMPX   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC BB        START:    CMPX   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[D,U]  ; 8000   	AC DB        START:    CMPX   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC DB        START:    CMPX   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPXIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[D,S]  ; 8000   	AC FB        START:    CMPX   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC FB        START:    CMPX   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,X+  ; 8000   	AC 80        START:    CMPX   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 80        START:    CMPX   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,X++  ; 8000   	AC 81        START:    CMPX   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 81        START:    CMPX   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,Y+  ; 8000   	AC A0        START:    CMPX   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A0        START:    CMPX   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,Y++  ; 8000   	AC A1        START:    CMPX   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A1        START:    CMPX   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,S+  ; 8000   	AC E0        START:    CMPX   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E0        START:    CMPX   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,S++  ; 8000   	AC E1        START:    CMPX   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E1        START:    CMPX   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,U+  ; 8000   	AC C0        START:    CMPX   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C0        START:    CMPX   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,U++  ; 8000   	AC C1        START:    CMPX   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C1        START:    CMPX   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,-X  ; 8000   	AC 82        START:    CMPX   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 82        START:    CMPX   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,--X  ; 8000   	AC 83        START:    CMPX   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 83        START:    CMPX   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,-Y  ; 8000   	AC A2        START:    CMPX   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A2        START:    CMPX   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,--Y  ; 8000   	AC A3        START:    CMPX   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A3        START:    CMPX   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,-S  ; 8000   	AC E2        START:    CMPX   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E2        START:    CMPX   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,--S  ; 8000   	AC E3        START:    CMPX   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E3        START:    CMPX   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,-U  ; 8000   	AC C2        START:    CMPX   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C2        START:    CMPX   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	,--U  ; 8000   	AC C3        START:    CMPX   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C3        START:    CMPX   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,X+]  ; 8000   	AC 80        START:    CMPX   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,X++]  ; 8000   	AC 91        START:    CMPX   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 91        START:    CMPX   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,Y+]  ; 8000   	AC A0        START:    CMPX   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,Y++]  ; 8000   	AC B1        START:    CMPX   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B1        START:    CMPX   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,S+]  ; 8000   	AC E0        START:    CMPX   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,S++]  ; 8000   	AC F1        START:    CMPX   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F1        START:    CMPX   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,U+]  ; 8000   	AC C0        START:    CMPX   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,U++]  ; 8000   	AC D1        START:    CMPX   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D1        START:    CMPX   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,-X]  ; 8000   	AC 82        START:    CMPX   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,--X]  ; 8000   	AC 93        START:    CMPX   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 93        START:    CMPX   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,-Y]  ; 8000   	AC A2        START:    CMPX   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,--Y]  ; 8000   	AC B3        START:    CMPX   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B3        START:    CMPX   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,-S]  ; 8000   	AC E2        START:    CMPX   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,--S]  ; 8000   	AC F3        START:    CMPX   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F3        START:    CMPX   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,-U]  ; 8000   	AC C2        START:    CMPX   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPXIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPX		  	[,--U]  ; 8000   	AC D3        START:    CMPX   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D3        START:    CMPX   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1234,X  ; 8000   	AC 89 04 D2            CMPX   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 89 04 D2            CMPX   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1234,Y  ; 8000   	AB A9 04 D2            CMPX   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 04 D2            CMPX   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1234,U  ; 8000   	AC C9 04 D2            CMPX   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C9 04 D2            CMPX   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1234,S  ; 8000   	AC E9 04 D2            CMPX   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E9 04 D2            CMPX   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	34,X  ; 8000   	AC 88 22            CMPX   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 88 22            CMPX   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	34,Y  ; 8000   	AC A8 22            CMPX   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A8 22            CMPX   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	34,U  ; 8000   	AC C8 22            CMPX   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C8 22            CMPX   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	34,S  ; 8000   	AC E8 22            CMPX   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E8 22            CMPX   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	,X  ; 8000   	AC 84            CMPX   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 84            CMPX   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	,Y  ; 8000   	AC A4            CMPX   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A4            CMPX   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	,U  ; 8000   	AC C4            CMPX   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C4            CMPX   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	,S  ; 8000   	AC E4            CMPX   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E4            CMPX   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	0,X  ; 8000   	AC 84            CMPX   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 84            CMPX   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	0,Y  ; 8000   	AC A4            CMPX   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A4            CMPX   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	0,U  ; 8000   	AC C4            CMPX   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C4            CMPX   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	0,S  ; 8000   	AC E4            CMPX   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E4            CMPX   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-16,X  ; 8000   	AC 10            CMPX   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 10            CMPX   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1,X  ; 8000   	AC 01            CMPX   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 01            CMPX   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	15,X  ; 8000   	AC 0F            CMPX   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 0F            CMPX   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-16,Y  ; 8000   	AC 30            CMPX   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 30            CMPX   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1,Y  ; 8000   	AC 21            CMPX   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 21            CMPX   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	15,Y  ; 8000   	AC 2F            CMPX   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 2F            CMPX   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-16,U  ; 8000   	AC 50            CMPX   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 50            CMPX   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1,U  ; 8000   	AC 41            CMPX   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 41            CMPX   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	15,U  ; 8000   	AC 4F            CMPX   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 4F            CMPX   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-16,S  ; 8000   	AC 70            CMPX   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 70            CMPX   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	1,S  ; 8000   	AC 61            CMPX   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 61            CMPX   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	15,S  ; 8000   	AC 6F            CMPX   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 6F            CMPX   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-128,X  ; 8000   	AC 88 80            CMPX   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 88 80            CMPX   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	127,X  ; 8000   	AC 88 7F            CMPX   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 88 7F            CMPX   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-128,Y  ; 8000   	AC A8 80            CMPX   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A8 80            CMPX   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	127,Y  ; 8000   	AC A8 7F            CMPX   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC A8 7F            CMPX   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-128,U  ; 8000   	AC C8 80            CMPX   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C8 80            CMPX   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	127,U  ; 8000   	AC C8 7F            CMPX   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C8 7F            CMPX   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-128,S  ; 8000   	AC E8 80            CMPX   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E8 80            CMPX   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	127,S  ; 8000   	AC E8 7F            CMPX   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E8 7F            CMPX   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32768,X  ; 8000   	AC 89 80 00             CMPX   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 89 80 00             CMPX   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32767,X  ; 8000   	AC 89 7F FF             CMPX   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 89 7F FF             CMPX   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32768,Y  ; 8000   	AB A9 80 00             CMPX   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPX   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32767,Y  ; 8000   	AB A9 7F FF             CMPX   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPX   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32768,U  ; 8000   	AC C9 80 00             CMPX   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C9 80 00             CMPX   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32767,U  ; 8000   	AC C9 7F FF             CMPX   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C9 7F FF             CMPX   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32768,S  ; 8000   	AC E9 80 00             CMPX   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E9 80 00             CMPX   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32767,S  ; 8000   	AC E9 7F FF             CMPX   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E9 7F FF             CMPX   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32769,X  ; 8000   	AC 89 80 00             CMPX   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 89 80 00             CMPX   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32768,X  ; 8000   	AC 89 7F FF             CMPX   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 89 7F FF             CMPX   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32769,Y  ; 8000   	AB A9 80 00             CMPX   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPX   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32768,Y  ; 8000   	AB A9 7F FF             CMPX   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPX   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32769,U  ; 8000   	AC C9 80 00             CMPX   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C9 80 00             CMPX   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32768,U  ; 8000   	AC C9 7F FF             CMPX   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC C9 7F FF             CMPX   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32769,S  ; 8000   	AC E9 80 00             CMPX   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E9 80 00             CMPX   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  32768,S  ; 8000   	AC E9 7F FF             CMPX   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC E9 7F FF             CMPX   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[1234,X]  ; 8000   	AC 99 04 D2            CMPX   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 99 04 D2            CMPX   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[1234,Y]  ; 8000   	AC B9 04 D2            CMPX   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B9 04 D2            CMPX   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[1234,U]  ; 8000   	AC D9 04 D2            CMPX   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D9 04 D2            CMPX   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[1234,S]  ; 8000   	AC F9 04 D2            CMPX   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F9 04 D2            CMPX   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[34,X]  ; 8000   	AC 98 22            CMPX   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 98 22            CMPX   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[34,Y]  ; 8000   	AC B8 22            CMPX   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B8 22            CMPX   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[34,U]  ; 8000   	AC D8 22            CMPX   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D8 22            CMPX   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[34,S]  ; 8000   	AC F8 22            CMPX   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F8 22            CMPX   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[,X]  ; 8000   	AC 94            CMPX   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 94            CMPX   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[,Y]  ; 8000   	AC B4            CMPX   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B4            CMPX   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[,U]  ; 8000   	AC D4            CMPX   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D4            CMPX   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[,S]  ; 8000   	AC F4            CMPX   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F4            CMPX   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[0,X]  ; 8000   	AC 94            CMPX   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 94            CMPX   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[0,Y]  ; 8000   	AC B4            CMPX   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B4            CMPX   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[0,U]  ; 8000   	AC D4            CMPX   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D4            CMPX   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[0,S]  ; 8000   	AC F4            CMPX   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F4            CMPX   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-16,X]  ; 8000   	AC 98 F0            CMPX   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 98 F0            CMPX   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[15,X]  ; 8000   	AC 98 0F            CMPX   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 98 0F            CMPX   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-16,Y]  ; 8000   	AC B8 F0            CMPX   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B8 F0            CMPX   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[15,Y]  ; 8000   	AC B8 0F            CMPX   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B8 0F            CMPX   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-16,U]  ; 8000   	AC D8 F0            CMPX   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D8 F0            CMPX   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[15,U]  ; 8000   	AC D8 0F            CMPX   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D8 0F            CMPX   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-16,S]  ; 8000   	AC F8 F0            CMPX   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F8 F0            CMPX   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[15,S]  ; 8000   	AC F8 0F            CMPX   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F8 0F            CMPX   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-128,X]  ; 8000   	AC 98 80            CMPX   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 98 80            CMPX   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[127,X]  ; 8000   	AC 98 7F            CMPX   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 98 7F            CMPX   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-128,Y]  ; 8000   	AC B8 80            CMPX   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B8 80            CMPX   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[127,Y]  ; 8000   	AC B8 7F            CMPX   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B8 7F            CMPX   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-128,U]  ; 8000   	AC D8 80            CMPX   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D8 80            CMPX   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[127,U]  ; 8000   	AC D8 7F            CMPX   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D8 7F            CMPX   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-128,S]  ; 8000   	AC F8 80            CMPX   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F8 80            CMPX   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[127,S]  ; 8000   	AC F8 7F            CMPX   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F8 7F            CMPX   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768,X]  ; 8000   	AC 99 80 00             CMPX   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 99 80 00             CMPX   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32767,X]  ; 8000   	AC 99 7F FF             CMPX   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 99 7F FF             CMPX   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768,Y]  ; 8000   	AC B9 80 00             CMPX   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B9 80 00             CMPX   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32767,Y]  ; 8000   	AC B9 7F FF             CMPX   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B9 7F FF             CMPX   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768,U]  ; 8000   	AC D9 80 00             CMPX   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D9 80 00             CMPX   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32767,U]  ; 8000   	AC D9 7F FF             CMPX   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D9 7F FF             CMPX   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768,S]  ; 8000   	AC F9 80 00             CMPX   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F9 80 00             CMPX   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32767,S]  ; 8000   	AC F9 7F FF             CMPX   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F9 7F FF             CMPX   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769,X]  ; 8000   	AC 99 80 00             CMPX   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 99 80 00             CMPX   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32768,X]  ; 8000   	AC 99 7F FF             CMPX   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 99 7F FF             CMPX   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769,Y]  ; 8000   	AC B9 80 00             CMPX   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B9 80 00             CMPX   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32768,Y]  ; 8000   	AC B9 7F FF             CMPX   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC B9 7F FF             CMPX   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769,U]  ; 8000   	AC D9 80 00             CMPX   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D9 80 00             CMPX   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32768,U]  ; 8000   	AC D9 7F FF             CMPX   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC D9 7F FF             CMPX   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769,S]  ; 8000   	AC F9 80 00             CMPX   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F9 80 00             CMPX   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPXIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  [32768,S]  ; 8000   	AC F9 7F FF             CMPX   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC F9 7F FF             CMPX   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	0,PCR  ; 8000   	AC 8C 00            CMPX   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8C 00            CMPX   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-128,PCR  ; 8000   	AC 8C 80            CMPX   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8C 80            CMPX   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	127,PCR  ; 8000   	AC 8C 7F            CMPX   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8C 7F            CMPX   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-129,PCR  ; 8000   	AC 8D FF 7F            CMPX   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D FF 7F            CMPX   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	128,PCR  ; 8000   	AC 8D 00 80            CMPX   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D 00 80            CMPX   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32768,PCR  ; 8000   	AC 8D 80 00            CMPX   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D 80 00            CMPX   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	32767,PCR  ; 8000   	AC 8D 7F FF            CMPX   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D 7F FF            CMPX   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	-32769,PCR  ; 8000   	AC 8D 80 00            CMPX   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D 80 00            CMPX   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	32768,PCR  ; 8000   	AC 8D 7F FF            CMPX   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 8D 7F FF            CMPX   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[0,PCR]  ; 8000   	AC 9C 00            CMPX   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9C 00            CMPX   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-128,PCR]  ; 8000   	AC 9C 80            CMPX   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9C 80            CMPX   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[127,PCR]  ; 8000   	AC 9C 7F            CMPX   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9C 7F            CMPX   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-129,PCR]  ; 8000   	AC 9D FF 7F            CMPX   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D FF 7F            CMPX   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[128,PCR]  ; 8000   	AC 9D 00 80            CMPX   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D 00 80            CMPX   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32768,PCR]  ; 8000   	AC 9D 80 00            CMPX   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D 80 00            CMPX   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[32767,PCR]  ; 8000   	AC 9D 7F FF            CMPX   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D 7F FF            CMPX   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[-32769,PCR]  ; 8000   	AC 9D 80 00            CMPX   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D 80 00            CMPX   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled CMPX Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPXIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	CMPX		  	[32768,PCR]  ; 8000   	AC 9D 7F FF            CMPX   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPXInstruction line = (AssembledCMPXInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AC 9D 7F FF            CMPX   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}