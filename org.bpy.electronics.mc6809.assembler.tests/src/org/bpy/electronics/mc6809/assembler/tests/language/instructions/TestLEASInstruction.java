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
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.junit.Test;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEASInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEASInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.eclipse.xtext.xbase.lib.Extension;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestLEASInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check LEAS extended indirect mode
	 */
	@Test
	public void testLEASExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LEAS		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Constant-Offset Indexed
	 */
	@Test
	public void testLEASConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LEAS		  	Const,X\n");
		strBuilder.append("			LEAS		  	,X\n");
		strBuilder.append("			LEAS		  	$9,U\n");
		strBuilder.append("			LEAS		  	$9,S\n");
		strBuilder.append("			LEAS		  	$9,X\n");
		strBuilder.append("			LEAS		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Constant-Offset Indexed indirect
	 */
	@Test
	public void testLEASConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LEAS		  	[Const,X]\n");
		strBuilder.append("			LEAS		  	[,X]\n");
		strBuilder.append("			LEAS		  	[$9,U]\n");
		strBuilder.append("			LEAS		  	[$9,S]\n");
		strBuilder.append("			LEAS		  	[$9,X]\n");
		strBuilder.append("			LEAS		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Accumulator Indexed
	 */
	@Test
	public void testLEASAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      LEAS		  	A,X\n");
		strBuilder.append("			LEAS		  	B,X\n");
		strBuilder.append("			LEAS		  	D,U\n");
		strBuilder.append("			LEAS		  	A,S\n");
		strBuilder.append("			LEAS		  	B,X\n");
		strBuilder.append("			LEAS		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Accumulator Indexed Indirect
	 */
	@Test
	public void testLEASAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	LEAS		  	[A,X]\n");
		strBuilder.append("			LEAS		  	[B,X]\n");
		strBuilder.append("			LEAS		  	[D,U]\n");
		strBuilder.append("			LEAS		  	[A,S]\n");
		strBuilder.append("			LEAS		  	[B,X]\n");
		strBuilder.append("			LEAS		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Auto-Increment Indexed
	 */
	@Test
	public void testLEASAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	LEAS		  	,--X\n");
		strBuilder.append("	       	LEAS		  	,-X\n");
		strBuilder.append("	       	LEAS		  	,X+\n");
		strBuilder.append("	       	LEAS		  	,X++\n");
		strBuilder.append("	       	LEAS		  	,--S\n");
		strBuilder.append("	       	LEAS		  	,-S\n");
		strBuilder.append("	       	LEAS		  	,U+\n");
		strBuilder.append("	       	LEAS		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Auto-Increment Indexed Indirect
	 */
	@Test
	public void testLEASAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	LEAS		  	[,--X]\n");
		strBuilder.append("	       	LEAS		  	[,X++]\n");
		strBuilder.append("	       	LEAS		  	[,--S]\n");
		strBuilder.append("	       	LEAS		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Relative to PC Indexed
	 */
	@Test
	public void testLEASRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	LEAS		  	0,PC\n");
		strBuilder.append("	       	LEAS		  	,PC\n");
		strBuilder.append("	       	LEAS		  	Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS Relative to PC Indexed Indirect
	 */
	@Test
	public void testLEASRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	LEAS		  	[0,PC]\n");
		strBuilder.append("	       	LEAS		  	[,PC]\n");
		strBuilder.append("	       	LEAS		  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof LeaInstruction);

			LeaInstruction adcInstruction = (LeaInstruction) instructionLine.getInstruction();
			assertEquals("Must be an LEAS instruction", adcInstruction.getInstruction(), "LEAS");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check LEAS instruction with duplicate label
	 */
	@Test
	public void testLEASWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	LEAS		  	#Const+2\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), InstructionValidator.DUPLICATE_LABEL,
					"Label Start is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS immediat mode instruction
	 */
	@Test
	public void testLEASImediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	#Const*2  ; 8000   0D 0A        START:    LEAS   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(), 
				InstructionValidator.ILLEGAL_MODE,
					"Immediate mode is not valid for the LEAS instruction");

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS direct mode instruction
	 */
	@Test
	public void testLEASDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  		<Const*2  ; 8000   0D 0A        START:    LEAS   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(), 
				InstructionValidator.ILLEGAL_MODE,
					"Direct mode is not valid for the LEAS instruction");

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended mode instruction
	 */
	@Test
	public void testLEASExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	>Const*1000  ; 8000   7D 13 88     START:    LEAS   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(), 
				InstructionValidator.ILLEGAL_MODE,
					"Extended mode is not valid for the LEAS instruction");

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended indirect mode instruction
	 */
	@Test
	public void testLEASExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[Const*1000]  ; 8000   68 9F 13 88  START:    LEAS   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 9F 13 88  START:    LEAS   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended indirect with limit negative operand
	 */
	@Test
	public void testLEASExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended indirect with limit negative operand
	 */
	@Test
	public void testLEASExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended indirect with positive limit operand
	 */
	@Test
	public void testLEASExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS extended indirect with positive limit operand
	 */
	@Test
	public void testLEASExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start       	LEAS		  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  		A,X  ; 8000   68 86        START:    LEAS   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 86        START:    LEAS   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	A,Y  ; 8000   	32 A6        START:    LEAS   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A6        START:    LEAS   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	A,U  ; 8000   	32 C6        START:    LEAS   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C6        START:    LEAS   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	A,S  ; 8000   	32 E6        START:    LEAS   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E6        START:    LEAS   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	B,X  ; 8000   68 85        START:    LEAS   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 85        START:    LEAS   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	B,Y  ; 8000   	32 A5        START:    LEAS   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A5        START:    LEAS   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	B,U  ; 8000   	32 C5        START:    LEAS   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C5        START:    LEAS   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	B,S  ; 8000   	32 E5        START:    LEAS   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E5        START:    LEAS   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	D,X  ; 8000   68 8B        START:    LEAS   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 8B        START:    LEAS   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	D,Y  ; 8000   	32 AB        START:    LEAS   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 AB        START:    LEAS   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	D,U  ; 8000   	32 CB        START:    LEAS   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 CB        START:    LEAS   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	D,S  ; 8000   	32 EB        START:    LEAS   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 EB        START:    LEAS   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[A,X]  ; 8000   68 96        START:    LEAS   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 96        START:    LEAS   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[A,Y]  ; 8000   	32 B6        START:    LEAS   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B6        START:    LEAS   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[A,U]  ; 8000   	32 D6        START:    LEAS   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D6        START:    LEAS   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[A,S]  ; 8000   	32 F6        START:    LEAS   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F6        START:    LEAS   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[B,X]  ; 8000   68 95        START:    LEAS   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 95        START:    LEAS   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[B,Y]  ; 8000   	32 B5        START:    LEAS   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B5        START:    LEAS   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[B,U]  ; 8000   	32 D5        START:    LEAS   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D5        START:    LEAS   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[B,S]  ; 8000   	32 F5        START:    LEAS   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F5        START:    LEAS   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[D,X]  ; 8000   68 9B        START:    LEAS   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 9B        START:    LEAS   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[D,Y]  ; 8000   	32 BB        START:    LEAS   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 BB        START:    LEAS   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[D,U]  ; 8000   	32 DB        START:    LEAS   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 DB        START:    LEAS   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testLEASIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[D,S]  ; 8000   	32 FB        START:    LEAS   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 FB        START:    LEAS   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,X+  ; 8000   	32 80        START:    LEAS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 80        START:    LEAS   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,X++  ; 8000   	32 81        START:    LEAS   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 81        START:    LEAS   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,Y+  ; 8000   	32 A0        START:    LEAS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A0        START:    LEAS   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,Y++  ; 8000   	32 A1        START:    LEAS   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A1        START:    LEAS   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,S+  ; 8000   	32 E0        START:    LEAS   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E0        START:    LEAS   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,S++  ; 8000   	32 E1        START:    LEAS   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E1        START:    LEAS   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,U+  ; 8000   	32 C0        START:    LEAS   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C0        START:    LEAS   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,U++  ; 8000   	32 C1        START:    LEAS   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C1        START:    LEAS   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,-X  ; 8000   	32 82        START:    LEAS   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 82        START:    LEAS   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,--X  ; 8000   	32 83        START:    LEAS   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 83        START:    LEAS   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,-Y  ; 8000   	32 A2        START:    LEAS   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A2        START:    LEAS   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,--Y  ; 8000   	32 A3        START:    LEAS   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A3        START:    LEAS   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,-S  ; 8000   	32 E2        START:    LEAS   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E2        START:    LEAS   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,--S  ; 8000   	32 E3        START:    LEAS   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E3        START:    LEAS   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,-U  ; 8000   	32 C2        START:    LEAS   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C2        START:    LEAS   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	,--U  ; 8000   	32 C3        START:    LEAS   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C3        START:    LEAS   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,X+]  ; 8000   	32 80        START:    LEAS   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,X++]  ; 8000   	32 91        START:    LEAS   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 91        START:    LEAS   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,Y+]  ; 8000   	32 A0        START:    LEAS   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,Y++]  ; 8000   	32 B1        START:    LEAS   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B1        START:    LEAS   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,S+]  ; 8000   	32 E0        START:    LEAS   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,S++]  ; 8000   	32 F1        START:    LEAS   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F1        START:    LEAS   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,U+]  ; 8000   	32 C0        START:    LEAS   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,U++]  ; 8000   	32 D1        START:    LEAS   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D1        START:    LEAS   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,-X]  ; 8000   	32 82        START:    LEAS   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,--X]  ; 8000   	32 93        START:    LEAS   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 93        START:    LEAS   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  		[,-Y]  ; 8000   	32 A2        START:    LEAS   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,--Y]  ; 8000   	32 B3        START:    LEAS   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B3        START:    LEAS   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,-S]  ; 8000   	32 E2        START:    LEAS   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,--S]  ; 8000   	32 F3        START:    LEAS   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F3        START:    LEAS   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,-U]  ; 8000   	32 C2        START:    LEAS   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testLEASIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	LEAS		  	[,--U]  ; 8000   	32 D3        START:    LEAS   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D3        START:    LEAS   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1234,X  ; 8000   	32 89 04 D2            LEAS   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 89 04 D2            LEAS   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1234,Y  ; 8000   	67 A9 04 D2            LEAS   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 04 D2            LEAS   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1234,U  ; 8000   	32 C9 04 D2            LEAS   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C9 04 D2            LEAS   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1234,S  ; 8000   	32 E9 04 D2            LEAS   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E9 04 D2            LEAS   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	34,X  ; 8000   	32 88 22            LEAS   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 88 22            LEAS   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	34,Y  ; 8000   	32 A8 22            LEAS   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A8 22            LEAS   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	34,U  ; 8000   	32 C8 22            LEAS   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C8 22            LEAS   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	34,S  ; 8000   	32 E8 22            LEAS   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E8 22            LEAS   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	,X  ; 8000   	32 84            LEAS   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 84            LEAS   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	,Y  ; 8000   	32 A4            LEAS   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A4            LEAS   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	,U  ; 8000   	32 C4            LEAS   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C4            LEAS   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	,S  ; 8000   	32 E4            LEAS   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E4            LEAS   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	0,X  ; 8000   	32 84            LEAS   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 84            LEAS   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	0,Y  ; 8000   	32 A4            LEAS   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A4            LEAS   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	0,U  ; 8000   	32 C4            LEAS   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C4            LEAS   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	0,S  ; 8000   	32 E4            LEAS   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E4            LEAS   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-16,X  ; 8000   	32 10            LEAS   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 10            LEAS   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1,X  ; 8000   	32 01            LEAS   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 01            LEAS   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	15,X  ; 8000   	32 0F            LEAS   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 0F            LEAS   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-16,Y  ; 8000   	32 30            LEAS   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 30            LEAS   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1,Y  ; 8000   	32 21            LEAS   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 21            LEAS   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	15,Y  ; 8000   	32 2F            LEAS   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 2F            LEAS   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-16,U  ; 8000   	32 50            LEAS   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 50            LEAS   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1,U  ; 8000   	32 41            LEAS   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 41            LEAS   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	15,U  ; 8000   	32 4F            LEAS   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 4F            LEAS   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-16,S  ; 8000   	32 70            LEAS   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 70            LEAS   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	1,S  ; 8000   	32 61            LEAS   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 61            LEAS   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	15,S  ; 8000   	32 6F            LEAS   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 6F            LEAS   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-128,X  ; 8000   	32 88 80            LEAS   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 88 80            LEAS   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	127,X  ; 8000   	32 88 7F            LEAS   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 88 7F            LEAS   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-128,Y  ; 8000   	32 A8 80            LEAS   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A8 80            LEAS   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	127,Y  ; 8000   	32 A8 7F            LEAS   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 A8 7F            LEAS   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-128,U  ; 8000   	32 C8 80            LEAS   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C8 80            LEAS   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	127,U  ; 8000   	32 C8 7F            LEAS   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C8 7F            LEAS   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-128,S  ; 8000   	32 E8 80            LEAS   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E8 80            LEAS   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	127,S  ; 8000   	32 E8 7F            LEAS   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E8 7F            LEAS   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32768,X  ; 8000   	32 89 80 00             LEAS   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 89 80 00             LEAS   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32767,X  ; 8000   	32 89 7F FF             LEAS   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 89 7F FF             LEAS   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32768,Y  ; 8000   	67 A9 80 00             LEAS   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 80 00             LEAS   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32767,Y  ; 8000   	67 A9 7F FF             LEAS   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 7F FF             LEAS   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32768,U  ; 8000   	32 C9 80 00             LEAS   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C9 80 00             LEAS   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32767,U  ; 8000   	32 C9 7F FF             LEAS   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C9 7F FF             LEAS   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32768,S  ; 8000   	32 E9 80 00             LEAS   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E9 80 00             LEAS   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32767,S  ; 8000   	32 E9 7F FF             LEAS   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E9 7F FF             LEAS   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32769,X  ; 8000   	32 89 80 00             LEAS   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 89 80 00             LEAS   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32768,X  ; 8000   	32 89 7F FF             LEAS   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 89 7F FF             LEAS   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32769,Y  ; 8000   	67 A9 80 00             LEAS   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 80 00             LEAS   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32768,Y  ; 8000   	67 A9 7F FF             LEAS   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 7F FF             LEAS   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32769,U  ; 8000   	32 C9 80 00             LEAS   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C9 80 00             LEAS   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32768,U  ; 8000   	32 C9 7F FF             LEAS   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 C9 7F FF             LEAS   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32769,S  ; 8000   	32 E9 80 00             LEAS   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E9 80 00             LEAS   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  32768,S  ; 8000   	32 E9 7F FF             LEAS   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 E9 7F FF             LEAS   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[1234,X]  ; 8000   	32 99 04 D2            LEAS   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 99 04 D2            LEAS   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[1234,Y]  ; 8000   	32 B9 04 D2            LEAS   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B9 04 D2            LEAS   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[1234,U]  ; 8000   	32 D9 04 D2            LEAS   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D9 04 D2            LEAS   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[1234,S]  ; 8000   	32 F9 04 D2            LEAS   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F9 04 D2            LEAS   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[34,X]  ; 8000   	32 98 22            LEAS   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 98 22            LEAS   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[34,Y]  ; 8000   	32 B8 22            LEAS   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B8 22            LEAS   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[34,U]  ; 8000   	32 D8 22            LEAS   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D8 22            LEAS   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[34,S]  ; 8000   	32 F8 22            LEAS   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F8 22            LEAS   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[,X]  ; 8000   	32 94            LEAS   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 94            LEAS   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[,Y]  ; 8000   	32 B4            LEAS   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B4            LEAS   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[,U]  ; 8000   	32 D4            LEAS   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D4            LEAS   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[,S]  ; 8000   	32 F4            LEAS   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F4            LEAS   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[0,X]  ; 8000   	32 94            LEAS   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 94            LEAS   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[0,Y]  ; 8000   	32 B4            LEAS   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B4            LEAS   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[0,U]  ; 8000   	32 D4            LEAS   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D4            LEAS   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[0,S]  ; 8000   	32 F4            LEAS   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F4            LEAS   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-16,X]  ; 8000   	32 98 F0            LEAS   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 98 F0            LEAS   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[15,X]  ; 8000   	32 98 0F            LEAS   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 98 0F            LEAS   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-16,Y]  ; 8000   	32 B8 F0            LEAS   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B8 F0            LEAS   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[15,Y]  ; 8000   	32 B8 0F            LEAS   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B8 0F            LEAS   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-16,U]  ; 8000   	32 D8 F0            LEAS   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D8 F0            LEAS   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[15,U]  ; 8000   	32 D8 0F            LEAS   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D8 0F            LEAS   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-16,S]  ; 8000   	32 F8 F0            LEAS   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F8 F0            LEAS   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[15,S]  ; 8000   	32 F8 0F            LEAS   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F8 0F            LEAS   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-128,X]  ; 8000   	32 98 80            LEAS   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 98 80            LEAS   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[127,X]  ; 8000   	32 98 7F            LEAS   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 98 7F            LEAS   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-128,Y]  ; 8000   	32 B8 80            LEAS   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B8 80            LEAS   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[127,Y]  ; 8000   	32 B8 7F            LEAS   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B8 7F            LEAS   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-128,U]  ; 8000   	32 D8 80            LEAS   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D8 80            LEAS   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[127,U]  ; 8000   	32 D8 7F            LEAS   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D8 7F            LEAS   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-128,S]  ; 8000   	32 F8 80            LEAS   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F8 80            LEAS   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[127,S]  ; 8000   	32 F8 7F            LEAS   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F8 7F            LEAS   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768,X]  ; 8000   	32 99 80 00             LEAS   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 99 80 00             LEAS   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32767,X]  ; 8000   	32 99 7F FF             LEAS   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 99 7F FF             LEAS   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768,Y]  ; 8000   	32 B9 80 00             LEAS   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B9 80 00             LEAS   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32767,Y]  ; 8000   	32 B9 7F FF             LEAS   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B9 7F FF             LEAS   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768,U]  ; 8000   	32 D9 80 00             LEAS   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D9 80 00             LEAS   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32767,U]  ; 8000   	32 D9 7F FF             LEAS   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D9 7F FF             LEAS   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768,S]  ; 8000   	32 F9 80 00             LEAS   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F9 80 00             LEAS   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32767,S]  ; 8000   	32 F9 7F FF             LEAS   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F9 7F FF             LEAS   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769,X]  ; 8000   	32 99 80 00             LEAS   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 99 80 00             LEAS   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32768,X]  ; 8000   	32 99 7F FF             LEAS   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 99 7F FF             LEAS   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769,Y]  ; 8000   	32 B9 80 00             LEAS   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B9 80 00             LEAS   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32768,Y]  ; 8000   	32 B9 7F FF             LEAS   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 B9 7F FF             LEAS   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769,U]  ; 8000   	32 D9 80 00             LEAS   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D9 80 00             LEAS   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32768,U]  ; 8000   	32 D9 7F FF             LEAS   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 D9 7F FF             LEAS   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769,S]  ; 8000   	32 F9 80 00             LEAS   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F9 80 00             LEAS   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testLEASIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  [32768,S]  ; 8000   	32 F9 7F FF             LEAS   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 F9 7F FF             LEAS   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	0,PCR  ; 8000   	32 8C 00            LEAS   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8C 00            LEAS   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-128,PCR  ; 8000   	32 8C 80            LEAS   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8C 80            LEAS   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	127,PCR  ; 8000   	32 8C 7F            LEAS   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8C 7F            LEAS   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-129,PCR  ; 8000   	32 8D FF 7F            LEAS   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D FF 7F            LEAS   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	128,PCR  ; 8000   	32 8D 00 80            LEAS   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D 00 80            LEAS   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32768,PCR  ; 8000   	32 8D 80 00            LEAS   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D 80 00            LEAS   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	32767,PCR  ; 8000   	32 8D 7F FF            LEAS   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D 7F FF            LEAS   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	-32769,PCR  ; 8000   	32 8D 80 00            LEAS   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D 80 00            LEAS   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	32768,PCR  ; 8000   	32 8D 7F FF            LEAS   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 8D 7F FF            LEAS   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[0,PCR]  ; 8000   	32 9C 00            LEAS   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9C 00            LEAS   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-128,PCR]  ; 8000   	32 9C 80            LEAS   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9C 80            LEAS   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[127,PCR]  ; 8000   	32 9C 7F            LEAS   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9C 7F            LEAS   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-129,PCR]  ; 8000   	32 9D FF 7F            LEAS   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D FF 7F            LEAS   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[128,PCR]  ; 8000   	32 9D 00 80            LEAS   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D 00 80            LEAS   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32768,PCR]  ; 8000   	32 9D 80 00            LEAS   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D 80 00            LEAS   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[32767,PCR]  ; 8000   	32 9D 7F FF            LEAS   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D 7F FF            LEAS   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[-32769,PCR]  ; 8000   	32 9D 80 00            LEAS   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D 80 00            LEAS   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled LEAS Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testLEASIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	LEAS		  	[32768,PCR]  ; 8000   	32 9D 7F FF            LEAS   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getLeaInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledLEASInstruction line = (AssembledLEASInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x32, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	32 9D 7F FF            LEAS   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}