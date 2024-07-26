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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDSInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestLDSInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	/**
	 * Check LDS immediat
	 */
	@Test
	public void testLDSImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			LDS			#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS direct mode
	 */
	@Test
	public void testLDSDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LDS		  	<124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS extended mode
	 */
	@Test
	public void testLDSExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LDS		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS extended mode
	 */
	@Test
	public void testLDSExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LDS		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS extended indirect mode
	 */
	@Test
	public void testLDSExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LDS		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Constant-Offset Indexed
	 */
	@Test
	public void testLDSConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LDS		  	Const,X\n");
		strBuilder.append("			LDS		  	,X\n");
		strBuilder.append("			LDS		  	$9,U\n");
		strBuilder.append("			LDS		  	$9,S\n");
		strBuilder.append("			LDS		  	$9,X\n");
		strBuilder.append("			LDS		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Constant-Offset Indexed indirect
	 */
	@Test
	public void testLDSConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LDS		  	[Const,X]\n");
		strBuilder.append("			LDS		  	[,X]\n");
		strBuilder.append("			LDS		  	[$9,U]\n");
		strBuilder.append("			LDS		  	[$9,S]\n");
		strBuilder.append("			LDS		  	[$9,X]\n");
		strBuilder.append("			LDS		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Accumulator Indexed
	 */
	@Test
	public void testLDSAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LDS		  	A,X\n");
		strBuilder.append("			LDS		  	B,X\n");
		strBuilder.append("			LDS		  	D,U\n");
		strBuilder.append("			LDS		  	A,S\n");
		strBuilder.append("			LDS		  	B,X\n");
		strBuilder.append("			LDS		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Accumulator Indexed Indirect
	 */
	@Test
	public void testLDSAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	LDS			  	[A,X]\n");
		strBuilder.append("				LDS		 	 	[B,X]\n");
		strBuilder.append("				LDS		  		[D,U]\n");
		strBuilder.append("				LDS		  		[A,S]\n");
		strBuilder.append("				LDS		  		[B,X]\n");
		strBuilder.append("				LDS		  		[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Auto-Increment Indexed
	 */
	@Test
	public void testLDSAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	LDS			  	,--X\n");
		strBuilder.append("	       	LDS			  	,-X\n");
		strBuilder.append("	       	LDS			  	,X+\n");
		strBuilder.append("	       	LDS		  		,X++\n");
		strBuilder.append("	       	LDS			  	,--S\n");
		strBuilder.append("	       	LDS			  	,-S\n");
		strBuilder.append("	       	LDS			  	,U+\n");
		strBuilder.append("	       	LDS		  		,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Auto-Increment Indexed Indirect
	 */
	@Test
	public void testLDSAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	LDS			  	[,--X]\n");
		strBuilder.append("	       	LDS			  	[,X++]\n");
		strBuilder.append("	       	LDS			  	[,--S]\n");
		strBuilder.append("	       	LDS		  		[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Relative to PC Indexed
	 */
	@Test
	public void testLDSRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	LDS			  	0,PC\n");
		strBuilder.append("	       	LDS			  	,PC\n");
		strBuilder.append("	       	LDS		  		Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS Relative to PC Indexed Indirect
	 */
	@Test
	public void testLDSRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	LDS			  	[0,PC]\n");
		strBuilder.append("	       	LDS			  	[,PC]\n");
		strBuilder.append("	       	LDS			  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LdInstruction);

			LdInstruction adcInstruction = (LdInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LDS instruction", adcInstruction.getInstruction(), "LDS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check LDS instruction with duplicate label
	 */
	@Test
	public void testLDSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	LDS		  	#Const+2\n");
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
	 * Check Assembled LDS immediate instruction
	 */
	@Test
	public void testLDSImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG   		$8000\n");
		strBuilder.append("Const	   	EQU       	5\n");
		strBuilder.append("Start      	LDS		  	#Const+2  ; 8000   10CE 00 07        START:    LDS\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xCE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   10CE 00 07        START:    LDS", line.getComment());
			;
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS immediate with limit negative operand
	 */
	@Test
	public void testLDSImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	#-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS immediate with limit negative operand
	 */
	@Test
	public void testLDSImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		#-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS immediate with positive limit operand
	 */
	@Test
	public void testLDSImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	#127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS immediate with positive limit operand
	 */
	@Test
	public void testLDSImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	#65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS immediate with positive limit operand
	 */
	@Test
	public void testLDSImmediatInstruction6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	#65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS direct mode instruction
	 */
	@Test
	public void testLDSDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		<Const*2  ; 8000   10DE 0A        START:    LDS   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xDE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   10DE 0A        START:    LDS   <Const*2 ", line.getComment());

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS direct with limit negative operand
	 */
	@Test
	public void testLDSDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS direct with limit negative operand
	 */
	@Test
	public void testLDSDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS direct with positive limit operand
	 */
	@Test
	public void testLDSDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS direct with positive limit operand
	 */
	@Test
	public void testLDSDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended mode instruction
	 */
	@Test
	public void testLDSExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		>Const*1000  ; 8000   10FE 13 88     START:    LDS   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xFE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   10FE 13 88     START:    LDS   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended with limit negative operand
	 */
	@Test
	public void testLDSExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended with limit negative operand
	 */
	@Test
	public void testLDSExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended with positive limit operand
	 */
	@Test
	public void testLDSExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended with positive limit operand
	 */
	@Test
	public void testLDSExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended indirect mode instruction
	 */
	@Test
	public void testLDSExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[Const*1000]  ; 8000   10A3 9F 13 88  START:    LDS   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 3, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[2]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   10A3 9F 13 88  START:    LDS   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended indirect with limit negative operand
	 */
	@Test
	public void testLDSExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended indirect with limit negative operand
	 */
	@Test
	public void testLDSExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended indirect with positive limit operand
	 */
	@Test
	public void testLDSExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS extended indirect with positive limit operand
	 */
	@Test
	public void testLDSExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start       	LDS			  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		A,X  ; 8000   AB 86        START:    LDS   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    LDS   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		A,Y  ; 8000   	10EE A6        START:    LDS   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A6        START:    LDS   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		A,U  ; 8000   	10EE C6        START:    LDS   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C6        START:    LDS   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		A,S  ; 8000   	10EE E6        START:    LDS   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E6        START:    LDS   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		B,X  ; 8000   AB 85        START:    LDS   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    LDS   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		B,Y  ; 8000   	10EE A5        START:    LDS   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A5        START:    LDS   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		B,U  ; 8000   	10EE C5        START:    LDS   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C5        START:    LDS   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		B,S  ; 8000   	10EE E5        START:    LDS   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E5        START:    LDS   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	D,X  ; 8000   AB 8B        START:    LDS   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    LDS   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		 	 	D,Y  ; 8000   	10EE AB        START:    LDS   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE AB        START:    LDS   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	D,U  ; 8000   	10EE CB        START:    LDS   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE CB        START:    LDS   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	D,S  ; 8000   	10EE EB        START:    LDS   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE EB        START:    LDS   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[A,X]  ; 8000   AB 96        START:    LDS   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    LDS   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[A,Y]  ; 8000   	10EE B6        START:    LDS   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B6        START:    LDS   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		 	 	[A,U]  ; 8000   	10EE D6        START:    LDS   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D6        START:    LDS   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[A,S]  ; 8000   	10EE F6        START:    LDS   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F6        START:    LDS   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[B,X]  ; 8000   AB 95        START:    LDS   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    LDS   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[B,Y]  ; 8000   	10EE B5        START:    LDS   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B5        START:    LDS   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		 	 	[B,U]  ; 8000   	10EE D5        START:    LDS   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D5        START:    LDS   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[B,S]  ; 8000   	10EE F5        START:    LDS   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F5        START:    LDS   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		 	 	[D,X]  ; 8000   AB 9B        START:    LDS   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    LDS   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[D,Y]  ; 8000   	10EE BB        START:    LDS   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE BB        START:    LDS   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[D,U]  ; 8000   	10EE DB        START:    LDS   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE DB        START:    LDS   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLDSIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[D,S]  ; 8000   	10EE FB        START:    LDS   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE FB        START:    LDS   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,X+  ; 8000   	10EE 80        START:    LDS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 80        START:    LDS   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,X++  ; 8000   	10EE 81        START:    LDS   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 81        START:    LDS   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,Y+  ; 8000   	10EE A0        START:    LDS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A0        START:    LDS   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,Y++  ; 8000   	10EE A1        START:    LDS   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A1        START:    LDS   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,S+  ; 8000   	10EE E0        START:    LDS   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E0        START:    LDS   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,S++  ; 8000   	10EE E1        START:    LDS   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E1        START:    LDS   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,U+  ; 8000   	10EE C0        START:    LDS   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C0        START:    LDS   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,U++  ; 8000   	10EE C1        START:    LDS   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C1        START:    LDS   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,-X  ; 8000   	10EE 82        START:    LDS   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 82        START:    LDS   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,--X  ; 8000   	10EE 83        START:    LDS   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 83        START:    LDS   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	,-Y  ; 8000   	10EE A2        START:    LDS   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A2        START:    LDS   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,--Y  ; 8000   	10EE A3        START:    LDS   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A3        START:    LDS   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,-S  ; 8000   	10EE E2        START:    LDS   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E2        START:    LDS   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,--S  ; 8000   	10EE E3        START:    LDS   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E3        START:    LDS   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,-U  ; 8000   	10EE C2        START:    LDS   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C2        START:    LDS   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		,--U  ; 8000   	10EE C3        START:    LDS   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C3        START:    LDS   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS			  	[,X+]  ; 8000   	10EE 80        START:    LDS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,X++]  ; 8000   	10EE 91        START:    LDS   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 91        START:    LDS   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,Y+]  ; 8000   	10EE A0        START:    LDS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,Y++]  ; 8000   	10EE B1        START:    LDS   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B1        START:    LDS   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Const	   	EQU         5\n");
		strBuilder.append("Start      	LDS		  	[,S+]  ; 8000   	10EE E0        START:    LDS   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,S++]  ; 8000   	10EE F1        START:    LDS   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F1        START:    LDS   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,U+]  ; 8000   	10EE C0        START:    LDS   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,U++]  ; 8000   	10EE D1        START:    LDS   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D1        START:    LDS   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,-X]  ; 8000   	10EE 82        START:    LDS   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,--X]  ; 8000   	10EE 93        START:    LDS   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 93        START:    LDS   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,-Y]  ; 8000   	10EE A2        START:    LDS   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,--Y]  ; 8000   	10EE B3        START:    LDS   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B3        START:    LDS   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,-S]  ; 8000   	10EE E2        START:    LDS   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,--S]  ; 8000   	10EE F3        START:    LDS   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F3        START:    LDS   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,-U]  ; 8000   	10EE C2        START:    LDS   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLDSIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LDS		  		[,--U]  ; 8000   	10EE D3        START:    LDS   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D3        START:    LDS   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	1234,X  ; 8000   	10EE 89 04 D2            LDS   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 89 04 D2            LDS   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		1234,Y  ; 8000   	AB A9 04 D2            LDS   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 04 D2            LDS   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		1234,U  ; 8000   	10EE C9 04 D2            LDS   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C9 04 D2            LDS   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		1234,S  ; 8000   	10EE E9 04 D2            LDS   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E9 04 D2            LDS   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		34,X  ; 8000   	10EE 88 22            LDS   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 88 22            LDS   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		34,Y  ; 8000   	10EE A8 22            LDS   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A8 22            LDS   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	34,U  ; 8000   	10EE C8 22            LDS   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C8 22            LDS   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	34,S  ; 8000   	10EE E8 22            LDS   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E8 22            LDS   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	,X  ; 8000   	10EE 84            LDS   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 84            LDS   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	,Y  ; 8000   	10EE A4            LDS   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A4            LDS   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		,U  ; 8000   	10EE C4            LDS   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C4            LDS   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	,S  ; 8000   	10EE E4            LDS   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E4            LDS   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	0,X  ; 8000   	10EE 84            LDS   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 84            LDS   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	0,Y  ; 8000   	10EE A4            LDS   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A4            LDS   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	0,U  ; 8000   	10EE C4            LDS   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C4            LDS   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	0,S  ; 8000   	10EE E4            LDS   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E4            LDS   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-16,X  ; 8000   	10EE 10            LDS   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 10            LDS   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	1,X  ; 8000   	10EE 01            LDS   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 01            LDS   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	15,X  ; 8000   	10EE 0F            LDS   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 0F            LDS   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-16,Y  ; 8000   	10EE 30            LDS   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 30            LDS   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	1,Y  ; 8000   	10EE 21            LDS   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 21            LDS   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	15,Y  ; 8000   	10EE 2F            LDS   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 2F            LDS   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-16,U  ; 8000   	10EE 50            LDS   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 50            LDS   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	1,U  ; 8000   	10EE 41            LDS   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 41            LDS   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	15,U  ; 8000   	10EE 4F            LDS   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 4F            LDS   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-16,S  ; 8000   	10EE 70            LDS   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 70            LDS   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		1,S  ; 8000   	10EE 61            LDS   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 61            LDS   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		15,S  ; 8000   	10EE 6F            LDS   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 6F            LDS   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	   -128,X  ; 8000   	10EE 88 80            LDS   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 88 80            LDS   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	127,X  ; 8000   	10EE 88 7F            LDS   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 88 7F            LDS   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-128,Y  ; 8000   	10EE A8 80            LDS   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A8 80            LDS   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	127,Y  ; 8000   	10EE A8 7F            LDS   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE A8 7F            LDS   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-128,U  ; 8000   	10EE C8 80            LDS   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C8 80            LDS   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG   		$8000\n");
		strBuilder.append("Start      	LDS		  	127,U  ; 8000   	10EE C8 7F            LDS   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C8 7F            LDS   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-128,S  ; 8000   	10EE E8 80            LDS   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E8 80            LDS   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	127,S  ; 8000   	10EE E8 7F            LDS   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E8 7F            LDS   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		-32768,X  ; 8000   	10EE 89 80 00             LDS   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 89 80 00             LDS   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	LDS		  32767,X  ; 8000   	10EE 89 7F FF             LDS   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 89 7F FF             LDS   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-32768,Y  ; 8000   	AB A9 80 00             LDS   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             LDS   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		32767,Y  ; 8000   	AB A9 7F FF             LDS   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             LDS   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	   -32768,U  ; 8000   	10EE C9 80 00             LDS   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C9 80 00             LDS   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	LDS		32767,U  ; 8000   	10EE C9 7F FF             LDS   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C9 7F FF             LDS   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	-32768,S  ; 8000   	10EE E9 80 00             LDS   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E9 80 00             LDS   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	LDS		  32767,S  ; 8000   	10EE E9 7F FF             LDS   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E9 7F FF             LDS   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	LDS		  	-32769,X  ; 8000   	10EE 89 80 00             LDS   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 89 80 00             LDS   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	LDS		32768,X  ; 8000   	10EE 89 7F FF             LDS   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 89 7F FF             LDS   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		-32769,Y  ; 8000   	AB A9 80 00             LDS   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             LDS   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    		$8000\n");
		strBuilder.append("Start      	LDS	  	  	32768,Y  ; 8000   	AB A9 7F FF             LDS   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             LDS   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	-32769,U  ; 8000   	10EE C9 80 00             LDS   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C9 80 00             LDS   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		32768,U  ; 8000   	10EE C9 7F FF             LDS   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE C9 7F FF             LDS   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		-32769,S  ; 8000   	10EE E9 80 00             LDS   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E9 80 00             LDS   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		32768,S  ; 8000   	10EE E9 7F FF             LDS   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE E9 7F FF             LDS   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[1234,X]  ; 8000   	10EE 99 04 D2            LDS   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 99 04 D2            LDS   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[1234,Y]  ; 8000   	10EE B9 04 D2            LDS   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B9 04 D2            LDS   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[1234,U]  ; 8000   	10EE D9 04 D2            LDS   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D9 04 D2            LDS   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[1234,S]  ; 8000   	10EE F9 04 D2            LDS   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F9 04 D2            LDS   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[34,X]  ; 8000   	10EE 98 22            LDS   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 98 22            LDS   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[34,Y]  ; 8000   	10EE B8 22            LDS   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B8 22            LDS   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[34,U]  ; 8000   	10EE D8 22            LDS   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D8 22            LDS   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[34,S]  ; 8000   	10EE F8 22            LDS   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F8 22            LDS   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[,X]  ; 8000   	10EE 94            LDS   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 94            LDS   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	 	 	ORG    			$8000\n");
		strBuilder.append("Start      	LDS			  	[,Y]  ; 8000   	10EE B4            LDS   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B4            LDS   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[,U]  ; 8000   	10EE D4            LDS   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D4            LDS   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[,S]  ; 8000   	10EE F4            LDS   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F4            LDS   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[0,X]  ; 8000   	10EE 94            LDS   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 94            LDS   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[0,Y]  ; 8000   	10EE B4            LDS   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B4            LDS   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[0,U]  ; 8000   	10EE D4            LDS   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D4            LDS   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[0,S]  ; 8000   	10EE F4            LDS   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F4            LDS   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[-16,X]  ; 8000   	10EE 98 F0            LDS   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 98 F0            LDS   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[15,X]  ; 8000   	10EE 98 0F            LDS   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 98 0F            LDS   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[-16,Y]  ; 8000   	10EE B8 F0            LDS   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B8 F0            LDS   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[15,Y]  ; 8000   	10EE B8 0F            LDS   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B8 0F            LDS   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[-16,U]  ; 8000   	10EE D8 F0            LDS   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D8 F0            LDS   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[15,U]  ; 8000   	10EE D8 0F            LDS   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D8 0F            LDS   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[-16,S]  ; 8000   	10EE F8 F0            LDS   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F8 F0            LDS   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[15,S]  ; 8000   	10EE F8 0F            LDS   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F8 0F            LDS   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-128,X]  ; 8000   	10EE 98 80            LDS   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 98 80            LDS   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	   [127,X]  ; 8000   	10EE 98 7F            LDS   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 98 7F            LDS   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  		[-128,Y]  ; 8000   	10EE B8 80            LDS   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B8 80            LDS   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[127,Y]  ; 8000   	10EE B8 7F            LDS   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B8 7F            LDS   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-128,U]  ; 8000   	10EE D8 80            LDS   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D8 80            LDS   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[127,U]  ; 8000   	10EE D8 7F            LDS   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D8 7F            LDS   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-128,S]  ; 8000   	10EE F8 80            LDS   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F8 80            LDS   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[127,S]  ; 8000   	10EE F8 7F            LDS   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F8 7F            LDS   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32768,X]  ; 8000   	10EE 99 80 00             LDS   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 99 80 00             LDS   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32767,X]  ; 8000   	10EE 99 7F FF             LDS   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 99 7F FF             LDS   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32768,Y]  ; 8000   	10EE B9 80 00             LDS   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B9 80 00             LDS   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32767,Y]  ; 8000   	10EE B9 7F FF             LDS   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B9 7F FF             LDS   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32768,U]  ; 8000   	10EE D9 80 00             LDS   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D9 80 00             LDS   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32767,U]  ; 8000   	10EE D9 7F FF             LDS   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D9 7F FF             LDS   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32768,S]  ; 8000   	10EE F9 80 00             LDS   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F9 80 00             LDS   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32767,S]  ; 8000   	10EE F9 7F FF             LDS   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F9 7F FF             LDS   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32769,X]  ; 8000   	10EE 99 80 00             LDS   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 99 80 00             LDS   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32768,X]  ; 8000   	10EE 99 7F FF             LDS   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 99 7F FF             LDS   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32769,Y]  ; 8000   	10EE B9 80 00             LDS   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B9 80 00             LDS   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32768,Y]  ; 8000   	10EE B9 7F FF             LDS   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE B9 7F FF             LDS   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32769,U]  ; 8000   	10EE D9 80 00             LDS   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D9 80 00             LDS   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32768,U]  ; 8000   	10EE D9 7F FF             LDS   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE D9 7F FF             LDS   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32769,S]  ; 8000   	10EE F9 80 00             LDS   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F9 80 00             LDS   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLDSIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  [32768,S]  ; 8000   	10EE F9 7F FF             LDS   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE F9 7F FF             LDS   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	0,PCR  ; 8000   	10EE 8C 00            LDS   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8C 00            LDS   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	-128,PCR  ; 8000   	10EE 8C 80            LDS   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8C 80            LDS   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	127,PCR  ; 8000   	10EE 8C 7F            LDS   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8C 7F            LDS   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	-129,PCR  ; 8000   	10EE 8D FF 7F            LDS   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D FF 7F            LDS   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	128,PCR  ; 8000   	10EE 8D 00 80            LDS   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D 00 80            LDS   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	-32768,PCR  ; 8000   	10EE 8D 80 00            LDS   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D 80 00            LDS   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	32767,PCR  ; 8000   	10EE 8D 7F FF            LDS   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D 7F FF            LDS   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	-32769,PCR  ; 8000   	10EE 8D 80 00            LDS   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D 80 00            LDS   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	32768,PCR  ; 8000   	10EE 8D 7F FF            LDS   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 8D 7F FF            LDS   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[0,PCR]  ; 8000   	10EE 9C 00            LDS   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9C 00            LDS   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-128,PCR]  ; 8000   	10EE 9C 80            LDS   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9C 80            LDS   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[127,PCR]  ; 8000   	10EE 9C 7F            LDS   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9C 7F            LDS   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-129,PCR]  ; 8000   	10EE 9D FF 7F            LDS   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D FF 7F            LDS   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[128,PCR]  ; 8000   	10EE 9D 00 80            LDS   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D 00 80            LDS   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32768,PCR]  ; 8000   	10EE 9D 80 00            LDS   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D 80 00            LDS   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[32767,PCR]  ; 8000   	10EE 9D 7F FF            LDS   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D 7F FF            LDS   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[-32769,PCR]  ; 8000   	10EE 9D 80 00            LDS   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D 80 00            LDS   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLDSIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	LDS		  	[32768,PCR]  ; 8000   	10EE 9D 7F FF            LDS   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getLdInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledLDSInstruction line = (AssembledLDSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xEE, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10EE 9D 7F FF            LDS   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}