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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPYInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestCMPYInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	/**
	 * Check CMPY immediat
	 */
	@Test
	public void testCMPYImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			CMPY			#124\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY direct mode
	 */
	@Test
	public void testCMPYDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPY		  	<124\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY extended mode
	 */
	@Test
	public void testCMPYExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPY		  	$1234\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY extended mode
	 */
	@Test
	public void testCMPYExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPY		  	>$1234\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY extended indirect mode
	 */
	@Test
	public void testCMPYExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CMPY		  	[$1234]\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Constant-Offset Indexed
	 */
	@Test
	public void testCMPYConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPY		  	Const,X\n");
		strBuilder.append("			CMPY		  	,X\n");
		strBuilder.append("			CMPY		  	$9,U\n");
		strBuilder.append("			CMPY		  	$9,S\n");
		strBuilder.append("			CMPY		  	$9,X\n");
		strBuilder.append("			CMPY		  	$9,Y\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Constant-Offset Indexed indirect
	 */
	@Test
	public void testCMPYConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPY		  	[Const,X]\n");
		strBuilder.append("			CMPY		  	[,X]\n");
		strBuilder.append("			CMPY		  	[$9,U]\n");
		strBuilder.append("			CMPY		  	[$9,S]\n");
		strBuilder.append("			CMPY		  	[$9,X]\n");
		strBuilder.append("			CMPY		  	[$9,Y]\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Accumulator Indexed
	 */
	@Test
	public void testCMPYAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      CMPY		  	A,X\n");
		strBuilder.append("			CMPY		  	B,X\n");
		strBuilder.append("			CMPY		  	D,U\n");
		strBuilder.append("			CMPY		  	A,S\n");
		strBuilder.append("			CMPY		  	B,X\n");
		strBuilder.append("			CMPY		  	D,Y\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Accumulator Indexed Indirect
	 */
	@Test
	public void testCMPYAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPY			  	[A,X]\n");
		strBuilder.append("				CMPY		 	 	[B,X]\n");
		strBuilder.append("				CMPY		  		[D,U]\n");
		strBuilder.append("				CMPY		  		[A,S]\n");
		strBuilder.append("				CMPY		  		[B,X]\n");
		strBuilder.append("				CMPY		  		[D,Y]\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Auto-Increment Indexed
	 */
	@Test
	public void testCMPYAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPY			  	,--X\n");
		strBuilder.append("	       	CMPY			  	,-X\n");
		strBuilder.append("	       	CMPY			  	,X+\n");
		strBuilder.append("	       	CMPY		  		,X++\n");
		strBuilder.append("	       	CMPY			  	,--S\n");
		strBuilder.append("	       	CMPY			  	,-S\n");
		strBuilder.append("	       	CMPY			  	,U+\n");
		strBuilder.append("	       	CMPY		  		,U++\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Auto-Increment Indexed Indirect
	 */
	@Test
	public void testCMPYAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPY			  	[,--X]\n");
		strBuilder.append("	       	CMPY			  	[,X++]\n");
		strBuilder.append("	       	CMPY			  	[,--S]\n");
		strBuilder.append("	       	CMPY		  		[,U++]\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Relative to PC Indexed
	 */
	@Test
	public void testCMPYRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPY			  	0,PC\n");
		strBuilder.append("	       	CMPY			  	,PC\n");
		strBuilder.append("	       	CMPY		  		Const,PC\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY Relative to PC Indexed Indirect
	 */
	@Test
	public void testCMPYRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const		EQU          	5    \n");
		strBuilder.append("	       	CMPY			  	[0,PC]\n");
		strBuilder.append("	       	CMPY			  	[,PC]\n");
		strBuilder.append("	       	CMPY			  	[Const,PC]\n");
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
			assertEquals("Must be an CMPY instruction", adcInstruction.getInstruction(), "CMPY");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check CMPY instruction with duplicate label
	 */
	@Test
	public void testCMPYWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	CMPY		  	#Const+2\n");
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
	 * Check Assembled CMPY immediate instruction
	 */
	@Test
	public void testCMPYImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG   		$8000\n");
		strBuilder.append("Const	   	EQU       	5\n");
		strBuilder.append("Start      	CMPY		  	#Const+2  ; 8000   108C 00 07        START:    CMPY\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x8C, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   108C 00 07        START:    CMPY", line.getComment());
			;
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY immediate with limit negative operand
	 */
	@Test
	public void testCMPYImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	#-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY immediate with limit negative operand
	 */
	@Test
	public void testCMPYImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		#-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY immediate with positive limit operand
	 */
	@Test
	public void testCMPYImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	#127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY immediate with positive limit operand
	 */
	@Test
	public void testCMPYImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	#65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY immediate with positive limit operand
	 */
	@Test
	public void testCMPYImmediatInstruction6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	#65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY direct mode instruction
	 */
	@Test
	public void testCMPYDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		<Const*2  ; 8000   109C 0A        START:    CMPY   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9C, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   109C 0A        START:    CMPY   <Const*2 ", line.getComment());
			;

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY direct with limit negative operand
	 */
	@Test
	public void testCMPYDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY direct with limit negative operand
	 */
	@Test
	public void testCMPYDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY direct with positive limit operand
	 */
	@Test
	public void testCMPYDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY direct with positive limit operand
	 */
	@Test
	public void testCMPYDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended mode instruction
	 */
	@Test
	public void testCMPYExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		>Const*1000  ; 8000   10BC 13 88     START:    CMPY   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xBC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   10BC 13 88     START:    CMPY   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended with limit negative operand
	 */
	@Test
	public void testCMPYExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended with limit negative operand
	 */
	@Test
	public void testCMPYExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended with positive limit operand
	 */
	@Test
	public void testCMPYExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended with positive limit operand
	 */
	@Test
	public void testCMPYExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended indirect mode instruction
	 */
	@Test
	public void testCMPYExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[Const*1000]  ; 8000   10A3 9F 13 88  START:    CMPY   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 3, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[2]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   10A3 9F 13 88  START:    CMPY   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended indirect with limit negative operand
	 */
	@Test
	public void testCMPYExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended indirect with limit negative operand
	 */
	@Test
	public void testCMPYExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended indirect with positive limit operand
	 */
	@Test
	public void testCMPYExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY extended indirect with positive limit operand
	 */
	@Test
	public void testCMPYExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG    			$8000\n");
		strBuilder.append("Start       	CMPY			  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		A,X  ; 8000   AB 86        START:    CMPY   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    CMPY   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		A,Y  ; 8000   	10AC A6        START:    CMPY   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A6        START:    CMPY   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		A,U  ; 8000   	10AC C6        START:    CMPY   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C6        START:    CMPY   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		A,S  ; 8000   	10AC E6        START:    CMPY   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E6        START:    CMPY   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		B,X  ; 8000   AB 85        START:    CMPY   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPY   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		B,Y  ; 8000   	10AC A5        START:    CMPY   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A5        START:    CMPY   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		B,U  ; 8000   	10AC C5        START:    CMPY   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C5        START:    CMPY   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		B,S  ; 8000   	10AC E5        START:    CMPY   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E5        START:    CMPY   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	D,X  ; 8000   AB 8B        START:    CMPY   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPY   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		 	 	D,Y  ; 8000   	10AC AB        START:    CMPY   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC AB        START:    CMPY   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	D,U  ; 8000   	10AC CB        START:    CMPY   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC CB        START:    CMPY   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	D,S  ; 8000   	10AC EB        START:    CMPY   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC EB        START:    CMPY   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[A,X]  ; 8000   AB 96        START:    CMPY   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPY   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[A,Y]  ; 8000   	10AC B6        START:    CMPY   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B6        START:    CMPY   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		 	 	[A,U]  ; 8000   	10AC D6        START:    CMPY   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D6        START:    CMPY   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[A,S]  ; 8000   	10AC F6        START:    CMPY   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F6        START:    CMPY   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[B,X]  ; 8000   AB 95        START:    CMPY   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPY   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[B,Y]  ; 8000   	10AC B5        START:    CMPY   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B5        START:    CMPY   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		 	 	[B,U]  ; 8000   	10AC D5        START:    CMPY   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D5        START:    CMPY   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[B,S]  ; 8000   	10AC F5        START:    CMPY   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F5        START:    CMPY   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		 	 	[D,X]  ; 8000   AB 9B        START:    CMPY   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPY   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[D,Y]  ; 8000   	10AC BB        START:    CMPY   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC BB        START:    CMPY   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[D,U]  ; 8000   	10AC DB        START:    CMPY   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC DB        START:    CMPY   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testCMPYIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[D,S]  ; 8000   	10AC FB        START:    CMPY   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC FB        START:    CMPY   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,X+  ; 8000   	10AC 80        START:    CMPY   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 80        START:    CMPY   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,X++  ; 8000   	10AC 81        START:    CMPY   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 81        START:    CMPY   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,Y+  ; 8000   	10AC A0        START:    CMPY   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A0        START:    CMPY   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,Y++  ; 8000   	10AC A1        START:    CMPY   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A1        START:    CMPY   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,S+  ; 8000   	10AC E0        START:    CMPY   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E0        START:    CMPY   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,S++  ; 8000   	10AC E1        START:    CMPY   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E1        START:    CMPY   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,U+  ; 8000   	10AC C0        START:    CMPY   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C0        START:    CMPY   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,U++  ; 8000   	10AC C1        START:    CMPY   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C1        START:    CMPY   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,-X  ; 8000   	10AC 82        START:    CMPY   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 82        START:    CMPY   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,--X  ; 8000   	10AC 83        START:    CMPY   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 83        START:    CMPY   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	,-Y  ; 8000   	10AC A2        START:    CMPY   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A2        START:    CMPY   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,--Y  ; 8000   	10AC A3        START:    CMPY   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A3        START:    CMPY   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,-S  ; 8000   	10AC E2        START:    CMPY   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E2        START:    CMPY   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,--S  ; 8000   	10AC E3        START:    CMPY   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E3        START:    CMPY   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,-U  ; 8000   	10AC C2        START:    CMPY   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C2        START:    CMPY   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		,--U  ; 8000   	10AC C3        START:    CMPY   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C3        START:    CMPY   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY			  	[,X+]  ; 8000   	10AC 80        START:    CMPY   ,X+\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,X++]  ; 8000   	10AC 91        START:    CMPY   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 91        START:    CMPY   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,Y+]  ; 8000   	10AC A0        START:    CMPY   ,Y+\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,Y++]  ; 8000   	10AC B1        START:    CMPY   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B1        START:    CMPY   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Const	   	EQU         5\n");
		strBuilder.append("Start      	CMPY		  	[,S+]  ; 8000   	10AC E0        START:    CMPY   [,S+]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,S++]  ; 8000   	10AC F1        START:    CMPY   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F1        START:    CMPY   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,U+]  ; 8000   	10AC C0        START:    CMPY   [,U+]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,U++]  ; 8000   	10AC D1        START:    CMPY   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D1        START:    CMPY   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,-X]  ; 8000   	10AC 82        START:    CMPY   [,-X]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,--X]  ; 8000   	10AC 93        START:    CMPY   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 93        START:    CMPY   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,-Y]  ; 8000   	10AC A2        START:    CMPY   [,-Y]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,--Y]  ; 8000   	10AC B3        START:    CMPY   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B3        START:    CMPY   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,-S]  ; 8000   	10AC E2        START:    CMPY   [,-S]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,--S]  ; 8000   	10AC F3        START:    CMPY   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F3        START:    CMPY   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,-U]  ; 8000   	10AC C2        START:    CMPY   [,-U]\n");
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
	 * Check Assembled CMPY Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testCMPYIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CMPY		  		[,--U]  ; 8000   	10AC D3        START:    CMPY   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D3        START:    CMPY   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	1234,X  ; 8000   	10AC 89 04 D2            CMPY   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 89 04 D2            CMPY   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		1234,Y  ; 8000   	AB A9 04 D2            CMPY   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 04 D2            CMPY   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		1234,U  ; 8000   	10AC C9 04 D2            CMPY   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C9 04 D2            CMPY   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		1234,S  ; 8000   	10AC E9 04 D2            CMPY   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E9 04 D2            CMPY   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		34,X  ; 8000   	10AC 88 22            CMPY   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 88 22            CMPY   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		34,Y  ; 8000   	10AC A8 22            CMPY   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A8 22            CMPY   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	34,U  ; 8000   	10AC C8 22            CMPY   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C8 22            CMPY   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	34,S  ; 8000   	10AC E8 22            CMPY   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E8 22            CMPY   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	,X  ; 8000   	10AC 84            CMPY   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 84            CMPY   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	,Y  ; 8000   	10AC A4            CMPY   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A4            CMPY   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		,U  ; 8000   	10AC C4            CMPY   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C4            CMPY   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	,S  ; 8000   	10AC E4            CMPY   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E4            CMPY   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	0,X  ; 8000   	10AC 84            CMPY   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 84            CMPY   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	0,Y  ; 8000   	10AC A4            CMPY   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A4            CMPY   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	0,U  ; 8000   	10AC C4            CMPY   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C4            CMPY   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	0,S  ; 8000   	10AC E4            CMPY   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E4            CMPY   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-16,X  ; 8000   	10AC 10            CMPY   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 10            CMPY   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	1,X  ; 8000   	10AC 01            CMPY   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 01            CMPY   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	15,X  ; 8000   	10AC 0F            CMPY   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 0F            CMPY   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-16,Y  ; 8000   	10AC 30            CMPY   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 30            CMPY   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	1,Y  ; 8000   	10AC 21            CMPY   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 21            CMPY   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	15,Y  ; 8000   	10AC 2F            CMPY   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 2F            CMPY   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-16,U  ; 8000   	10AC 50            CMPY   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 50            CMPY   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	1,U  ; 8000   	10AC 41            CMPY   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 41            CMPY   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	15,U  ; 8000   	10AC 4F            CMPY   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 4F            CMPY   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-16,S  ; 8000   	10AC 70            CMPY   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 70            CMPY   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		1,S  ; 8000   	10AC 61            CMPY   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 61            CMPY   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		15,S  ; 8000   	10AC 6F            CMPY   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 6F            CMPY   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	   -128,X  ; 8000   	10AC 88 80            CMPY   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 88 80            CMPY   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	127,X  ; 8000   	10AC 88 7F            CMPY   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 88 7F            CMPY   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-128,Y  ; 8000   	10AC A8 80            CMPY   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A8 80            CMPY   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	127,Y  ; 8000   	10AC A8 7F            CMPY   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC A8 7F            CMPY   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-128,U  ; 8000   	10AC C8 80            CMPY   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C8 80            CMPY   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG   		$8000\n");
		strBuilder.append("Start      	CMPY		  	127,U  ; 8000   	10AC C8 7F            CMPY   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C8 7F            CMPY   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-128,S  ; 8000   	10AC E8 80            CMPY   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E8 80            CMPY   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	127,S  ; 8000   	10AC E8 7F            CMPY   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E8 7F            CMPY   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		-32768,X  ; 8000   	10AC 89 80 00             CMPY   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 89 80 00             CMPY   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	CMPY		  32767,X  ; 8000   	10AC 89 7F FF             CMPY   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 89 7F FF             CMPY   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-32768,Y  ; 8000   	AB A9 80 00             CMPY   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPY   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		32767,Y  ; 8000   	AB A9 7F FF             CMPY   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPY   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	   -32768,U  ; 8000   	10AC C9 80 00             CMPY   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C9 80 00             CMPY   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	CMPY		32767,U  ; 8000   	10AC C9 7F FF             CMPY   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C9 7F FF             CMPY   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	-32768,S  ; 8000   	10AC E9 80 00             CMPY   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E9 80 00             CMPY   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	  $8000\n");
		strBuilder.append("Start      	CMPY		  32767,S  ; 8000   	10AC E9 7F FF             CMPY   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E9 7F FF             CMPY   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	CMPY		  	-32769,X  ; 8000   	10AC 89 80 00             CMPY   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 89 80 00             CMPY   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    	$8000\n");
		strBuilder.append("Start      	CMPY		32768,X  ; 8000   	10AC 89 7F FF             CMPY   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 89 7F FF             CMPY   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		-32769,Y  ; 8000   	AB A9 80 00             CMPY   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             CMPY   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 		ORG    		$8000\n");
		strBuilder.append("Start      	CMPY	  	  	32768,Y  ; 8000   	AB A9 7F FF             CMPY   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             CMPY   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	-32769,U  ; 8000   	10AC C9 80 00             CMPY   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C9 80 00             CMPY   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		32768,U  ; 8000   	10AC C9 7F FF             CMPY   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC C9 7F FF             CMPY   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		-32769,S  ; 8000   	10AC E9 80 00             CMPY   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E9 80 00             CMPY   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		32768,S  ; 8000   	10AC E9 7F FF             CMPY   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC E9 7F FF             CMPY   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[1234,X]  ; 8000   	10AC 99 04 D2            CMPY   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 99 04 D2            CMPY   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[1234,Y]  ; 8000   	10AC B9 04 D2            CMPY   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B9 04 D2            CMPY   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[1234,U]  ; 8000   	10AC D9 04 D2            CMPY   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D9 04 D2            CMPY   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[1234,S]  ; 8000   	10AC F9 04 D2            CMPY   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F9 04 D2            CMPY   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[34,X]  ; 8000   	10AC 98 22            CMPY   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 98 22            CMPY   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[34,Y]  ; 8000   	10AC B8 22            CMPY   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B8 22            CMPY   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[34,U]  ; 8000   	10AC D8 22            CMPY   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D8 22            CMPY   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[34,S]  ; 8000   	10AC F8 22            CMPY   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F8 22            CMPY   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[,X]  ; 8000   	10AC 94            CMPY   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 94            CMPY   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	 	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY			  	[,Y]  ; 8000   	10AC B4            CMPY   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B4            CMPY   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[,U]  ; 8000   	10AC D4            CMPY   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D4            CMPY   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[,S]  ; 8000   	10AC F4            CMPY   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F4            CMPY   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[0,X]  ; 8000   	10AC 94            CMPY   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 94            CMPY   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[0,Y]  ; 8000   	10AC B4            CMPY   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B4            CMPY   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[0,U]  ; 8000   	10AC D4            CMPY   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D4            CMPY   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[0,S]  ; 8000   	10AC F4            CMPY   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F4            CMPY   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[-16,X]  ; 8000   	10AC 98 F0            CMPY   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 98 F0            CMPY   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[15,X]  ; 8000   	10AC 98 0F            CMPY   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 98 0F            CMPY   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[-16,Y]  ; 8000   	10AC B8 F0            CMPY   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B8 F0            CMPY   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[15,Y]  ; 8000   	10AC B8 0F            CMPY   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B8 0F            CMPY   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[-16,U]  ; 8000   	10AC D8 F0            CMPY   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D8 F0            CMPY   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[15,U]  ; 8000   	10AC D8 0F            CMPY   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D8 0F            CMPY   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[-16,S]  ; 8000   	10AC F8 F0            CMPY   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F8 F0            CMPY   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[15,S]  ; 8000   	10AC F8 0F            CMPY   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F8 0F            CMPY   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-128,X]  ; 8000   	10AC 98 80            CMPY   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 98 80            CMPY   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	   [127,X]  ; 8000   	10AC 98 7F            CMPY   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 98 7F            CMPY   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  		[-128,Y]  ; 8000   	10AC B8 80            CMPY   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B8 80            CMPY   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[127,Y]  ; 8000   	10AC B8 7F            CMPY   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B8 7F            CMPY   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-128,U]  ; 8000   	10AC D8 80            CMPY   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D8 80            CMPY   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[127,U]  ; 8000   	10AC D8 7F            CMPY   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D8 7F            CMPY   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-128,S]  ; 8000   	10AC F8 80            CMPY   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F8 80            CMPY   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[127,S]  ; 8000   	10AC F8 7F            CMPY   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F8 7F            CMPY   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32768,X]  ; 8000   	10AC 99 80 00             CMPY   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 99 80 00             CMPY   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32767,X]  ; 8000   	10AC 99 7F FF             CMPY   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 99 7F FF             CMPY   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32768,Y]  ; 8000   	10AC B9 80 00             CMPY   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B9 80 00             CMPY   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32767,Y]  ; 8000   	10AC B9 7F FF             CMPY   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B9 7F FF             CMPY   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32768,U]  ; 8000   	10AC D9 80 00             CMPY   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D9 80 00             CMPY   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32767,U]  ; 8000   	10AC D9 7F FF             CMPY   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D9 7F FF             CMPY   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32768,S]  ; 8000   	10AC F9 80 00             CMPY   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F9 80 00             CMPY   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32767,S]  ; 8000   	10AC F9 7F FF             CMPY   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F9 7F FF             CMPY   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32769,X]  ; 8000   	10AC 99 80 00             CMPY   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 99 80 00             CMPY   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32768,X]  ; 8000   	10AC 99 7F FF             CMPY   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 99 7F FF             CMPY   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32769,Y]  ; 8000   	10AC B9 80 00             CMPY   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B9 80 00             CMPY   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32768,Y]  ; 8000   	10AC B9 7F FF             CMPY   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC B9 7F FF             CMPY   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32769,U]  ; 8000   	10AC D9 80 00             CMPY   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D9 80 00             CMPY   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32768,U]  ; 8000   	10AC D9 7F FF             CMPY   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC D9 7F FF             CMPY   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32769,S]  ; 8000   	10AC F9 80 00             CMPY   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F9 80 00             CMPY   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testCMPYIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  [32768,S]  ; 8000   	10AC F9 7F FF             CMPY   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC F9 7F FF             CMPY   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	0,PCR  ; 8000   	10AC 8C 00            CMPY   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8C 00            CMPY   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	-128,PCR  ; 8000   	10AC 8C 80            CMPY   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8C 80            CMPY   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	127,PCR  ; 8000   	10AC 8C 7F            CMPY   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8C 7F            CMPY   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	-129,PCR  ; 8000   	10AC 8D FF 7F            CMPY   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D FF 7F            CMPY   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	128,PCR  ; 8000   	10AC 8D 00 80            CMPY   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D 00 80            CMPY   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	-32768,PCR  ; 8000   	10AC 8D 80 00            CMPY   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D 80 00            CMPY   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	32767,PCR  ; 8000   	10AC 8D 7F FF            CMPY   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D 7F FF            CMPY   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	-32769,PCR  ; 8000   	10AC 8D 80 00            CMPY   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D 80 00            CMPY   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	32768,PCR  ; 8000   	10AC 8D 7F FF            CMPY   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 8D 7F FF            CMPY   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[0,PCR]  ; 8000   	10AC 9C 00            CMPY   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9C 00            CMPY   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-128,PCR]  ; 8000   	10AC 9C 80            CMPY   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9C 80            CMPY   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[127,PCR]  ; 8000   	10AC 9C 7F            CMPY   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9C 7F            CMPY   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-129,PCR]  ; 8000   	10AC 9D FF 7F            CMPY   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D FF 7F            CMPY   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[128,PCR]  ; 8000   	10AC 9D 00 80            CMPY   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D 00 80            CMPY   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32768,PCR]  ; 8000   	10AC 9D 80 00            CMPY   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D 80 00            CMPY   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[32767,PCR]  ; 8000   	10AC 9D 7F FF            CMPY   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D 7F FF            CMPY   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[-32769,PCR]  ; 8000   	10AC 9D 80 00            CMPY   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D 80 00            CMPY   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled CMPY Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testCMPYIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	CMPY		  	[32768,PCR]  ; 8000   	10AC 9D 7F FF            CMPY   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getCmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8005, engine.getCurrentPcValue());

			AssembledCMPYInstruction line = (AssembledCMPYInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0xAC, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	10AC 9D 7F FF            CMPY   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}