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
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode;
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode;
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledROLInstruction;
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

public class TestROLInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check ROL immediat
	 */
	@Test
	public void testROLImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			ROL		#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_MODE,
					"Immediate mode is not valid for the ROL instruction"
				);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL direct mode
	 */
	@Test
	public void testROLDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ROL		  	<124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL extended mode
	 */
	@Test
	public void testROLExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ROL		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL extended mode
	 */
	@Test
	public void testROLExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ROL		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL extended indirect mode
	 */
	@Test
	public void testROLExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ROL		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Constant-Offset Indexed
	 */
	@Test
	public void testROLConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      ROL		  	Const,X\n");
		strBuilder.append("			ROL		  	,X\n");
		strBuilder.append("			ROL		  	$9,U\n");
		strBuilder.append("			ROL		  	$9,S\n");
		strBuilder.append("			ROL		  	$9,X\n");
		strBuilder.append("			ROL		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Constant-Offset Indexed indirect
	 */
	@Test
	public void testROLConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      ROL		  	[Const,X]\n");
		strBuilder.append("			ROL		  	[,X]\n");
		strBuilder.append("			ROL		  	[$9,U]\n");
		strBuilder.append("			ROL		  	[$9,S]\n");
		strBuilder.append("			ROL		  	[$9,X]\n");
		strBuilder.append("			ROL		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Accumulator Indexed
	 */
	@Test
	public void testROLAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      ORG  			$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	      ROL		  	A,X\n");
		strBuilder.append("			ROL		  	B,X\n");
		strBuilder.append("			ROL		  	D,U\n");
		strBuilder.append("			ROL		  	A,S\n");
		strBuilder.append("			ROL		  	B,X\n");
		strBuilder.append("			ROL		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Accumulator Indexed Indirect
	 */
	@Test
	public void testROLAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	ROL		  	[A,X]\n");
		strBuilder.append("			ROL		  	[B,X]\n");
		strBuilder.append("			ROL		  	[D,U]\n");
		strBuilder.append("			ROL		  	[A,S]\n");
		strBuilder.append("			ROL		  	[B,X]\n");
		strBuilder.append("			ROL		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Auto-Increment Indexed
	 */
	@Test
	public void testROLAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	ROL		  	,--X\n");
		strBuilder.append("	       	ROL		  	,-X\n");
		strBuilder.append("	       	ROL		  	,X+\n");
		strBuilder.append("	       	ROL		  	,X++\n");
		strBuilder.append("	       	ROL		  	,--S\n");
		strBuilder.append("	       	ROL		  	,-S\n");
		strBuilder.append("	       	ROL		  	,U+\n");
		strBuilder.append("	       	ROL		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Auto-Increment Indexed Indirect
	 */
	@Test
	public void testROLAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	ROL		  	[,--X]\n");
		strBuilder.append("	       	ROL		  	[,X++]\n");
		strBuilder.append("	       	ROL		  	[,--S]\n");
		strBuilder.append("	       	ROL		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Relative to PC Indexed
	 */
	@Test
	public void testROLRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	ROL		  	0,PC\n");
		strBuilder.append("	       	ROL		  	,PC\n");
		strBuilder.append("	       	ROL		  	Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL Relative to PC Indexed Indirect
	 */
	@Test
	public void testROLRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	ROL		  	[0,PC]\n");
		strBuilder.append("	       	ROL		  	[,PC]\n");
		strBuilder.append("	       	ROL		  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an ADD directive line", instructionLine.getInstruction() instanceof RolInstruction);

			RolInstruction adcInstruction = (RolInstruction) instructionLine.getInstruction();
			assertEquals("Must be an ROL instruction", adcInstruction.getInstruction(), "ROL");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) adcInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ROL instruction with duplicate label
	 */
	@Test
	public void testROLWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	ROL		  	#Const+2\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(), AssemblerEngine.DUPLICATE_LABEL,
					"Label Start is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL direct mode instruction
	 */
	@Test
	public void testROLDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  		<Const*2  ; 8000   09 0A        START:    ROL   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x09, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   09 0A        START:    ROL   <Const*2 ", line.getComment());
	
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL direct with limit negative operand
	 */
	@Test
	public void testROLDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL direct with limit negative operand
	 */
	@Test
	public void testROLDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL direct with positive limit operand
	 */
	@Test
	public void testROLDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL direct with positive limit operand
	 */
	@Test
	public void testROLDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended mode instruction
	 */
	@Test
	public void testROLExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  		>Const*1000  ; 8000   79 13 88     START:    ROL   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x79, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check Comment", "; 8000   79 13 88     START:    ROL   >Const*1000 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended with limit negative operand
	 */
	@Test
	public void testROLExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended with limit negative operand
	 */
	@Test
	public void testROLExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended with positive limit operand
	 */
	@Test
	public void testROLExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended with positive limit operand
	 */
	@Test
	public void testROLExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended indirect mode instruction
	 */
	@Test
	public void testROLExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[Const*1000]  ; 8000   68 9F 13 88  START:    ROL   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check getOpcode()", 0x9F, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 9F 13 88  START:    ROL   [Const*1000]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended indirect with limit negative operand
	 */
	@Test
	public void testROLExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended indirect with limit negative operand
	 */
	@Test
	public void testROLExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended indirect with positive limit operand
	 */
	@Test
	public void testROLExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL extended indirect with positive limit operand
	 */
	@Test
	public void testROLExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		    	ORG    			$8000\n");
		strBuilder.append("Start       	ROL		  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(), InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  		A,X  ; 8000   68 86        START:    ROL   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 86        START:    ROL   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	A,Y  ; 8000   	69 A6        START:    ROL   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A6        START:    ROL   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	A,U  ; 8000   	69 C6        START:    ROL   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C6        START:    ROL   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	A,S  ; 8000   	69 E6        START:    ROL   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E6        START:    ROL   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	B,X  ; 8000   68 85        START:    ROL   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 85        START:    ROL   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	B,Y  ; 8000   	69 A5        START:    ROL   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A5        START:    ROL   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	B,U  ; 8000   	69 C5        START:    ROL   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C5        START:    ROL   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	B,S  ; 8000   	69 E5        START:    ROL   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E5        START:    ROL   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	D,X  ; 8000   68 8B        START:    ROL   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 8B        START:    ROL   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	D,Y  ; 8000   	69 AB        START:    ROL   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 AB        START:    ROL   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	D,U  ; 8000   	69 CB        START:    ROL   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 CB        START:    ROL   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	D,S  ; 8000   	69 EB        START:    ROL   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 EB        START:    ROL   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[A,X]  ; 8000   68 96        START:    ROL   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 96        START:    ROL   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[A,Y]  ; 8000   	69 B6        START:    ROL   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B6        START:    ROL   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[A,U]  ; 8000   	69 D6        START:    ROL   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D6        START:    ROL   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[A,S]  ; 8000   	69 F6        START:    ROL   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F6        START:    ROL   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[B,X]  ; 8000   68 95        START:    ROL   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 95        START:    ROL   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[B,Y]  ; 8000   	69 B5        START:    ROL   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B5        START:    ROL   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[B,U]  ; 8000   	69 D5        START:    ROL   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D5        START:    ROL   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[B,S]  ; 8000   	69 F5        START:    ROL   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F5        START:    ROL   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[D,X]  ; 8000   68 9B        START:    ROL   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   68 9B        START:    ROL   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[D,Y]  ; 8000   	69 BB        START:    ROL   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 BB        START:    ROL   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[D,U]  ; 8000   	69 DB        START:    ROL   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 DB        START:    ROL   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testROLIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[D,S]  ; 8000   	69 FB        START:    ROL   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 FB        START:    ROL   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,X+  ; 8000   	69 80        START:    ROL   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 80        START:    ROL   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,X++  ; 8000   	69 81        START:    ROL   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 81        START:    ROL   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,Y+  ; 8000   	69 A0        START:    ROL   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A0        START:    ROL   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,Y++  ; 8000   	69 A1        START:    ROL   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A1        START:    ROL   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,S+  ; 8000   	69 E0        START:    ROL   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E0        START:    ROL   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,S++  ; 8000   	69 E1        START:    ROL   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E1        START:    ROL   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,U+  ; 8000   	69 C0        START:    ROL   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C0        START:    ROL   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,U++  ; 8000   	69 C1        START:    ROL   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C1        START:    ROL   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,-X  ; 8000   	69 82        START:    ROL   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 82        START:    ROL   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,--X  ; 8000   	69 83        START:    ROL   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 83        START:    ROL   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,-Y  ; 8000   	69 A2        START:    ROL   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A2        START:    ROL   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,--Y  ; 8000   	69 A3        START:    ROL   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A3        START:    ROL   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,-S  ; 8000   	69 E2        START:    ROL   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E2        START:    ROL   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,--S  ; 8000   	69 E3        START:    ROL   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E3        START:    ROL   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,-U  ; 8000   	69 C2        START:    ROL   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C2        START:    ROL   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	,--U  ; 8000   	69 C3        START:    ROL   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C3        START:    ROL   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,X+]  ; 8000   	69 80        START:    ROL   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,X++]  ; 8000   	69 91        START:    ROL   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 91        START:    ROL   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,Y+]  ; 8000   	69 A0        START:    ROL   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,Y++]  ; 8000   	69 B1        START:    ROL   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B1        START:    ROL   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,S+]  ; 8000   	69 E0        START:    ROL   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,S++]  ; 8000   	69 F1        START:    ROL   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F1        START:    ROL   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,U+]  ; 8000   	69 C0        START:    ROL   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT, "Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,U++]  ; 8000   	69 D1        START:    ROL   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D1        START:    ROL   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,-X]  ; 8000   	69 82        START:    ROL   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,--X]  ; 8000   	69 93        START:    ROL   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 93        START:    ROL   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  		[,-Y]  ; 8000   	69 A2        START:    ROL   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,--Y]  ; 8000   	69 B3        START:    ROL   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B3        START:    ROL   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,-S]  ; 8000   	69 E2        START:    ROL   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,--S]  ; 8000   	69 F3        START:    ROL   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F3        START:    ROL   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,-U]  ; 8000   	69 C2        START:    ROL   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT, "Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testROLIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ROL		  	[,--U]  ; 8000   	69 D3        START:    ROL   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D3        START:    ROL   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1234,X  ; 8000   	69 89 04 D2            ROL   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 89 04 D2            ROL   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1234,Y  ; 8000   	67 A9 04 D2            ROL   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 04 D2            ROL   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1234,U  ; 8000   	69 C9 04 D2            ROL   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C9 04 D2            ROL   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1234,S  ; 8000   	69 E9 04 D2            ROL   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E9 04 D2            ROL   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	34,X  ; 8000   	69 88 22            ROL   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 88 22            ROL   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	34,Y  ; 8000   	69 A8 22            ROL   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A8 22            ROL   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	34,U  ; 8000   	69 C8 22            ROL   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C8 22            ROL   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	34,S  ; 8000   	69 E8 22            ROL   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E8 22            ROL   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	,X  ; 8000   	69 84            ROL   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 84            ROL   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	,Y  ; 8000   	69 A4            ROL   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A4            ROL   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	,U  ; 8000   	69 C4            ROL   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C4            ROL   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	,S  ; 8000   	69 E4            ROL   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E4            ROL   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	0,X  ; 8000   	69 84            ROL   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 84            ROL   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	0,Y  ; 8000   	69 A4            ROL   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A4            ROL   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	0,U  ; 8000   	69 C4            ROL   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C4            ROL   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	0,S  ; 8000   	69 E4            ROL   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E4            ROL   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-16,X  ; 8000   	69 10            ROL   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 10            ROL   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1,X  ; 8000   	69 01            ROL   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 01            ROL   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	15,X  ; 8000   	69 0F            ROL   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 0F            ROL   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-16,Y  ; 8000   	69 30            ROL   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 30            ROL   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1,Y  ; 8000   	69 21            ROL   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 21            ROL   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	15,Y  ; 8000   	69 2F            ROL   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 2F            ROL   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-16,U  ; 8000   	69 50            ROL   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 50            ROL   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1,U  ; 8000   	69 41            ROL   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 41            ROL   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	15,U  ; 8000   	69 4F            ROL   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 4F            ROL   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-16,S  ; 8000   	69 70            ROL   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 70            ROL   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	1,S  ; 8000   	69 61            ROL   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 61            ROL   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	15,S  ; 8000   	69 6F            ROL   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 6F            ROL   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-128,X  ; 8000   	69 88 80            ROL   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 88 80            ROL   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	127,X  ; 8000   	69 88 7F            ROL   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 88 7F            ROL   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-128,Y  ; 8000   	69 A8 80            ROL   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A8 80            ROL   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	127,Y  ; 8000   	69 A8 7F            ROL   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 A8 7F            ROL   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-128,U  ; 8000   	69 C8 80            ROL   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C8 80            ROL   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	127,U  ; 8000   	69 C8 7F            ROL   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C8 7F            ROL   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-128,S  ; 8000   	69 E8 80            ROL   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E8 80            ROL   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	127,S  ; 8000   	69 E8 7F            ROL   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E8 7F            ROL   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32768,X  ; 8000   	69 89 80 00             ROL   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 89 80 00             ROL   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32767,X  ; 8000   	69 89 7F FF             ROL   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 89 7F FF             ROL   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32768,Y  ; 8000   	67 A9 80 00             ROL   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 80 00             ROL   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32767,Y  ; 8000   	67 A9 7F FF             ROL   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 7F FF             ROL   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32768,U  ; 8000   	69 C9 80 00             ROL   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C9 80 00             ROL   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32767,U  ; 8000   	69 C9 7F FF             ROL   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C9 7F FF             ROL   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32768,S  ; 8000   	69 E9 80 00             ROL   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E9 80 00             ROL   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32767,S  ; 8000   	69 E9 7F FF             ROL   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E9 7F FF             ROL   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32769,X  ; 8000   	69 89 80 00             ROL   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 89 80 00             ROL   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32768,X  ; 8000   	69 89 7F FF             ROL   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 89 7F FF             ROL   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32769,Y  ; 8000   	67 A9 80 00             ROL   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 80 00             ROL   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32768,Y  ; 8000   	67 A9 7F FF             ROL   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	67 A9 7F FF             ROL   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32769,U  ; 8000   	69 C9 80 00             ROL   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C9 80 00             ROL   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32768,U  ; 8000   	69 C9 7F FF             ROL   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 C9 7F FF             ROL   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32769,S  ; 8000   	69 E9 80 00             ROL   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E9 80 00             ROL   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  32768,S  ; 8000   	69 E9 7F FF             ROL   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 E9 7F FF             ROL   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[1234,X]  ; 8000   	69 99 04 D2            ROL   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 99 04 D2            ROL   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[1234,Y]  ; 8000   	69 B9 04 D2            ROL   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B9 04 D2            ROL   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[1234,U]  ; 8000   	69 D9 04 D2            ROL   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D9 04 D2            ROL   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[1234,S]  ; 8000   	69 F9 04 D2            ROL   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F9 04 D2            ROL   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[34,X]  ; 8000   	69 98 22            ROL   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 98 22            ROL   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[34,Y]  ; 8000   	69 B8 22            ROL   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B8 22            ROL   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[34,U]  ; 8000   	69 D8 22            ROL   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D8 22            ROL   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[34,S]  ; 8000   	69 F8 22            ROL   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F8 22            ROL   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[,X]  ; 8000   	69 94            ROL   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 94            ROL   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[,Y]  ; 8000   	69 B4            ROL   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B4            ROL   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[,U]  ; 8000   	69 D4            ROL   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D4            ROL   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[,S]  ; 8000   	69 F4            ROL   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F4            ROL   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[0,X]  ; 8000   	69 94            ROL   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 94            ROL   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[0,Y]  ; 8000   	69 B4            ROL   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B4            ROL   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[0,U]  ; 8000   	69 D4            ROL   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D4            ROL   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[0,S]  ; 8000   	69 F4            ROL   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F4            ROL   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-16,X]  ; 8000   	69 98 F0            ROL   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 98 F0            ROL   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[15,X]  ; 8000   	69 98 0F            ROL   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 98 0F            ROL   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-16,Y]  ; 8000   	69 B8 F0            ROL   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B8 F0            ROL   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[15,Y]  ; 8000   	69 B8 0F            ROL   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B8 0F            ROL   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-16,U]  ; 8000   	69 D8 F0            ROL   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D8 F0            ROL   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[15,U]  ; 8000   	69 D8 0F            ROL   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D8 0F            ROL   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-16,S]  ; 8000   	69 F8 F0            ROL   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F8 F0            ROL   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[15,S]  ; 8000   	69 F8 0F            ROL   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F8 0F            ROL   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-128,X]  ; 8000   	69 98 80            ROL   [-128,X}\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 98 80            ROL   [-128,X}", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[127,X]  ; 8000   	69 98 7F            ROL   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 98 7F            ROL   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-128,Y]  ; 8000   	69 B8 80            ROL   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B8 80            ROL   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[127,Y]  ; 8000   	69 B8 7F            ROL   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B8 7F            ROL   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-128,U]  ; 8000   	69 D8 80            ROL   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D8 80            ROL   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[127,U]  ; 8000   	69 D8 7F            ROL   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D8 7F            ROL   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-128,S]  ; 8000   	69 F8 80            ROL   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F8 80            ROL   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[127,S]  ; 8000   	69 F8 7F            ROL   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F8 7F            ROL   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768,X]  ; 8000   	69 99 80 00             ROL   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 99 80 00             ROL   [-32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32767,X]  ; 8000   	69 99 7F FF             ROL   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 99 7F FF             ROL   [32767,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768,Y]  ; 8000   	69 B9 80 00             ROL   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B9 80 00             ROL   [-32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32767,Y]  ; 8000   	69 B9 7F FF             ROL   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B9 7F FF             ROL   [32767,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768,U]  ; 8000   	69 D9 80 00             ROL   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D9 80 00             ROL   [-32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32767,U]  ; 8000   	69 D9 7F FF             ROL   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D9 7F FF             ROL   [32767,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768,S]  ; 8000   	69 F9 80 00             ROL   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F9 80 00             ROL   [-32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32767,S]  ; 8000   	69 F9 7F FF             ROL   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F9 7F FF             ROL   [32767,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769,X]  ; 8000   	69 99 80 00             ROL   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 99 80 00             ROL   [-32769,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32768,X]  ; 8000   	69 99 7F FF             ROL   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 99 7F FF             ROL   [32768,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769,Y]  ; 8000   	69 B9 80 00             ROL   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B9 80 00             ROL   [-32769,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32768,Y]  ; 8000   	69 B9 7F FF             ROL   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 B9 7F FF             ROL   [32768,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769,U]  ; 8000   	69 D9 80 00             ROL   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D9 80 00             ROL   [-32769,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32768,U]  ; 8000   	69 D9 7F FF             ROL   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 D9 7F FF             ROL   [32768,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769,S]  ; 8000   	69 F9 80 00             ROL   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F9 80 00             ROL   [-32769,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testROLIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  [32768,S]  ; 8000   	69 F9 7F FF             ROL   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 F9 7F FF             ROL   [32768,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	0,PCR  ; 8000   	69 8C 00            ROL   0,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8C 00            ROL   0,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-128,PCR  ; 8000   	69 8C 80            ROL   -128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8C 80            ROL   -128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	127,PCR  ; 8000   	69 8C 7F            ROL   127,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8C 7F            ROL   127,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-129,PCR  ; 8000   	69 8D FF 7F            ROL   -129,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D FF 7F            ROL   -129,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	128,PCR  ; 8000   	69 8D 00 80            ROL   128,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D 00 80            ROL   128,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32768,PCR  ; 8000   	69 8D 80 00            ROL   -32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D 80 00            ROL   -32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	32767,PCR  ; 8000   	69 8D 7F FF            ROL   32767,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D 7F FF            ROL   32767,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	-32769,PCR  ; 8000   	69 8D 80 00            ROL   -32769,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D 80 00            ROL   -32769,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	32768,PCR  ; 8000   	69 8D 7F FF            ROL   32768,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 8D 7F FF            ROL   32768,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[0,PCR]  ; 8000   	69 9C 00            ROL   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9C 00            ROL   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-128,PCR]  ; 8000   	69 9C 80            ROL   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9C 80            ROL   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[127,PCR]  ; 8000   	69 9C 7F            ROL   [127,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9C 7F            ROL   [127,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-129,PCR]  ; 8000   	69 9D FF 7F            ROL   [-129,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D FF 7F            ROL   [-129,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[128,PCR]  ; 8000   	69 9D 00 80            ROL   [128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D 00 80            ROL   [128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32768,PCR]  ; 8000   	69 9D 80 00            ROL   [-32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D 80 00            ROL   [-32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[32767,PCR]  ; 8000   	69 9D 7F FF            ROL   [32767,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D 7F FF            ROL   [32767,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[-32769,PCR]  ; 8000   	69 9D 80 00            ROL   [-32769,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D 80 00            ROL   [-32769,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Assembled ROL Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testROLIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    			$8000\n");
		strBuilder.append("Start      	ROL		  	[32768,PCR]  ; 8000   	69 9D 7F FF            ROL   [32768,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRolInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledROLInstruction line = (AssembledROLInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x69, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	69 9D 7F FF            ROL   [32768,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}