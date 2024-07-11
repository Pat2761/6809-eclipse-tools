/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIBIT
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
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
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
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEORAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
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

public class TestEORAInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	/**
	 * Check EORA immediat
	 */
	@Test
	public void testEORAImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			EORA		#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA direct mode
	 */
	@Test
	public void testEORADirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       EORA		  	<124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA extended mode
	 */
	@Test
	public void testEORAExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       EORA		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA extended mode
	 */
	@Test
	public void testEORAExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       EORA		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA extended indirect mode
	 */
	@Test
	public void testEORAExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       EORA		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Constant-Offset Indexed
	 */
	@Test
	public void testEORAConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      EORA		  	Const,X\n");
		strBuilder.append("			EORA		  	,X\n");
		strBuilder.append("			EORA		  	$9,U\n");
		strBuilder.append("			EORA		  	$9,S\n");
		strBuilder.append("			EORA		  	$9,X\n");
		strBuilder.append("			EORA		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Constant-Offset Indexed indirect
	 */
	@Test
	public void testEORAConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      EORA		  	[Const,X]\n");
		strBuilder.append("			EORA		  	[,X]\n");
		strBuilder.append("			EORA		  	[$9,U]\n");
		strBuilder.append("			EORA		  	[$9,S]\n");
		strBuilder.append("			EORA		  	[$9,X]\n");
		strBuilder.append("			EORA		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Accumulator Indexed
	 */
	@Test
	public void testEORAAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      EORA		  	A,X\n");
		strBuilder.append("			EORA		  	B,X\n");
		strBuilder.append("			EORA		  	D,U\n");
		strBuilder.append("			EORA		  	A,S\n");
		strBuilder.append("			EORA		  	B,X\n");
		strBuilder.append("			EORA		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Accumulator Indexed Indirect
	 */
	@Test
	public void testEORAAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	EORA		  	[A,X]\n");
		strBuilder.append("			EORA		  	[B,X]\n");
		strBuilder.append("			EORA		  	[D,U]\n");
		strBuilder.append("			EORA		  	[A,S]\n");
		strBuilder.append("			EORA		  	[B,X]\n");
		strBuilder.append("			EORA		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Auto-Increment Indexed
	 */
	@Test
	public void testEORAAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	EORA		  	,--X\n");
		strBuilder.append("	       	EORA		  	,-X\n");
		strBuilder.append("	       	EORA		  	,X+\n");
		strBuilder.append("	       	EORA		  	,X++\n");
		strBuilder.append("	       	EORA		  	,--S\n");
		strBuilder.append("	       	EORA		  	,-S\n");
		strBuilder.append("	       	EORA		  	,U+\n");
		strBuilder.append("	       	EORA		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Auto-Increment Indexed Indirect
	 */
	@Test
	public void testEORAAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	EORA		  	[,--X]\n");
		strBuilder.append("	       	EORA		  	[,X++]\n");
		strBuilder.append("	       	EORA		  	[,--S]\n");
		strBuilder.append("	       	EORA		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Relative to PC Indexed
	 */
	@Test
	public void testEORARelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	EORA		  	0,PC\n");
		strBuilder.append("	       	EORA		  	,PC\n");
		strBuilder.append("	       	EORA		  	Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA Relative to PC Indexed Indirect
	 */
	@Test
	public void testEORARelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	EORA		  	[0,PC]\n");
		strBuilder.append("	       	EORA		  	[,PC]\n");
		strBuilder.append("	       	EORA		  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an BIT directive line", instructionLine.getInstruction() instanceof EorInstruction);

			EorInstruction adcInstruction = (EorInstruction) instructionLine.getInstruction();
			assertEquals("Must be an EORA instruction", adcInstruction.getInstruction(), "EORA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check EORA instruction with duplicate label
	 */
	@Test
	public void testEORAWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	EORA		  	#Const+2\n");
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
	 * Check Assembled EORA immediate instruction
	 */
	@Test
	public void testEORAImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    		ORG   		$8000\n");
		strBuilder.append("Const	   	EQU       	5\n");
		strBuilder.append("Start      	EORA		  	#Const+2  ; 8000   88 07        START:    EORA\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x88, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   88 07        START:    EORA", line.getComment());
			;
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA immediate with limit negative operand
	 */
	@Test
	public void testEORAImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	EORA		  	#-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA immediate with limit negative operand
	 */
	@Test
	public void testEORAImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	#-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA immediate with positive limit operand
	 */
	@Test
	public void testEORAImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	EORA		  	#127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA immediate with positive limit operand
	 */
	@Test
	public void testEORAImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	EORA		  	#255\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA immediate with positive limit operand
	 */
	@Test
	public void testEORAImmediatInstruction6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	EORA		  	#256\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 256 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA direct mode instruction
	 */
	@Test
	public void testEORADirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	<Const*2  ; 8000   98 0A        START:    EORA   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x98, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			;
			Assert.assertEquals("Check comment", "; 8000   98 0A        START:    EORA   <Const*2 ", line.getComment());
			;

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA direct with limit negative operand
	 */
	@Test
	public void testEORADirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA direct with limit negative operand
	 */
	@Test
	public void testEORADirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA direct with positive limit operand
	 */
	@Test
	public void testEORADirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA direct with positive limit operand
	 */
	@Test
	public void testEORADirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended mode instruction
	 */
	@Test
	public void testEORAExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	>Const*1000  ; 8000   B8 13 88     START:    EORA   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xB8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   B8 13 88     START:    EORA   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended with limit negative operand
	 */
	@Test
	public void testEORAExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended with limit negative operand
	 */
	@Test
	public void testEORAExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended with positive limit operand
	 */
	@Test
	public void testEORAExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended with positive limit operand
	 */
	@Test
	public void testEORAExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended indirect mode instruction
	 */
	@Test
	public void testEORAExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    EORA   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    EORA   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended indirect with limit negative operand
	 */
	@Test
	public void testEORAExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended indirect with limit negative operand
	 */
	@Test
	public void testEORAExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended indirect with positive limit operand
	 */
	@Test
	public void testEORAExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA extended indirect with positive limit operand
	 */
	@Test
	public void testEORAExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start       	EORA		  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(), ExpressionParser.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	A,X  ; 8000   AB 86        START:    EORA   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    EORA   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	A,Y  ; 8000   	A8 A6        START:    EORA   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A6        START:    EORA   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	A,U  ; 8000   	A8 C6        START:    EORA   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C6        START:    EORA   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	A,S  ; 8000   	A8 E6        START:    EORA   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E6        START:    EORA   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	B,X  ; 8000   AB 85        START:    EORA   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    EORA   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	B,Y  ; 8000   	A8 A5        START:    EORA   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A5        START:    EORA   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	B,U  ; 8000   	A8 C5        START:    EORA   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C5        START:    EORA   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	B,S  ; 8000   	A8 E5        START:    EORA   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E5        START:    EORA   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	D,X  ; 8000   AB 8B        START:    EORA   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    EORA   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	D,Y  ; 8000   	A8 AB        START:    EORA   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 AB        START:    EORA   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	D,U  ; 8000   	A8 CB        START:    EORA   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 CB        START:    EORA   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	D,S  ; 8000   	A8 EB        START:    EORA   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 EB        START:    EORA   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[A,X]  ; 8000   AB 96        START:    EORA   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    EORA   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[A,Y]  ; 8000   	A8 B6        START:    EORA   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B6        START:    EORA   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[A,U]  ; 8000   	A8 D6        START:    EORA   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D6        START:    EORA   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[A,S]  ; 8000   	A8 F6        START:    EORA   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F6        START:    EORA   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[B,X]  ; 8000   AB 95        START:    EORA   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    EORA   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[B,Y]  ; 8000   	A8 B5        START:    EORA   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B5        START:    EORA   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[B,U]  ; 8000   	A8 D5        START:    EORA   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D5        START:    EORA   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[B,S]  ; 8000   	A8 F5        START:    EORA   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F5        START:    EORA   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[D,X]  ; 8000   AB 9B        START:    EORA   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    EORA   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[D,Y]  ; 8000   	A8 BB        START:    EORA   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 BB        START:    EORA   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[D,U]  ; 8000   	A8 DB        START:    EORA   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 DB        START:    EORA   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testEORAIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[D,S]  ; 8000   	A8 FB        START:    EORA   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 FB        START:    EORA   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,X+  ; 8000   	A8 80        START:    EORA   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 80        START:    EORA   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,X++  ; 8000   	A8 81        START:    EORA   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 81        START:    EORA   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,Y+  ; 8000   	A8 A0        START:    EORA   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A0        START:    EORA   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,Y++  ; 8000   	A8 A1        START:    EORA   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A1        START:    EORA   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,S+  ; 8000   	A8 E0        START:    EORA   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E0        START:    EORA   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,S++  ; 8000   	A8 E1        START:    EORA   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E1        START:    EORA   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,U+  ; 8000   	A8 C0        START:    EORA   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C0        START:    EORA   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,U++  ; 8000   	A8 C1        START:    EORA   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C1        START:    EORA   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,-X  ; 8000   	A8 82        START:    EORA   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 82        START:    EORA   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,--X  ; 8000   	A8 83        START:    EORA   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 83        START:    EORA   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,-Y  ; 8000   	A8 A2        START:    EORA   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A2        START:    EORA   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,--Y  ; 8000   	A8 A3        START:    EORA   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A3        START:    EORA   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,-S  ; 8000   	A8 E2        START:    EORA   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E2        START:    EORA   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,--S  ; 8000   	A8 E3        START:    EORA   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E3        START:    EORA   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,-U  ; 8000   	A8 C2        START:    EORA   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C2        START:    EORA   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	,--U  ; 8000   	A8 C3        START:    EORA   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C3        START:    EORA   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,X+]  ; 8000   	A8 80        START:    EORA   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,X++]  ; 8000   	A8 91        START:    EORA   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 91        START:    EORA   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,Y+]  ; 8000   	A8 A0        START:    EORA   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,Y++]  ; 8000   	A8 B1        START:    EORA   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B1        START:    EORA   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,S+]  ; 8000   	A8 E0        START:    EORA   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,S++]  ; 8000   	A8 F1        START:    EORA   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F1        START:    EORA   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,U+]  ; 8000   	A8 C0        START:    EORA   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,U++]  ; 8000   	A8 D1        START:    EORA   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D1        START:    EORA   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,-X]  ; 8000   	A8 82        START:    EORA   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,--X]  ; 8000   	A8 93        START:    EORA   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 93        START:    EORA   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,-Y]  ; 8000   	A8 A2        START:    EORA   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,--Y]  ; 8000   	A8 B3        START:    EORA   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B3        START:    EORA   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,-S]  ; 8000   	A8 E2        START:    EORA   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,--S]  ; 8000   	A8 F3        START:    EORA   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F3        START:    EORA   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,-U]  ; 8000   	A8 C2        START:    EORA   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testEORAIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	EORA		  	[,--U]  ; 8000   	A8 D3        START:    EORA   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D3        START:    EORA   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1234,X  ; 8000   	A8 89 04 D2            EORA   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 89 04 D2            EORA   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1234,Y  ; 8000   	AB A9 04 D2            EORA   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 04 D2            EORA   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1234,U  ; 8000   	A8 C9 04 D2            EORA   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C9 04 D2            EORA   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1234,S  ; 8000   	A8 E9 04 D2            EORA   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E9 04 D2            EORA   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	34,X  ; 8000   	A8 88 22            EORA   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 88 22            EORA   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	34,Y  ; 8000   	A8 A8 22            EORA   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A8 22            EORA   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	34,U  ; 8000   	A8 C8 22            EORA   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C8 22            EORA   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	34,S  ; 8000   	A8 E8 22            EORA   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E8 22            EORA   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	,X  ; 8000   	A8 84            EORA   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 84            EORA   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	,Y  ; 8000   	A8 A4            EORA   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A4            EORA   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	,U  ; 8000   	A8 C4            EORA   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C4            EORA   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	,S  ; 8000   	A8 E4            EORA   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E4            EORA   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	0,X  ; 8000   	A8 84            EORA   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 84            EORA   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	0,Y  ; 8000   	A8 A4            EORA   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A4            EORA   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	0,U  ; 8000   	A8 C4            EORA   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C4            EORA   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	0,S  ; 8000   	A8 E4            EORA   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E4            EORA   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-16,X  ; 8000   	A8 10            EORA   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 10            EORA   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1,X  ; 8000   	A8 01            EORA   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 01            EORA   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	15,X  ; 8000   	A8 0F            EORA   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 0F            EORA   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-16,Y  ; 8000   	A8 30            EORA   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 30            EORA   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1,Y  ; 8000   	A8 21            EORA   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 21            EORA   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	15,Y  ; 8000   	A8 2F            EORA   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 2F            EORA   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-16,U  ; 8000   	A8 50            EORA   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 50            EORA   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1,U  ; 8000   	A8 41            EORA   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 41            EORA   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	15,U  ; 8000   	A8 4F            EORA   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 4F            EORA   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-16,S  ; 8000   	A8 70            EORA   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 70            EORA   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	1,S  ; 8000   	A8 61            EORA   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 61            EORA   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	15,S  ; 8000   	A8 6F            EORA   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 6F            EORA   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-128,X  ; 8000   	A8 88 80            EORA   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 88 80            EORA   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	127,X  ; 8000   	A8 88 7F            EORA   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 88 7F            EORA   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-128,Y  ; 8000   	A8 A8 80            EORA   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A8 80            EORA   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	127,Y  ; 8000   	A8 A8 7F            EORA   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 A8 7F            EORA   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-128,U  ; 8000   	A8 C8 80            EORA   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C8 80            EORA   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	127,U  ; 8000   	A8 C8 7F            EORA   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C8 7F            EORA   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-128,S  ; 8000   	A8 E8 80            EORA   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E8 80            EORA   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	127,S  ; 8000   	A8 E8 7F            EORA   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E8 7F            EORA   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32768,X  ; 8000   	A8 89 80 00             EORA   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 89 80 00             EORA   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32767,X  ; 8000   	A8 89 7F FF             EORA   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 89 7F FF             EORA   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32768,Y  ; 8000   	AB A9 80 00             EORA   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             EORA   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32767,Y  ; 8000   	AB A9 7F FF             EORA   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             EORA   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32768,U  ; 8000   	A8 C9 80 00             EORA   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C9 80 00             EORA   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32767,U  ; 8000   	A8 C9 7F FF             EORA   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C9 7F FF             EORA   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32768,S  ; 8000   	A8 E9 80 00             EORA   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E9 80 00             EORA   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32767,S  ; 8000   	A8 E9 7F FF             EORA   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E9 7F FF             EORA   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32769,X  ; 8000   	A8 89 80 00             EORA   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 89 80 00             EORA   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32768,X  ; 8000   	A8 89 7F FF             EORA   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 89 7F FF             EORA   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32769,Y  ; 8000   	AB A9 80 00             EORA   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 80 00             EORA   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32768,Y  ; 8000   	AB A9 7F FF             EORA   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	AB A9 7F FF             EORA   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32769,U  ; 8000   	A8 C9 80 00             EORA   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C9 80 00             EORA   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32768,U  ; 8000   	A8 C9 7F FF             EORA   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 C9 7F FF             EORA   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32769,S  ; 8000   	A8 E9 80 00             EORA   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E9 80 00             EORA   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  32768,S  ; 8000   	A8 E9 7F FF             EORA   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 E9 7F FF             EORA   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[1234,X]  ; 8000   	A8 99 04 D2            EORA   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 99 04 D2            EORA   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[1234,Y]  ; 8000   	A8 B9 04 D2            EORA   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B9 04 D2            EORA   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[1234,U]  ; 8000   	A8 D9 04 D2            EORA   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D9 04 D2            EORA   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[1234,S]  ; 8000   	A8 F9 04 D2            EORA   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F9 04 D2            EORA   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[34,X]  ; 8000   	A8 98 22            EORA   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 98 22            EORA   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[34,Y]  ; 8000   	A8 B8 22            EORA   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B8 22            EORA   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[34,U]  ; 8000   	A8 D8 22            EORA   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D8 22            EORA   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[34,S]  ; 8000   	A8 F8 22            EORA   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F8 22            EORA   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[,X]  ; 8000   	A8 94            EORA   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 94            EORA   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[,Y]  ; 8000   	A8 B4            EORA   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B4            EORA   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[,U]  ; 8000   	A8 D4            EORA   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D4            EORA   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[,S]  ; 8000   	A8 F4            EORA   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F4            EORA   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[0,X]  ; 8000   	A8 94            EORA   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 94            EORA   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[0,Y]  ; 8000   	A8 B4            EORA   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B4            EORA   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[0,U]  ; 8000   	A8 D4            EORA   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D4            EORA   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[0,S]  ; 8000   	A8 F4            EORA   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F4            EORA   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-16,X]  ; 8000   	A8 98 F0            EORA   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 98 F0            EORA   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[15,X]  ; 8000   	A8 98 0F            EORA   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 98 0F            EORA   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-16,Y]  ; 8000   	A8 B8 F0            EORA   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B8 F0            EORA   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[15,Y]  ; 8000   	A8 B8 0F            EORA   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B8 0F            EORA   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-16,U]  ; 8000   	A8 D8 F0            EORA   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D8 F0            EORA   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[15,U]  ; 8000   	A8 D8 0F            EORA   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D8 0F            EORA   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-16,S]  ; 8000   	A8 F8 F0            EORA   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F8 F0            EORA   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[15,S]  ; 8000   	A8 F8 0F            EORA   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F8 0F            EORA   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-128,X]  ; 8000   	A8 98 80            EORA   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 98 80            EORA   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[127,X]  ; 8000   	A8 98 7F            EORA   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 98 7F            EORA   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-128,Y]  ; 8000   	A8 B8 80            EORA   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B8 80            EORA   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[127,Y]  ; 8000   	A8 B8 7F            EORA   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B8 7F            EORA   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-128,U]  ; 8000   	A8 D8 80            EORA   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D8 80            EORA   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[127,U]  ; 8000   	A8 D8 7F            EORA   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D8 7F            EORA   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-128,S]  ; 8000   	A8 F8 80            EORA   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F8 80            EORA   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[127,S]  ; 8000   	A8 F8 7F            EORA   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F8 7F            EORA   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768,X]  ; 8000   	A8 99 80 00             EORA   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 99 80 00             EORA   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32767,X]  ; 8000   	A8 99 7F FF             EORA   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 99 7F FF             EORA   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768,Y]  ; 8000   	A8 B9 80 00             EORA   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B9 80 00             EORA   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32767,Y]  ; 8000   	A8 B9 7F FF             EORA   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B9 7F FF             EORA   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768,U]  ; 8000   	A8 D9 80 00             EORA   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D9 80 00             EORA   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32767,U]  ; 8000   	A8 D9 7F FF             EORA   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D9 7F FF             EORA   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768,S]  ; 8000   	A8 F9 80 00             EORA   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F9 80 00             EORA   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32767,S]  ; 8000   	A8 F9 7F FF             EORA   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F9 7F FF             EORA   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769,X]  ; 8000   	A8 99 80 00             EORA   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 99 80 00             EORA   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32768,X]  ; 8000   	A8 99 7F FF             EORA   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 99 7F FF             EORA   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769,Y]  ; 8000   	A8 B9 80 00             EORA   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B9 80 00             EORA   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32768,Y]  ; 8000   	A8 B9 7F FF             EORA   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 B9 7F FF             EORA   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769,U]  ; 8000   	A8 D9 80 00             EORA   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D9 80 00             EORA   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32768,U]  ; 8000   	A8 D9 7F FF             EORA   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 D9 7F FF             EORA   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769,S]  ; 8000   	A8 F9 80 00             EORA   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F9 80 00             EORA   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testEORAIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  [32768,S]  ; 8000   	A8 F9 7F FF             EORA   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 F9 7F FF             EORA   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	0,PCR  ; 8000   	A8 8C 00            EORA   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8C 00            EORA   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-128,PCR  ; 8000   	A8 8C 80            EORA   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8C 80            EORA   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	127,PCR  ; 8000   	A8 8C 7F            EORA   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8C 7F            EORA   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-129,PCR  ; 8000   	A8 8D FF 7F            EORA   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D FF 7F            EORA   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	128,PCR  ; 8000   	A8 8D 00 80            EORA   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D 00 80            EORA   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32768,PCR  ; 8000   	A8 8D 80 00            EORA   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D 80 00            EORA   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	32767,PCR  ; 8000   	A8 8D 7F FF            EORA   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D 7F FF            EORA   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	-32769,PCR  ; 8000   	A8 8D 80 00            EORA   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D 80 00            EORA   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	32768,PCR  ; 8000   	A8 8D 7F FF            EORA   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 8D 7F FF            EORA   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[0,PCR]  ; 8000   	A8 9C 00            EORA   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9C 00            EORA   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-128,PCR]  ; 8000   	A8 9C 80            EORA   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9C 80            EORA   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[127,PCR]  ; 8000   	A8 9C 7F            EORA   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9C 7F            EORA   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-129,PCR]  ; 8000   	A8 9D FF 7F            EORA   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D FF 7F            EORA   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[128,PCR]  ; 8000   	A8 9D 00 80            EORA   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D 00 80            EORA   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32768,PCR]  ; 8000   	A8 9D 80 00            EORA   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D 80 00            EORA   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[32767,PCR]  ; 8000   	A8 9D 7F FF            EORA   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D 7F FF            EORA   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[-32769,PCR]  ; 8000   	A8 9D 80 00            EORA   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D 80 00            EORA   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled EORA Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testEORAIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	EORA		  	[32768,PCR]  ; 8000   	A8 9D 7F FF            EORA   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getEorInstruction(),
					AbstractInstructionAssemblyLine.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledEORAInstruction line = (AssembledEORAInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0xA8, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A8 9D 7F FF            EORA   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}