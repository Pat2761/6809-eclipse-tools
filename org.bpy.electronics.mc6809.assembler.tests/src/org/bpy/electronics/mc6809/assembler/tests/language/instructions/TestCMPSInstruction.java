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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPSInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestCMPSInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	/**
	 * Check CMPS immediat
	 */
	@Test
	public void testCMPSImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			CMPS			#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(1);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof CmpInstruction);

			CmpInstruction adcInstruction = (CmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS direct mode
	 */
	@Test
	public void testCMPSDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPS		  	<124\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS extended mode
	 */
	@Test
	public void testCMPSExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPS		  	$1234\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS extended mode
	 */
	@Test
	public void testCMPSExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPS		  	>$1234\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS extended indirect mode
	 */
	@Test
	public void testCMPSExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPS		  	[$1234]\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Constant-Offset Indexed
	 */
	@Test
	public void testCMPSConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPS		  	Const,X\n");
		strBuilder.append("			CMPS		  	,X\n");
		strBuilder.append("			CMPS		  	$9,U\n");
		strBuilder.append("			CMPS		  	$9,S\n");
		strBuilder.append("			CMPS		  	$9,X\n");
		strBuilder.append("			CMPS		  	$9,Y\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Constant-Offset Indexed indirect
	 */
	@Test
	public void testCMPSConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPS		  	[Const,X]\n");
		strBuilder.append("			CMPS		  	[,X]\n");
		strBuilder.append("			CMPS		  	[$9,U]\n");
		strBuilder.append("			CMPS		  	[$9,S]\n");
		strBuilder.append("			CMPS		  	[$9,X]\n");
		strBuilder.append("			CMPS		  	[$9,Y]\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Accumulator Indexed
	 */
	@Test
	public void testCMPSAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPS		  	A,X\n");
		strBuilder.append("			CMPS		  	B,X\n");
		strBuilder.append("			CMPS		  	D,U\n");
		strBuilder.append("			CMPS		  	A,S\n");
		strBuilder.append("			CMPS		  	B,X\n");
		strBuilder.append("			CMPS		  	D,Y\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Accumulator Indexed Indirect
	 */
	@Test
	public void testCMPSAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPS			  	[A,X]\n");
		strBuilder.append("				CMPS		 	 	[B,X]\n");
		strBuilder.append("				CMPS		  		[D,U]\n");
		strBuilder.append("				CMPS		  		[A,S]\n");
		strBuilder.append("				CMPS		  		[B,X]\n");
		strBuilder.append("				CMPS		  		[D,Y]\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Auto-Increment Indexed
	 */
	@Test
	public void testCMPSAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPS			  	,--X\n");
		strBuilder.append("	       	CMPS			  	,-X\n");
		strBuilder.append("	       	CMPS			  	,X+\n");
		strBuilder.append("	       	CMPS		  		,X++\n");
		strBuilder.append("	       	CMPS			  	,--S\n");
		strBuilder.append("	       	CMPS			  	,-S\n");
		strBuilder.append("	       	CMPS			  	,U+\n");
		strBuilder.append("	       	CMPS		  		,U++\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Auto-Increment Indexed Indirect
	 */
	@Test
	public void testCMPSAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPS			  	[,--X]\n");
		strBuilder.append("	       	CMPS			  	[,X++]\n");
		strBuilder.append("	       	CMPS			  	[,--S]\n");
		strBuilder.append("	       	CMPS		  		[,U++]\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Relative to PC Indexed
	 */
	@Test
	public void testCMPSRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPS			  	0,PC\n");
		strBuilder.append("	       	CMPS			  	,PC\n");
		strBuilder.append("	       	CMPS		  		Const,PC\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS Relative to PC Indexed Indirect
	 */
	@Test
	public void testCMPSRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPS			  	[0,PC]\n");
		strBuilder.append("	       	CMPS			  	[,PC]\n");
		strBuilder.append("	       	CMPS			  	[Const,PC]\n");
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
			assertEquals("Must be an CMPS instruction", adcInstruction.getInstruction(), "CMPS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPS instruction with duplicate label
	 */
	@Test
	public void testCMPSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	CMPS		  	#Const+2\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), InstructionValidator.DUPLICATE_LABEL,
					"Label Start is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate instruction
	 */
	@Test
	public void testCMPSImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG   		$8000\n");
		strBuilder.append("Const	   	EQU       	5\n");
		strBuilder.append("Start      	CMPS		  	#Const+2  ; 8000   118C 00 07        START:    CMPS\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x8C, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   118C 00 07        START:    CMPS", line.getComment());
			;
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate with limit negative operand
	 */
	@Test
	public void testCMPSImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	#-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate with limit negative operand
	 */
	@Test
	public void testCMPSImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		#-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate with positive limit operand
	 */
	@Test
	public void testCMPSImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	#127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate with positive limit operand
	 */
	@Test
	public void testCMPSImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	#65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS immediate with positive limit operand
	 */
	@Test
	public void testCMPSImmediatInstruction6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	#65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS direct mode instruction
	 */
	@Test
	public void testCMPSDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		<Const*2  ; 8000   119C 0A        START:    CMPS   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9C, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   119C 0A        START:    CMPS   <Const*2 ", line.getComment());

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS direct with limit negative operand
	 */
	@Test
	public void testCMPSDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS direct with limit negative operand
	 */
	@Test
	public void testCMPSDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS direct with positive limit operand
	 */
	@Test
	public void testCMPSDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS direct with positive limit operand
	 */
	@Test
	public void testCMPSDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended mode instruction
	 */
	@Test
	public void testCMPSExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		>Const*1000  ; 8000   11BC 13 88     START:    CMPS   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xBC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   11BC 13 88     START:    CMPS   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended with limit negative operand
	 */
	@Test
	public void testCMPSExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended with limit negative operand
	 */
	@Test
	public void testCMPSExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended with positive limit operand
	 */
	@Test
	public void testCMPSExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended with positive limit operand
	 */
	@Test
	public void testCMPSExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended indirect mode instruction
	 */
	@Test
	public void testCMPSExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[Const*1000]  ; 8000   11AC 9F 13 88  START:    CMPS   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 3, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[2]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   11AC 9F 13 88  START:    CMPS   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended indirect with limit negative operand
	 */
	@Test
	public void testCMPSExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended indirect with limit negative operand
	 */
	@Test
	public void testCMPSExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended indirect with positive limit operand
	 */
	@Test
	public void testCMPSExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS extended indirect with positive limit operand
	 */
	@Test
	public void testCMPSExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start       	CMPS			  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		A,X  ; 8000   AB 86        START:    CMPS   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    CMPS   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		A,Y  ; 8000   	11AC A6        START:    CMPS   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A6        START:    CMPS   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		A,U  ; 8000   	11AC C6        START:    CMPS   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C6        START:    CMPS   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		A,S  ; 8000   	11AC E6        START:    CMPS   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E6        START:    CMPS   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		B,X  ; 8000   AB 85        START:    CMPS   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPS   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		B,Y  ; 8000   	11AC A5        START:    CMPS   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A5        START:    CMPS   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		B,U  ; 8000   	11AC C5        START:    CMPS   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C5        START:    CMPS   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		B,S  ; 8000   	11AC E5        START:    CMPS   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E5        START:    CMPS   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	D,X  ; 8000   AB 8B        START:    CMPS   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPS   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		 	 	D,Y  ; 8000   	11AC AB        START:    CMPS   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC AB        START:    CMPS   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	D,U  ; 8000   	11AC CB        START:    CMPS   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC CB        START:    CMPS   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	D,S  ; 8000   	11AC EB        START:    CMPS   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC EB        START:    CMPS   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[A,X]  ; 8000   AB 96        START:    CMPS   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPS   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[A,Y]  ; 8000   	11AC B6        START:    CMPS   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B6        START:    CMPS   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		 	 	[A,U]  ; 8000   	11AC D6        START:    CMPS   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D6        START:    CMPS   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[A,S]  ; 8000   	11AC F6        START:    CMPS   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F6        START:    CMPS   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[B,X]  ; 8000   AB 95        START:    CMPS   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPS   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[B,Y]  ; 8000   	11AC B5        START:    CMPS   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B5        START:    CMPS   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		 	 	[B,U]  ; 8000   	11AC D5        START:    CMPS   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D5        START:    CMPS   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[B,S]  ; 8000   	11AC F5        START:    CMPS   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F5        START:    CMPS   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		 	 	[D,X]  ; 8000   AB 9B        START:    CMPS   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPS   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[D,Y]  ; 8000   	11AC BB        START:    CMPS   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC BB        START:    CMPS   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[D,U]  ; 8000   	11AC DB        START:    CMPS   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC DB        START:    CMPS   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPSIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[D,S]  ; 8000   	11AC FB        START:    CMPS   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC FB        START:    CMPS   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,X+  ; 8000   	11AC 80        START:    CMPS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 80        START:    CMPS   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,X++  ; 8000   	11AC 81        START:    CMPS   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 81        START:    CMPS   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,Y+  ; 8000   	11AC A0        START:    CMPS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A0        START:    CMPS   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,Y++  ; 8000   	11AC A1        START:    CMPS   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A1        START:    CMPS   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,S+  ; 8000   	11AC E0        START:    CMPS   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E0        START:    CMPS   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,S++  ; 8000   	11AC E1        START:    CMPS   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E1        START:    CMPS   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,U+  ; 8000   	11AC C0        START:    CMPS   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C0        START:    CMPS   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,U++  ; 8000   	11AC C1        START:    CMPS   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C1        START:    CMPS   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,-X  ; 8000   	11AC 82        START:    CMPS   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 82        START:    CMPS   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,--X  ; 8000   	11AC 83        START:    CMPS   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 83        START:    CMPS   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	,-Y  ; 8000   	11AC A2        START:    CMPS   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A2        START:    CMPS   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,--Y  ; 8000   	11AC A3        START:    CMPS   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A3        START:    CMPS   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,-S  ; 8000   	11AC E2        START:    CMPS   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E2        START:    CMPS   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,--S  ; 8000   	11AC E3        START:    CMPS   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E3        START:    CMPS   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,-U  ; 8000   	11AC C2        START:    CMPS   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C2        START:    CMPS   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		,--U  ; 8000   	11AC C3        START:    CMPS   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C3        START:    CMPS   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS			  	[,X+]  ; 8000   	11AC 80        START:    CMPS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,X++]  ; 8000   	11AC 91        START:    CMPS   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 91        START:    CMPS   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,Y+]  ; 8000   	11AC A0        START:    CMPS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,Y++]  ; 8000   	11AC B1        START:    CMPS   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B1        START:    CMPS   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Const	   	EQU         5\n");
		strBuilder.append("Start      	CMPS		  	[,S+]  ; 8000   	11AC E0        START:    CMPS   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,S++]  ; 8000   	11AC F1        START:    CMPS   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F1        START:    CMPS   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,U+]  ; 8000   	11AC C0        START:    CMPS   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,U++]  ; 8000   	11AC D1        START:    CMPS   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D1        START:    CMPS   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,-X]  ; 8000   	11AC 82        START:    CMPS   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,--X]  ; 8000   	11AC 93        START:    CMPS   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 93        START:    CMPS   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,-Y]  ; 8000   	11AC A2        START:    CMPS   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,--Y]  ; 8000   	11AC B3        START:    CMPS   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B3        START:    CMPS   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,-S]  ; 8000   	11AC E2        START:    CMPS   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,--S]  ; 8000   	11AC F3        START:    CMPS   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F3        START:    CMPS   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,-U]  ; 8000   	11AC C2        START:    CMPS   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPSIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPS		  		[,--U]  ; 8000   	11AC D3        START:    CMPS   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D3        START:    CMPS   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	1234,X  ; 8000   	11AC 89 04 D2            CMPS   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 89 04 D2            CMPS   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		1234,Y  ; 8000   	AB A9 04 D2            CMPS   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 04 D2            CMPS   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		1234,U  ; 8000   	11AC C9 04 D2            CMPS   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C9 04 D2            CMPS   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		1234,S  ; 8000   	11AC E9 04 D2            CMPS   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E9 04 D2            CMPS   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		34,X  ; 8000   	11AC 88 22            CMPS   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 88 22            CMPS   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		34,Y  ; 8000   	11AC A8 22            CMPS   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A8 22            CMPS   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	34,U  ; 8000   	11AC C8 22            CMPS   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C8 22            CMPS   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	34,S  ; 8000   	11AC E8 22            CMPS   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E8 22            CMPS   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	,X  ; 8000   	11AC 84            CMPS   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 84            CMPS   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	,Y  ; 8000   	11AC A4            CMPS   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A4            CMPS   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		,U  ; 8000   	11AC C4            CMPS   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C4            CMPS   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	,S  ; 8000   	11AC E4            CMPS   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E4            CMPS   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	0,X  ; 8000   	11AC 84            CMPS   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 84            CMPS   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	0,Y  ; 8000   	11AC A4            CMPS   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A4            CMPS   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	0,U  ; 8000   	11AC C4            CMPS   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C4            CMPS   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	0,S  ; 8000   	11AC E4            CMPS   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E4            CMPS   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-16,X  ; 8000   	11AC 10            CMPS   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 10            CMPS   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	1,X  ; 8000   	11AC 01            CMPS   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 01            CMPS   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	15,X  ; 8000   	11AC 0F            CMPS   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 0F            CMPS   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-16,Y  ; 8000   	11AC 30            CMPS   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 30            CMPS   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	1,Y  ; 8000   	11AC 21            CMPS   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 21            CMPS   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	15,Y  ; 8000   	11AC 2F            CMPS   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 2F            CMPS   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-16,U  ; 8000   	11AC 50            CMPS   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 50            CMPS   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	1,U  ; 8000   	11AC 41            CMPS   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 41            CMPS   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	15,U  ; 8000   	11AC 4F            CMPS   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 4F            CMPS   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-16,S  ; 8000   	11AC 70            CMPS   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 70            CMPS   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		1,S  ; 8000   	11AC 61            CMPS   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 61            CMPS   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		15,S  ; 8000   	11AC 6F            CMPS   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 6F            CMPS   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	   -128,X  ; 8000   	11AC 88 80            CMPS   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 88 80            CMPS   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	127,X  ; 8000   	11AC 88 7F            CMPS   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 88 7F            CMPS   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-128,Y  ; 8000   	11AC A8 80            CMPS   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A8 80            CMPS   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	127,Y  ; 8000   	11AC A8 7F            CMPS   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC A8 7F            CMPS   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-128,U  ; 8000   	11AC C8 80            CMPS   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C8 80            CMPS   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG   		$8000\n");
		strBuilder.append("Start      	CMPS		  	127,U  ; 8000   	11AC C8 7F            CMPS   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C8 7F            CMPS   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-128,S  ; 8000   	11AC E8 80            CMPS   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E8 80            CMPS   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	127,S  ; 8000   	11AC E8 7F            CMPS   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E8 7F            CMPS   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		-32768,X  ; 8000   	11AC 89 80 00             CMPS   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 89 80 00             CMPS   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	CMPS		  32767,X  ; 8000   	11AC 89 7F FF             CMPS   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 89 7F FF             CMPS   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-32768,Y  ; 8000   	AB A9 80 00             CMPS   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPS   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		32767,Y  ; 8000   	AB A9 7F FF             CMPS   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPS   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	   -32768,U  ; 8000   	11AC C9 80 00             CMPS   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C9 80 00             CMPS   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	CMPS		32767,U  ; 8000   	11AC C9 7F FF             CMPS   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C9 7F FF             CMPS   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	-32768,S  ; 8000   	11AC E9 80 00             CMPS   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E9 80 00             CMPS   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	CMPS		  32767,S  ; 8000   	11AC E9 7F FF             CMPS   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E9 7F FF             CMPS   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPS		  	-32769,X  ; 8000   	11AC 89 80 00             CMPS   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 89 80 00             CMPS   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	CMPS		32768,X  ; 8000   	11AC 89 7F FF             CMPS   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 89 7F FF             CMPS   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		-32769,Y  ; 8000   	AB A9 80 00             CMPS   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPS   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    		$8000\n");
		strBuilder.append("Start      	CMPS	  	  	32768,Y  ; 8000   	AB A9 7F FF             CMPS   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPS   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	-32769,U  ; 8000   	11AC C9 80 00             CMPS   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C9 80 00             CMPS   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		32768,U  ; 8000   	11AC C9 7F FF             CMPS   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC C9 7F FF             CMPS   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		-32769,S  ; 8000   	11AC E9 80 00             CMPS   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E9 80 00             CMPS   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		32768,S  ; 8000   	11AC E9 7F FF             CMPS   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC E9 7F FF             CMPS   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[1234,X]  ; 8000   	11AC 99 04 D2            CMPS   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 99 04 D2            CMPS   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[1234,Y]  ; 8000   	11AC B9 04 D2            CMPS   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B9 04 D2            CMPS   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[1234,U]  ; 8000   	11AC D9 04 D2            CMPS   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D9 04 D2            CMPS   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[1234,S]  ; 8000   	11AC F9 04 D2            CMPS   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F9 04 D2            CMPS   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[34,X]  ; 8000   	11AC 98 22            CMPS   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 98 22            CMPS   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[34,Y]  ; 8000   	11AC B8 22            CMPS   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B8 22            CMPS   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[34,U]  ; 8000   	11AC D8 22            CMPS   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D8 22            CMPS   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[34,S]  ; 8000   	11AC F8 22            CMPS   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F8 22            CMPS   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[,X]  ; 8000   	11AC 94            CMPS   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 94            CMPS   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	 	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS			  	[,Y]  ; 8000   	11AC B4            CMPS   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B4            CMPS   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[,U]  ; 8000   	11AC D4            CMPS   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D4            CMPS   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[,S]  ; 8000   	11AC F4            CMPS   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F4            CMPS   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[0,X]  ; 8000   	11AC 94            CMPS   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 94            CMPS   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[0,Y]  ; 8000   	11AC B4            CMPS   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B4            CMPS   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[0,U]  ; 8000   	11AC D4            CMPS   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D4            CMPS   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[0,S]  ; 8000   	11AC F4            CMPS   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F4            CMPS   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[-16,X]  ; 8000   	11AC 98 F0            CMPS   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 98 F0            CMPS   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[15,X]  ; 8000   	11AC 98 0F            CMPS   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 98 0F            CMPS   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[-16,Y]  ; 8000   	11AC B8 F0            CMPS   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B8 F0            CMPS   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[15,Y]  ; 8000   	11AC B8 0F            CMPS   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B8 0F            CMPS   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[-16,U]  ; 8000   	11AC D8 F0            CMPS   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D8 F0            CMPS   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[15,U]  ; 8000   	11AC D8 0F            CMPS   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D8 0F            CMPS   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[-16,S]  ; 8000   	11AC F8 F0            CMPS   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F8 F0            CMPS   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[15,S]  ; 8000   	11AC F8 0F            CMPS   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F8 0F            CMPS   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-128,X]  ; 8000   	11AC 98 80            CMPS   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 98 80            CMPS   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	   [127,X]  ; 8000   	11AC 98 7F            CMPS   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 98 7F            CMPS   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  		[-128,Y]  ; 8000   	11AC B8 80            CMPS   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B8 80            CMPS   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[127,Y]  ; 8000   	11AC B8 7F            CMPS   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B8 7F            CMPS   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-128,U]  ; 8000   	11AC D8 80            CMPS   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D8 80            CMPS   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[127,U]  ; 8000   	11AC D8 7F            CMPS   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D8 7F            CMPS   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-128,S]  ; 8000   	11AC F8 80            CMPS   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F8 80            CMPS   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[127,S]  ; 8000   	11AC F8 7F            CMPS   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F8 7F            CMPS   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32768,X]  ; 8000   	11AC 99 80 00             CMPS   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 99 80 00             CMPS   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32767,X]  ; 8000   	11AC 99 7F FF             CMPS   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 99 7F FF             CMPS   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32768,Y]  ; 8000   	11AC B9 80 00             CMPS   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B9 80 00             CMPS   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32767,Y]  ; 8000   	11AC B9 7F FF             CMPS   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B9 7F FF             CMPS   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32768,U]  ; 8000   	11AC D9 80 00             CMPS   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D9 80 00             CMPS   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32767,U]  ; 8000   	11AC D9 7F FF             CMPS   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D9 7F FF             CMPS   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32768,S]  ; 8000   	11AC F9 80 00             CMPS   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F9 80 00             CMPS   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32767,S]  ; 8000   	11AC F9 7F FF             CMPS   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F9 7F FF             CMPS   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32769,X]  ; 8000   	11AC 99 80 00             CMPS   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 99 80 00             CMPS   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32768,X]  ; 8000   	11AC 99 7F FF             CMPS   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 99 7F FF             CMPS   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32769,Y]  ; 8000   	11AC B9 80 00             CMPS   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B9 80 00             CMPS   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32768,Y]  ; 8000   	11AC B9 7F FF             CMPS   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC B9 7F FF             CMPS   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32769,U]  ; 8000   	11AC D9 80 00             CMPS   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D9 80 00             CMPS   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32768,U]  ; 8000   	11AC D9 7F FF             CMPS   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC D9 7F FF             CMPS   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32769,S]  ; 8000   	11AC F9 80 00             CMPS   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F9 80 00             CMPS   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPSIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  [32768,S]  ; 8000   	11AC F9 7F FF             CMPS   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC F9 7F FF             CMPS   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	0,PCR  ; 8000   	11AC 8C 00            CMPS   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8C 00            CMPS   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	-128,PCR  ; 8000   	11AC 8C 80            CMPS   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8C 80            CMPS   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	127,PCR  ; 8000   	11AC 8C 7F            CMPS   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8C 7F            CMPS   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	-129,PCR  ; 8000   	11AC 8D FF 7F            CMPS   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D FF 7F            CMPS   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	128,PCR  ; 8000   	11AC 8D 00 80            CMPS   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D 00 80            CMPS   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	-32768,PCR  ; 8000   	11AC 8D 80 00            CMPS   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D 80 00            CMPS   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	32767,PCR  ; 8000   	11AC 8D 7F FF            CMPS   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D 7F FF            CMPS   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	-32769,PCR  ; 8000   	11AC 8D 80 00            CMPS   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D 80 00            CMPS   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	32768,PCR  ; 8000   	11AC 8D 7F FF            CMPS   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 8D 7F FF            CMPS   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[0,PCR]  ; 8000   	11AC 9C 00            CMPS   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9C 00            CMPS   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-128,PCR]  ; 8000   	11AC 9C 80            CMPS   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9C 80            CMPS   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[127,PCR]  ; 8000   	11AC 9C 7F            CMPS   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9C 7F            CMPS   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-129,PCR]  ; 8000   	11AC 9D FF 7F            CMPS   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D FF 7F            CMPS   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[128,PCR]  ; 8000   	11AC 9D 00 80            CMPS   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D 00 80            CMPS   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32768,PCR]  ; 8000   	11AC 9D 80 00            CMPS   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D 80 00            CMPS   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[32767,PCR]  ; 8000   	11AC 9D 7F FF            CMPS   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D 7F FF            CMPS   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[-32769,PCR]  ; 8000   	11AC 9D 80 00            CMPS   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D 80 00            CMPS   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPSIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	CMPS		  	[32768,PCR]  ; 8000   	11AC 9D 7F FF            CMPS   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPSInstruction line = (AssembledCMPSInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x11, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	11AC 9D 7F FF            CMPS   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}